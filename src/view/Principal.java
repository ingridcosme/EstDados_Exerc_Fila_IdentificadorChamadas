/*
 * Criar um projeto Java que implementa com a biblioteca FilaStrings para simu_
 * lar um identificador de chamadas telef�nicas enquanto o aparelho est� fora da
 * rede ou desligado. A aplica��o deve ter uma classe no package controller, 
 * TelefoneController que tem os seguintes m�todos:
 * 
 * -insereLigacao(Fila f,  String numeroTelefone):void, que insere n�meros de 
 * telefone em uma fila iniciada;
 * -consultaLiga�coes(Fila f):void, que desenfilera cada liga��o realizada e 
 * exibe no console. Exibir uma exce��o caso n�o haja liga��o.
 * 
 * Deve ter tamb�m uma classe Principal no package view com opera��es usando
 * JOptionPane que permita ao usu�rio inserir n�meros e consultar as chamadas 
 * perdidas. A aplica��o deve rodar at� uma op��o de sa�da ser selecionada pelo
 * usu�rio.
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
        	buffer.append("Chamadas Telef�nicas\n");
        	buffer.append("O que voc� gostaria de fazer?");
        	buffer.append("\n------------------------------------------------");
        	buffer.append("\n1 - Inserir um n�mero de telefone");
        	buffer.append("\n2 - Consultar liga��es realizadas");
        	buffer.append("\n9 - Finalizar a aplica��o");
        	String opcStr = JOptionPane.showInputDialog(buffer.toString());
        	opc = Integer.parseInt(opcStr);
        	
            switch(opc){
                case 1: numTel = JOptionPane.showInputDialog("Digite um n�mero"
                		+ " de telefone:"
                		+ "\n"
                		+ "\n    xx xxxx-xxxx");
                		telCont.insereLigacao(f, numTel);
                        break;
                case 2: try {
							telCont.consultaLiga�coes(f);
						} catch (Exception e) {
							e.printStackTrace();
						}
                        break;
                case 9: System.out.print("\n\nAplica��o Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
            }
        }
        while(opc != 9);

	}

}
