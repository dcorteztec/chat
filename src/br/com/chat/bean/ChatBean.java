package br.com.chat.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.chat.model.Room;
import br.com.chat.model.Users;

@ManagedBean
@SessionScoped
public class ChatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String apelido;
	private String mensagem;
	private List<Room> salas = new ArrayList<Room>();
	private String sala;
	private Users users = new Users();
	
	@ManagedProperty(value = "#{salaChatBean}")
	private SalaChatBean salaChat; 

	public void setSalaChat(SalaChatBean salaChat) {
		this.salaChat = salaChat;
	}
	
	public ChatBean() {
		Room selectItem = new Room("Esporte");
		Room selectItem2 = new Room("Filme");
		salas.add(selectItem);
		salas.add(selectItem2);  
		
	} 


	public String entrar() throws IOException {  
		if ((users.getName() == "") || (users.getName().isEmpty())) {   
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Campo", "apelido não pode ser vazio!"));
		FacesContext.getCurrentInstance().getExternalContext().redirect("/chat/chat.jsf");
		return "chat.jsf";  
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("/chat/sala.jsf");
		salaChat.entrarSala(sala,users); 
		
		return "sala.jsf";  
		
	}

	public void enviarMensagem() {  
		if ((mensagem != "") || (!mensagem.isEmpty())) {
			salaChat.conversar(users.getName(), mensagem);
			mensagem = "";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Campo", "da Mensagem não pode ser vazio!")); 
		}
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {  
		this.apelido = apelido;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public SalaChatBean getSalaChat() {
		return salaChat;
	}

	public List<Room> getSalas() {
		return salas;
	}

	public void setSalas(List<Room> salas) {
		this.salas = salas;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
}
