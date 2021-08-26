package org.generation.blogPessoal.model;

import java.util.Date;
import javax.persistence.Entity;//Essa classe e uma entidade do hibernate
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;//se torna tabela
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Anotações = parametros que colocamos em cima das classes ou das propriedades que definem comportamentos para elas
@Entity
@Table(name = "Postagem")//nome da tabela
public class Postagem {
	
	@Id//id da postagem
	@GeneratedValue(strategy = GenerationType.IDENTITY)//como vai se comportar dentro do bd//PrimeryKey
	private long id;//auto incremento
	
	@NotNull//Não pode vir nenhum titulo vazio
	@Size(min = 5, max = 100)//determina quantos caracteres o cliente consegui enviar para nós como titulo
	private String titulo;
	
	@NotNull
	@Size(min = 10, max =500)//Quantidade de caracteres liberado por nós
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)//Estamos trabalhando com tempo
	private Date data = new java.sql.Date(System.currentTimeMillis());//Assim que passar qualquer dados, ele vai registrar, o tempo de registro
	
	
	//Duas entidades tanto Tema quanto Postagem criem um relacionamento
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {//sem retorno
		this.id = id;
	}
	public String getTitulo() {//retorno
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDate() {
		return data;
	}
	public void setDate(Date date) {
		this.data = date;
	}
	
}//azul = classe
//verde = metodo
//laranja = reservado//
