package ucs.sff.listas;

import java.io.Serializable;

import ucs.sff.src.Usuario;

public class NodoUsuario implements Serializable{

		private Usuario info ;
		private NodoUsuario prox ;
				
		public Usuario getInfo() {
			return info;
		}
		public void setInfo(Usuario info) {
			this.info = info;
		}
		public NodoUsuario getProx() {
			return prox;
		}
		public void setProx(NodoUsuario prox) {
			this.prox = prox;
		}
			
}
