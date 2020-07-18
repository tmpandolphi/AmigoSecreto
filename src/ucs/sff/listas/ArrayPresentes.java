package ucs.sff.listas;

import java.io.Serializable;

public class ArrayPresentes implements Serializable{

	private String[] presentes;
	private int proxGift = 0;
	
	public ArrayPresentes(int tam) {
		presentes = new String[tam];
	}

	public void adicionaPresente(String texto) {
		if(proxGift < 100) {
			presentes[proxGift] = texto;
		} else {
			System.out.println("Lista de presentes cheia, favor delete um presente da lista.");
		}
	}
	
	public void getPresentes() {
		for(int i = 0; i < proxGift;i++) {
			System.out.println(i + " " + presentes[i]);
		}
	}
}
