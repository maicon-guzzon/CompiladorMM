package controller;

import model.AnalisadorLexico;

public class Controller {
	
	
	
	public String[] analiseLexica(String programa){
		AnalisadorLexico lexico = new AnalisadorLexico();
		return lexico.analiseLexica(programa);
	}

}
