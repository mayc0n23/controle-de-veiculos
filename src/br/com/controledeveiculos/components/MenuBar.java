package br.com.controledeveiculos.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.controledeveiculos.view.LoginScreen;
import br.com.controledeveiculos.view.AvailableVehicleListScreen;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 4261697113793896071L;
	
	private JFrame screen;
	
	public MenuBar(JFrame jframe) {
		this.screen = jframe;
		
		JMenu vehiclesMenu = new JMenu("Ve�culos");
		JMenuItem listOfAvailableVehicles = new JMenuItem("Ve�culos dispon�veis");
		listOfAvailableVehicles.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.dispose();
				new AvailableVehicleListScreen();
			}
		});
		vehiclesMenu.add(listOfAvailableVehicles);
		
		JMenuItem listOfVehiclesSoldMenu = new JMenuItem("Ve�culos vendidos");
		listOfVehiclesSoldMenu.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		vehiclesMenu.add(listOfVehiclesSoldMenu); 
		
		JMenuItem vehicleEntrance = new JMenuItem("Entrada de um novo ve�culo");
		vehicleEntrance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		vehiclesMenu.add(vehicleEntrance);
		
		JMenu options = new JMenu("Op��es");
		JMenuItem editUser = new JMenuItem("Editar seus dados");
		editUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		JMenuItem logout = new JMenuItem("Sair");
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.dispose();
				new LoginScreen();
			}
		});
		
		options.add(editUser);
		options.add(logout);
		this.add(vehiclesMenu);
		this.add(options);
	}

}