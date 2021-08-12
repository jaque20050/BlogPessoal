package org.generation.blogPessoal.seguranca;
/*
 * @author Jaqueline
 */
import java.util.Optional;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Optional<Usuario>user = userRepository.findByUsuario(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));//vai retornar um 401, pois não está permitido o acesso
		return user.map(UserDetailsImpl:: new).get();
	}
	//Camada de service = regra de negocio indicando que o usuario ao se cadastrar, precisa ser inserida no 
	//banco de dados e ser criptografada
}
