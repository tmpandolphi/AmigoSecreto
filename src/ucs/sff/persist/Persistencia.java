package ucs.sff.persist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ucs.sff.listas.ListaDeUsuarios;
 
public class Persistencia {
	    
    public void salvaObjeto(ListaDeUsuarios lista) {
    	   	 	
	    try {
	    	
	      //Gera o arquivo para armazenar o objeto
	      FileOutputStream arquivoGrav = new FileOutputStream("saida.dat");
	      
	      //Classe responsavel por inserir os objetos
	      ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
	      
	      //Grava o objeto cliente no arquivo
	      objGravar.writeObject(lista);
	      objGravar.flush();
	      objGravar.close();
	      
	      arquivoGrav.flush();
	      arquivoGrav.close();
	      
	      System.out.println("Dados gravados.");
	      
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
    
    }
    
    public ListaDeUsuarios recuperaObjeto() throws IOException, ClassNotFoundException {
    	
	    //recuperar objeto do arquivo
	    System.out.println("Recuperando dados..");
	    
	    try {
	      //Carrega o arquivo
	      FileInputStream arquivoLeitura = new FileInputStream("saida.dat");
	      
	      // Classe responsavel por recuperar os objetos do arquivo
	      ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
	      
	      //aqui eu iria inserir o objeto no nodo 
	      //System.out.println(objLeitura.readObject());
	      ListaDeUsuarios lista = (ListaDeUsuarios) objLeitura.readObject();
	      objLeitura.close();
	      arquivoLeitura.close();
	      return lista;
	      
	    } catch(FileNotFoundException e1) {
	    	throw e1;
	    }
 
	}
}

