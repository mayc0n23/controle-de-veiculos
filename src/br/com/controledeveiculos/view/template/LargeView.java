package br.com.controledeveiculos.view.template;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Color;

public abstract class LargeView extends JFrame {
	
	private static final long serialVersionUID = 1956133753681180986L;
	
	public LargeView() {
		this.setSize(800, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#DCDCDC"));
		this.setLocationRelativeTo(null);
		this.setTitle("Cigano Motos - ");
		this.buildComponents();
	}
	
	public final void buildComponents() {
		this.addPanel();
		this.addLabels();
		this.addTextFields();
		this.addTables();
		this.addMenu();
		this.addButtons();
		this.lookAndFeel();
	}
	
	private final void lookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar o tema");
		}
	}
	
	public abstract void addLabels();
	public abstract void addButtons();
	public abstract void addTextFields();
	public abstract void addTables();
	public abstract void addMenu();
	public abstract void addPanel();

}