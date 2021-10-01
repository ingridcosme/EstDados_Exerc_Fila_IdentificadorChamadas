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

package controller;

import br.edu.fateczl.ingridcosme.filastr.Fila;

public class TelefoneController {

	public TelefoneController() {
		super();
	}

	public void insereLigacao(Fila f, String numeroTelefone) {
			if(validar(numeroTelefone) == true) {
				f.insert(numeroTelefone);
			} else {
				System.err.println("N�mero <<"+numeroTelefone+">> inv�lido!");
			}
	}
	
	public void consultaLiga�coes(Fila f) throws Exception {
		if(f.isEmpty()) {
			throw new Exception("N�o h� liga��es!");
		} else {
			String numeroTelefone = f.remove();
			System.out.println(numeroTelefone);
		}
	}
	
	public boolean validar(String numeroTelefone) {
		return numeroTelefone.matches("[1-9]\\d\\s9?\\d{4}-\\d{4}");
	}
}
