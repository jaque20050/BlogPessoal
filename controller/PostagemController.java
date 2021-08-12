package org.generation.blogPessoal.controller;

import java.util.List;
import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Informa que está classe em um controlador
@RequestMapping("/postagem")//Vai definir qual a URI que essa classe sera acessada
@CrossOrigin("*")//Essa classe vai aceitar requesição qualquer origem 
public class PostagemController {
	
	@Autowired//garante que todos serviços dessa interface repository seja acessado a partir do  controller
	private PostagemRepository repository;
	
	@GetMapping//expor para API que se trata de um GET
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")//Busca por ID, determina o  metodo http para ser enviada a nossa API
	public ResponseEntity<Postagem>GetById(@PathVariable(value ="id")long id){//Vamos retornar um unico objeto do tipo POSTAGEM//Metodo = GetById
		//@PathVariable = pega o valor que vem do URL
		return ResponseEntity.status(200).body(repository.findById(id).get());//findById = ira retornar um status na rede
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>>GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		//Nesta parte, ele ira puxar no Postman no titulo inserido no MySQL e mostrar em tela
	}
	@PostMapping("/criar")//Salvar dentro do servidor
	public ResponseEntity<Postagem>post(@RequestBody Postagem novapostagem){//Inserção
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novapostagem));
	}
	@PutMapping("/salvar")
	public ResponseEntity<Postagem>put(@RequestBody Postagem Postagem){//Atualização
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Postagem));
   }
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {// como ele e um VOID não precisa retornar 
		repository.deleteById(id);
	}
}
//@RequestBody = pega pela body
//construtor e sobrecarga de metodo pesquisar//