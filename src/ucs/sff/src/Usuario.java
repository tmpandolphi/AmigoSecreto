package ucs.sff.src;

import java.io.Serializable;

import ucs.sff.listas.ArrayMensagens;
import ucs.sff.listas.ArrayPresentes;

public class Usuario implements Serializable{

	protected String usuario = null;
    protected boolean sorteado;
    protected String amigo;

    private ArrayMensagens mensagens = new ArrayMensagens(100);
    private ArrayPresentes presentes = new ArrayPresentes(10);

    public Usuario(String usuario) {
        this.usuario = usuario;
        this.sorteado = false;
    }

    public void novaMensagem(Mensagem msg) {
        mensagens.adicionaMensagem(msg);
    }

    public void novoPresente(String pres) {
        presentes.adicionaPresente(pres);
    }

    public void getMensagem() {
        mensagens.abreMensagem();
    }

    public void getPresentes() {
        presentes.getPresentes();
    }


    public void setAmigo(String amiguinho) {
        this.amigo = amiguinho;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public boolean getSorteado() {
        return this.sorteado;
    }

    public void setSorteado(boolean n) {
        this.sorteado = n;
    }

	public String getAmigo() {
		return this.amigo;
	}

}
