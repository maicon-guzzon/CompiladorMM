package model;

import gals.LexicalAnalyzer;
import gals.LexicalError;
import gals.SemanticError;
import gals.SyntacticAnalyzer;
import gals.SyntaticError;


public class AnalisadorSintatico {
	
	/**
	 *
	 * @author Maicon e Michelle
	 * Data: 18/11/2013
	 *  
	 */
	
	private static final String SUCESSO = "O programa não contem erros sintáticos";
	
	public String[] analiseSintatica(String programa) {	
		String[] resultado = new String[2];
		LexicalAnalyzer lexico = new LexicalAnalyzer();
		lexico.setInput(programa);
		SyntacticAnalyzer sintatico = new SyntacticAnalyzer();
		try {
			sintatico.parse(lexico, null);
			resultado[0] = String.valueOf(0);
			resultado[1] = SUCESSO;
		} catch (LexicalError e) {
			resultado[0] = String.valueOf(e.getPosition());
			resultado[1] = e.getMessage();
		} catch (SyntaticError e) {
			resultado[0] = String.valueOf(e.getPosition());
			resultado[1] = e.getMessage();
		} catch (SemanticError e) {
			resultado[0] = String.valueOf(e.getPosition());
			resultado[1] = e.getMessage();
		}		
		return resultado;
	}

}
