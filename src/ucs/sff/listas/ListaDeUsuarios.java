package ucs.sff.listas;

import java.io.Serializable;
import java.util.Random;

import ucs.sff.exceptions.ExcecaoDeUsuarioFinalSemPar;
import ucs.sff.src.Mensagem;
import ucs.sff.src.Usuario;

public class ListaDeUsuarios implements Serializable {
	
	private NodoUsuario inicio = null;
    private NodoUsuario fim = null;
    private int quantidadeDeUsuarios = 0;

    public void adicionarUmUsuario(Usuario usuario) {
        NodoUsuario aux = new NodoUsuario();
        aux.setInfo(usuario);

        if (quantidadeDeUsuarios == 0) {
            inicio = aux;
            fim = aux;
        } else {
            fim.setProx(aux);
            fim = aux;
        }
        quantidadeDeUsuarios++;
    }

    public void enviarMensagem(String usuario, Mensagem msg) {
        NodoUsuario aux = this.inicio;
        int i;

        for (i = 0; i <= quantidadeDeUsuarios; i++) {
            if (usuario.equals(aux.getInfo().getUsuario())) {
                aux.getInfo().novaMensagem(msg);
                System.out.println("Mensagem enviada!");
                return;
            }
            aux = aux.getProx();
        }

        System.out.println("Mensagem nï¿½o enviada. Verifique o usuario entrado.");
        return;

    }

    public void lerMensagem(String usuario) {
        NodoUsuario aux = this.inicio;
        int i;

        for (i = 0; i <= quantidadeDeUsuarios; i++) {
            if (usuario.equals(aux.getInfo().getUsuario())) {
                aux.getInfo().getMensagem();
                return;
            }
            aux = aux.getProx();

        }
        System.out.println("Sem mensagens para ler.");
    }

    public Usuario removerUsuario(String usuario) {
        return null;
    }

    public boolean getSorteado(String Usuario) {
        return fim.getInfo().getSorteado();
    }

    public String getUsuario(int indice) {

        NodoUsuario aux = this.inicio;
        for (int i = 0; i < indice; i++) {
            aux = aux.getProx();
        }
        return aux.getInfo().getUsuario();
    }

    public int tamanho() {
        return this.quantidadeDeUsuarios;
    }
    
    
    public void realizaSorteio() throws ExcecaoDeUsuarioFinalSemPar {
    	
    	NodoUsuario aux = this.inicio; //sorteando
    	NodoUsuario flag = this.inicio;//sorteado
        Random gerarNumero = new Random();
        int numeroAleatorio = 0;
        int i, j, k;

        k = 0;
        
        for (i = 0; i < quantidadeDeUsuarios; i++) {
        	
        System.out.println("Sorteando para " + aux.getInfo().getUsuario());
        
         while(aux.getInfo().getAmigo() == null) {
        	 
            numeroAleatorio = gerarNumero.nextInt(quantidadeDeUsuarios);
         
  
			for (j = 0; j < numeroAleatorio; j++) {
				flag = flag.getProx();
			}
            
            if(flag.getInfo().getSorteado() == false) {
            	if(aux.getInfo().getUsuario() != flag.getInfo().getUsuario()) {
            		flag.getInfo().setSorteado(true);
            		aux.getInfo().setAmigo(flag.getInfo().getUsuario());
                    if(aux.getInfo().getAmigo() == null) {
                    		throw new ExcecaoDeUsuarioFinalSemPar();
                    }
            	}
            }
            
            flag = this.inicio;    
        }
         	System.out.println("Para " + aux.getInfo().getUsuario() + " sorteado " + aux.getInfo().getAmigo());
            flag = this.inicio; 
            k++;
            
            if(k != quantidadeDeUsuarios) {
            	aux = aux.getProx();
            }

        }
    }

    public void resetarSorteio() {
    	
    	NodoUsuario aux = this.inicio;
    	int i;
        
        for (i = 0; i < quantidadeDeUsuarios; i++) {	
        	aux.getInfo().setAmigo(null);
        	aux.getInfo().setSorteado(false);
        	aux = aux.getProx();
        }
    }
    
	public void enviarPresente(String usuario, String presente) {
        NodoUsuario aux = this.inicio;
        int i;

        for (i = 0; i <= quantidadeDeUsuarios; i++) {
            if (usuario.equals(aux.getInfo().getUsuario())) {
                aux.getInfo().novoPresente(presente);
                System.out.println("Presente cadastrado!");
                return;
            }
            aux = aux.getProx();
        }

        System.out.println("Presente não cadastrado. Verifique o usuario entrado.");
        return;
		
	}
	
    public void getPresentes(String usuario) {
        NodoUsuario aux = this.inicio;
        int i;

        for (i = 0; i <= quantidadeDeUsuarios; i++) {
            if (usuario.equals(aux.getInfo().getUsuario())) {
                aux.getInfo().getPresentes();
                return;
            }
            aux = aux.getProx();

        }
        System.out.println("Sem presentes para exibir.");
    }

	public String getAmigo(String usuario) {
        NodoUsuario aux = this.inicio;
        int i;

        for (i = 0; i <= quantidadeDeUsuarios; i++) {
            if (usuario.equals(aux.getInfo().getUsuario())) {
                return aux.getInfo().getAmigo();
            }
            aux = aux.getProx();

        }

        return "Sem amigo :(";

	}
}
