/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;

import model.AnalisadorLexico;

import utilitarios.ManipuladorArquivo;


@SuppressWarnings("serial")
public class JanelaPrincipal extends javax.swing.JFrame {

	/**
	 *
	 * @author Maicon e Michelle
	 * Data: 18/11/2013
	 *  
	 */
	
	
	public JanelaPrincipal() {
		initComponents();
	}

	private void initComponents() {

		panelEdicao = new javax.swing.JPanel();
		scrollJanelaEdicao = new javax.swing.JScrollPane();
		janelaEdicao = new javax.swing.JTextArea();
		panelErros = new javax.swing.JPanel();
		scrollErros = new javax.swing.JScrollPane();
		janelaErros = new javax.swing.JTextArea();
		resultados = new javax.swing.JLabel();
		menu = new javax.swing.JMenuBar();
		arquivo = new javax.swing.JMenu();
		arquivoNovo = new javax.swing.JMenuItem();
		arquivoAbrir = new javax.swing.JMenuItem();
		arquivoSalvar = new javax.swing.JMenuItem();
		analise = new javax.swing.JMenu();
		analiseLexica = new javax.swing.JMenuItem();
		analiseSintatica = new javax.swing.JMenuItem();
		analiseSemantica = new javax.swing.JMenuItem();
		ajuda = new javax.swing.JMenu();
		documentacao = new javax.swing.JMenuItem();
		sobre = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Compilador");
		setAlwaysOnTop(true);
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setMinimumSize(new java.awt.Dimension(900, 600));

		janelaEdicao.setColumns(20);
		scrollJanelaEdicao.setViewportView(janelaEdicao);

		javax.swing.GroupLayout PanelEdicaoLayout = new javax.swing.GroupLayout(panelEdicao);
		panelEdicao.setLayout(PanelEdicaoLayout);
		PanelEdicaoLayout.setHorizontalGroup(
				PanelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(scrollJanelaEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
				);
		PanelEdicaoLayout.setVerticalGroup(
				PanelEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(scrollJanelaEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
				);

		janelaErros.setEditable(false);
		janelaErros.setColumns(20);
		scrollErros.setViewportView(janelaErros);

		javax.swing.GroupLayout PanelErrosLayout = new javax.swing.GroupLayout(panelErros);
		panelErros.setLayout(PanelErrosLayout);
		PanelErrosLayout.setHorizontalGroup(
				PanelErrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(scrollErros, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
				);
		PanelErrosLayout.setVerticalGroup(
				PanelErrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(scrollErros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
				);

		resultados.setText("Resultados:");

		arquivo.setText("Arquivo");
		arquivo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		arquivoNovo.setText("Novo");
		arquivoNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				arquivoNovoActionPerformed(evt);
			}
		});
		arquivo.add(arquivoNovo);

		arquivoAbrir.setText("Abrir");
		arquivoAbrir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				arquivoAbrirActionPerformed(evt);
			}
		});
		arquivo.add(arquivoAbrir);

		arquivoSalvar.setText("Salvar");
		arquivoSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				arquivoSalvarActionPerformed(evt);
			}
		});
		arquivo.add(arquivoSalvar);

		menu.add(arquivo);

		analise.setText("Análise");

		analiseLexica.setText("Léxica");
		analiseLexica.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				analiseLexicaActionPerformed(evt);
			}
		});
		analise.add(analiseLexica);

		analiseSintatica.setText("Sintática");
		analiseSintatica.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				analiseSintaticaActionPerformed(evt);
			}
		});
		analise.add(analiseSintatica);

		analiseSemantica.setText("Semântica");
		analiseSemantica.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				analiseSemanticaActionPerformed(evt);
			}
		});
		analise.add(analiseSemantica);
		analiseSemantica.setEnabled(true);

		menu.add(analise);

		ajuda.setText("Ajuda");
		ajuda.setInheritsPopupMenu(true);

		documentacao.setText("Documentação");
		documentacao.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				documentacaoActionPerformed(evt);
			}
		});
		ajuda.add(documentacao);
		ajuda.setVisible(false);

		sobre.setText("Sobre");
		sobre.setToolTipText("");
		sobre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		sobre.setIconTextGap(0);
		sobre.setInheritsPopupMenu(true);
		sobre.setName(""); // NOI18N
		sobre.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sobreActionPerformed(evt);
			}
		});
		ajuda.add(sobre);
		sobre.getAccessibleContext().setAccessibleParent(ajuda);

		menu.add(ajuda);

		setJMenuBar(menu);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(panelErros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
								.addComponent(panelEdicao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(resultados)
										.addGap(0, 0, Short.MAX_VALUE)))
										.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panelEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(4, 4, 4)
						.addComponent(resultados)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelErros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);

		pack();
	}

	private void arquivoNovoActionPerformed(java.awt.event.ActionEvent evt) {
		if (!janelaEdicao.getText().isEmpty()) {
			int resultado = JOptionPane.showConfirmDialog(janelaEdicao, "Deseja salvar as alterações?");
			if (resultado == 0) {
				salvarArquivo();
			}					
			if (resultado != 2) {
				janelaEdicao.setText(null);
				janelaErros.setText(null);
			}
		}
	}

	private void arquivoAbrirActionPerformed(java.awt.event.ActionEvent evt) {
		selecionarArquivo();
	}

	private void arquivoSalvarActionPerformed(java.awt.event.ActionEvent evt) {
		salvarArquivo();
	}

	private void analiseLexicaActionPerformed(java.awt.event.ActionEvent evt) {		
		String[] mensagem = controle.analiseLexica(janelaEdicao.getText());
		janelaErros.setText(mensagem[1]); 
		janelaEdicao.setCaretPosition(Integer.parseInt(mensagem[0]));		
	}

	private void analiseSintaticaActionPerformed(java.awt.event.ActionEvent evt) {
		String[] mensagem = controle.analiseSintatica(janelaEdicao.getText());
		janelaErros.setText(mensagem[1]); 
		janelaEdicao.setCaretPosition(Integer.parseInt(mensagem[0]));				
	}

	private void analiseSemanticaActionPerformed(java.awt.event.ActionEvent evt) {
		
	}

	private void documentacaoActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void sobreActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void selecionarArquivo() {
		JFileChooser abrir = new JFileChooser();
		abrir.setDialogTitle("Abrir");
		abrir.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "*.txt";
			}
			@Override
			public boolean accept(File f) {
				return (f.getName().endsWith(".txt")) || f.isDirectory();  
			}
		});
		if (abrir.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			janelaEdicao.setText(new ManipuladorArquivo().lerArquivo(abrir));
		}
	}

	private void salvarArquivo() {
		JFileChooser salvar = new JFileChooser();
		salvar.setApproveButtonText("Salvar");
		salvar.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));   
		if (salvar.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File arquivo = new File(salvar.getSelectedFile() + ".txt");
			new ManipuladorArquivo().salvarArquivo(arquivo, janelaEdicao.getText());
		}
	}
	
	private javax.swing.JMenu ajuda;
	private javax.swing.JMenu analise;
	private javax.swing.JMenuItem analiseLexica;
	private javax.swing.JMenuItem analiseSemantica;
	private javax.swing.JMenuItem analiseSintatica;
	private javax.swing.JMenu arquivo;
	private javax.swing.JMenuItem arquivoAbrir;
	private javax.swing.JMenuItem arquivoNovo;
	private javax.swing.JMenuItem arquivoSalvar;
	private javax.swing.JMenuItem documentacao;
	private javax.swing.JTextArea janelaEdicao;
	private javax.swing.JTextArea janelaErros;
	private javax.swing.JMenuBar menu;
	private javax.swing.JPanel panelEdicao;
	private javax.swing.JPanel panelErros;
	private javax.swing.JLabel resultados;
	private javax.swing.JScrollPane scrollErros;
	private javax.swing.JScrollPane scrollJanelaEdicao;
	private javax.swing.JMenuItem sobre;
	private Controller controle = new Controller();
}
