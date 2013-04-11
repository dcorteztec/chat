package br.com.chat.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ChatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String apelido;
	private String mensagem;
	
	@ManagedProperty(value = "#{salaChatBean}")
	private SalaChatBean salaChat; 

	public void setSalaChat(SalaChatBean salaChat) {
		this.salaChat = salaChat;
	}


	public String entrar() throws IOException {  
		if ((apelido == "") || (apelido.isEmpty())) {   
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Campo", "apelido não pode ser vazio!"));
		FacesContext.getCurrentInstance().getExternalContext().redirect("/chat/chat.jsf");
		return "chat.jsf";  
		}
		FacesContext.getCurrentInstance().getExternalContext().redirect("/chat/sala.jsf");
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
	
}
