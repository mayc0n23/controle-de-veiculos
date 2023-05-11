package br.com.controledeveiculos.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.controledeveiculos.view.LoginScreen;
import br.com.controledeveiculos.view.RegisterVehicleScreen;
import br.com.controledeveiculos.view.VehicleSoldListScreen;
import br.com.controledeveiculos.view.AvailableVehicleListScreen;
import br.com.controledeveiculos.view.EditUserScreen;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 4261697113793896071L;
	
	private JFrame screen;
	
	public MenuBar(JFrame jframe) {
		this.screen = jframe;
		
		JMenu vehiclesMenu = new JMenu("Veículos");
		JMenuItem listOfAvailableVehicles = new JMenuItem("Veículos disponíveis");
		listOfAvailableVehicles.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.dispose();
				new AvailableVehicleListScreen();
			}
		});
		vehiclesMenu.add(listOfAvailableVehicles);
		
		JMenuItem listOfVehiclesSoldMenu = new JMenuItem("Veículos vendidos");
		listOfVehiclesSoldMenu.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.dispose();
				new VehicleSoldListScreen();
			}
		});
		vehiclesMenu.add(listOfVehiclesSoldMenu); 
		
		JMenuItem vehicleEntrance = new JMenuItem("Entrada de um novo veículo");
		vehicleEntrance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				screen.dispose();
				new RegisterVehicleScreen();
			}
		});
		vehiclesMenu.add(vehicleEntrance);
		
		JMenu options = new JMenu("Opções");
		JMenuItem editUser = new JMenuItem("Editar seus dados");
		editUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.dispose();
				new EditUserScreen();
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