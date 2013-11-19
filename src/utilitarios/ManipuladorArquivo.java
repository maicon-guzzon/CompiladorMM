package utilitarios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;

public class ManipuladorArquivo {

	/**
	 *
	 * @author Maicon e Michelle
	 * Data: 18/11/2013
	 *  
	 */
	public ManipuladorArquivo() {}
	
	public String lerArquivo(JFileChooser abrirDialog) {
		String texto = "";
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(abrirDialog.getSelectedFile()));
			String linha;				
			while ((linha = buffer.readLine()) != null)   {
				texto = texto + (linha) + "\n";
			}
			buffer.close();
		}catch (Exception e){
			System.err.println("Erro: " + e.getMessage());
		}
		return texto;
	}
	
	public void salvarArquivo(File arquivo, String texto) {		
		try {
			BufferedWriter buffer = new BufferedWriter(new FileWriter(arquivo));
			buffer.write(texto);
			buffer.close();
		} catch (Exception e) {
			System.err.println("Erro: " + e.getMessage());
		}
	}
}
