package ucs.sff.ui;

import java.util.Scanner;

import ucs.sff.listas.ListaDeUsuarios;
import ucs.sff.persist.Persistencia;
import ucs.sff.src.Mensagem;
import ucs.sff.src.Usuario;

public class InterfaceInicial {

    ListaDeUsuarios lista;
    Persistencia persistencia = new Persistencia();
    
    public InterfaceInicial() {
    	try {
    		
    		lista  = persistencia.recuperaObjeto();
    		System.out.println("Dados recuperados.");

    		
    	} catch (Exception e) {
    		System.out.println("Nenhum arquivo para carregar.");
    		lista = new ListaDeUsuarios();
    	}
    }

    public void menuPrincipal() {

        Scanner entrada = new Scanner(System.in);
        this.escreveMenu();
        int opcao = entrada.nextInt();
        while (opcao != 0) {

            switch (opcao) {
                case 1:
                    entrada.nextLine();
                    System.out.println("Digite o usuario do participante");
                    String usuario = entrada.nextLine();                    
                    
                    Usuario user = new Usuario(usuario);
                    
                    lista.adicionarUmUsuario(user);

                    break;

                case 2:
                	
                	int n = lista.tamanho()+1;
                	
                	if(n/2 != 0) {
                		
	                    try{
	                    	lista.realizaSorteio();
		                    System.out.println("Sorteado");
	                    } catch (Exception e) {
	                    	System.out.println("Sobrou para o participante somente ele mesmo.");
	                    	System.out.println("Favor sortear novamente.");
	                    	//reseta sorteio de todos;
	                    }
                    
                	} else {
                		
                		System.out.println("Numero impar de participantes, irá sobrar um participante.");
                	}
                    
                    break;

                case 3:
                	
                	try {
                		
                	entrada.nextLine();
                    System.out.println("Digite o seu usuário:");
                    usuario = entrada.nextLine();
                    
                    System.out.println(lista.getAmigo(usuario));
                    
            		} catch(NullPointerException e) {
            			
            			System.out.println("Você ainda não possui amigo sorteado.");
            		}

                    break;
                    
                case 4:

                    entrada.nextLine();
                    System.out.println("Digite o usuario para quem quer mandar mensagem");
                    usuario = entrada.nextLine();
                    System.out.println("Digite a mensagem a ser enviada:");
                    String msg = entrada.nextLine();

                    Mensagem mensagem = new Mensagem(msg, true);

                    lista.enviarMensagem(usuario, mensagem);

                    break;
                    
                case 5:
                	
                    entrada.nextLine();
                    System.out.println("Digite o usuario para quem quer cadastrar presente");
                    usuario = entrada.nextLine();
                    System.out.println("Digite o presente");
                    String presente = entrada.nextLine();

                    lista.enviarPresente(usuario, presente);

                    break;
                    
                case 6:
                	
                    entrada.nextLine();
                    System.out.println("Digite o usuario de quem quer ler as mensagens");
                    usuario = entrada.nextLine();

                    lista.lerMensagem(usuario);

                    break;
                    
                case 7:
                	
                    entrada.nextLine();
                    System.out.println("Digite o usuario de quem quer exibir os presentes");
                    usuario = entrada.nextLine();

                    lista.getPresentes(usuario);

                    break;
                case 8:
                	
                	lista.resetarSorteio();
                	System.out.println("Resetado o sorteio.");
                    break;

            }

            this.escreveMenu();
            opcao = entrada.nextInt();

        }
        persistencia.salvaObjeto(lista);
        entrada.close();

    }

    public void escreveMenu() {

        System.out.println("1. Cadastrar participante");
        System.out.println("2. Sorteio dos amigos secretos");
        System.out.println("3. Quem peguei no sorteio");
        System.out.println("4. Enviar mensagem");
        System.out.println("5. Cadastrar presente");
        System.out.println("6. Ler mensagens");
        System.out.println("7. Exibir presentes");
        System.out.println("8. Resetar sorteio");
        System.out.println("0. Sair");

    }

}
