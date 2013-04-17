package br.com.chat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private StringBuilder conversa;
	private List<Users> users = new ArrayList<Users>();
	
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

	public StringBuilder getConversa() {
		return conversa;
	}

	public void setConversa(StringBuilder conversa) {
		this.conversa = conversa; 
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}  

	@Override
	public String toString() {
		return nome;
	}
	
	
	
}
