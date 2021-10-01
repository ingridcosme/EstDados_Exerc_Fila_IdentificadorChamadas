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
				System.err.println("Número <<"+numeroTelefone+">> inválido!");
			}
	}
	
	public void consultaLigaçcoes(Fila f) throws Exception {
		if(f.isEmpty()) {
			throw new Exception("Não há ligações!");
		} else {
			String numeroTelefone = f.remove();
			System.out.println(numeroTelefone);
		}
	}
	
	public boolean validar(String numeroTelefone) {
		return numeroTelefone.matches("[1-9]\\d\\s9?\\d{4}-\\d{4}");
	}
}
