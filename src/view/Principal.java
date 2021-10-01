/*
 * Criar um projeto Java que implementa com a biblioteca FilaStrings para simu_
 * lar um identificador de chamadas telefônicas enquanto o aparelho está fora da
 * rede ou desligado. A aplicação deve ter uma classe no package controller, 
 * TelefoneController que tem os seguintes métodos:
 * 
 * -insereLigacao(Fila f,  String numeroTelefone):void, que insere números de 
 * telefone em uma fila iniciada;
 * -consultaLigaçcoes(Fila f):void, que desenfilera cada ligação realizada e 
 * exibe no console. Exibir uma exceção caso não haja ligação.
 * 
 * Deve ter também uma classe Principal no package view com operações usando
 * JOptionPane que permita ao usuário inserir números e consultar as chamadas 
 * perdidas. A aplicação deve rodar até uma opção de saída ser selecionada pelo
 * usuário.
 */

package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.ingridcosme.filastr.Fila;
import controller.TelefoneController;

public class Principal {

	public static void main(String[] args) {
		Fila f = new Fila();
		TelefoneController telCont = new TelefoneController();
		
		String numTel = "";
		
		int opc=0;
        do{
        	StringBuffer buffer = new StringBuffer();
        	buffer.append("Chamadas Telefônicas\n");
        	buffer.append("O que você gostaria de fazer?");
        	buffer.append("\n------------------------------------------------");
        	buffer.append("\n1 - Inserir um número de telefone");
        	buffer.append("\n2 - Consultar ligações realizadas");
        	buffer.append("\n9 - Finalizar a aplicação");
        	String opcStr = JOptionPane.showInputDialog(buffer.toString());
        	opc = Integer.parseInt(opcStr);
        	
            switch(opc){
                case 1: numTel = JOptionPane.showInputDialog("Digite um número"
                		+ " de telefone:"
                		+ "\n"
                		+ "\n    xx xxxx-xxxx");
                		telCont.insereLigacao(f, numTel);
                        break;
                case 2: try {
							telCont.consultaLigaçcoes(f);
						} catch (Exception e) {
							e.printStackTrace();
						}
                        break;
                case 9: System.out.print("\n\nAplicação Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
        while(opc != 9);

	}

}
