package br.com.chat.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.chat.model.Room;

@ManagedBean
@SessionScoped
public class ChatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String apelido;
	private String mensagem;
	private List<SelectItem> salas = new ArrayList<SelectItem>();
	private String sala;
	private Map<String, Room> chatRooms = new HashMap<String, Room>();
	
	@ManagedProperty(value = "#{salaChatBean}")
	private SalaChatBean salaChat; 

	public void setSalaChat(SalaChatBean salaChat) {
		this.salaChat = salaChat;
	}
	
	public ChatBean() {
		SelectItem selectItem = new SelectItem("Esporte");
		SelectItem selectItem2 = new SelectItem("Filme");
		salas.add(selectItem);
		salas.add(selectItem2);  
		
	} 


	public String entrar() throws IOException {  
		if ((apelido == "") || (apelido.isEmpty())) {   
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Campo", "apelido não pode ser vazio!"));
		FacesContext.getCurrentInstance().getExternalContext().redirect("/chat/chat.jsf");
		return "chat.jsf";  
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("/chat/sala.jsf");
		salaChat.entrarSala(sala);
		return "sala.jsf";  
		
	}

	public void enviarMensagem() { 
		if ((mensagem != "") || (!mensagem.isEmpty())) {
			salaChat.conversar(apelido, mensagem);
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

	public List<SelectItem> getSalas() {
		return salas;
	}

	public void setSalas(List<SelectItem> salas) {
		this.salas = salas;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
	
	
}
