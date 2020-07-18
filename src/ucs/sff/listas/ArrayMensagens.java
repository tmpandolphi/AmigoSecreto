package ucs.sff.listas;

import java.io.Serializable;

import ucs.sff.src.Mensagem;

public class ArrayMensagens implements Serializable{

	private Mensagem[] mensagens;
	private int proxMsg = 0;
	
	public ArrayMensagens(int tam){
		mensagens = new Mensagem[tam];
	}
	
	public void adicionaMensagem(Mensagem mensagem) {
		if(proxMsg < 100) {
			mensagens[proxMsg] = mensagem;
			proxMsg++;
		} else {
			System.out.println("Lista de mensagens cheia, favor delete uma mensagem da lista.");
		}
	}
	
	//deleta mensagem
	
	//abre mensagem
	public void abreMensagem() {
		for(int i = 0; i < proxMsg; i++) {
			System.out.println(i + ". "+ mensagens[i].getTexto());
		}
	}
	
//	//mensagens nao lidas
//	public int naoLidas() {
//		
//		int i, cont = 0;
//		
//		for(i = 0; i< proxMsg;i++) {
//			if(mensagens[proxMsg].getLida() == true) {
//				cont++;
//			}
//		}
//		
//		return cont;
//	}
	
	/**********************/
}
