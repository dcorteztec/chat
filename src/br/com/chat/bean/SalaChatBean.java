package br.com.chat.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.faces.bean.ApplicationScoped; 
import javax.faces.bean.ManagedBean;

import br.com.chat.model.Room;
import br.com.chat.model.Users;
   
@ManagedBean
@ApplicationScoped
public class SalaChatBean implements Serializable { 
	private static final long serialVersionUID = 1L;  
	private static final DateFormat df = new SimpleDateFormat("hh:mm:ss");
	private StringBuilder conversa = new StringBuilder();
	private Room room = new Room();
	  
	public SalaChatBean() {
	  
	}

	
	public void entrarSala(String sala,Users users){
		room.getUsers().add(users);
		Date agora = new Date(System.currentTimeMillis());
		conversa.append("[").append(df.format(agora)).append("]Bem vindo! a sala de "+ sala +" \n"); 
	}
	 
	
	public void conversar(String apelido, String texto) {
	Date agora = new Date();
	conversa.append("[").append(df.format(agora)).append("] <").append(apelido)
	.append("> ").append(texto).append("\n");
	}
	
	public void lerConversa(){
		getConversa();
	}
	
	public void setConversa(StringBuilder conversa) {
		this.conversa = conversa;
	}
	
	public String getConversa() {
		return conversa.toString();
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}
	
	
}