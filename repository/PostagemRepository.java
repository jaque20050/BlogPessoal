package org.generation.blogPessoal.repository;

import java.util.List;
import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//indica que essa classe e um repositorio
public interface PostagemRepository extends JpaRepository<Postagem,Long>{
         
	public List<Postagem>findAllByTituloContainingIgnoreCase(String titulo);//consulta do titulo da postagem
	//FindAll = Busca todos "titulo" = pelo titulo
	//Contain = E a mesma coisa do Like, tudo que conter os caracter que tenho dentro da variavel, vai mostrar
	//IgnoreCase = Não levar em consideração maisculo e minisculo, ou seja pega tudo e padroniza em minisculo e vai fazer a busca
	//nesse parametro (String titulo)//
}
