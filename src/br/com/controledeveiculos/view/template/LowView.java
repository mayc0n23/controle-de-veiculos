package br.com.controledeveiculos.view.template;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public abstract class LowView extends JFrame {

	private static final long serialVersionUID = -851529012006836848L;
	
	public LowView() {
		this.setSize(415, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#DCDCDC"));
		this.setLocationRelativeTo(null);
		this.setTitle("Cigano Motos - ");
		this.buildComponents();
	}
	
	public final void buildComponents() {
		this.addLabels();
		this.addTextFields();
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

}