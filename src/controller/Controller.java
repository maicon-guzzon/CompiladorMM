package controller;

import model.AnalisadorLexico;
import model.AnalisadorSintatico;

public class Controller {
	
	public String[] analiseLexica(String programa){
		AnalisadorLexico lexico = new AnalisadorLexico();
		return lexico.analiseLexica(programa);
	}

	public String[] analiseSintatica(String programa) {
		AnalisadorSintatico sintatico = new AnalisadorSintatico();
		return sintatico.analiseSintatica(programa);
	}

}
