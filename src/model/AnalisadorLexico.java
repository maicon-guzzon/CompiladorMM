package model;

import gals.LexicalError;
import gals.LexicalAnalyzer;
import gals.Token;

public class AnalisadorLexico {

	
	private static final String SUCESSO = "O programa não contém erros léxicos";

	private LexicalAnalyzer lexico = new LexicalAnalyzer();

	public AnalisadorLexico() {}

	public String[] analiseLexica(String programa) {
		lexico.setInput(programa);
		String[] resultado = new String[2];
		try
		{
			Token token = null;
			while ((token = lexico.nextToken()) != null)
			{
				System.out.println(token.getLexeme());				
			}
		}
		catch(LexicalError e)		
		{			
			resultado[0] = String.valueOf(e.getPosition());
			resultado[1] = e.getMessage();
			return resultado;
		}
		resultado[0] = String.valueOf(0);
		resultado[1] = SUCESSO;
		return resultado;
	}



}
