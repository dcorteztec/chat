package br.com.chat.model;

public class Room {

	private Integer id;
	private String nome;
	
	
	public Room() {
		
	}
	
    public Room(String nome) {
		this.nome=nome;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}