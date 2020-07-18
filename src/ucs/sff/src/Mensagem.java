package ucs.sff.src;

import java.io.Serializable;

public class Mensagem implements Serializable {
	
	private String texto;
	private boolean lida;

	public Mensagem(String msg, boolean status) {
		this.texto = msg;
		this.lida = status;
	}
	
	public boolean getLida() {
		return this.lida;
	}
	
	public String getTexto() {
		return this.texto;
	}
}
