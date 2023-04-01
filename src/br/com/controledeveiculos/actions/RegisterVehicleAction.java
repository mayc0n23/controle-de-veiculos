package br.com.controledeveiculos.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.exception.FailedToRegisterVehicleException;
import br.com.controledeveiculos.service.VehicleService;
import br.com.controledeveiculos.view.AvailableVehicleListScreen;
import br.com.controledeveiculos.view.RegisterVehicleScreen;

public class RegisterVehicleAction implements ActionListener {
	
	private VehicleService vehicleService;
	
	private RegisterVehicleScreen screen;
	
	public RegisterVehicleAction(RegisterVehicleScreen screen) {
		this.screen = screen;
		this.vehicleService = new VehicleService();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isValidForm()) {
			Vehicle vehicle = buildVehicle();
			try {
				this.vehicleService.register(vehicle);
				JOptionPane.showMessageDialog(null, "Ve�culo cadastrado com sucesso!");
				new AvailableVehicleListScreen();
				screen.dispose();
			} catch (FailedToRegisterVehicleException exception) {
				JOptionPane.showMessageDialog(null, exception.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos (*)");
		}
	}
	
	private boolean isValidForm() {
		return screen.getDescriptionField().getText().trim().length() != 0 && 
				screen.getPlateField().getText().trim().length() != 0 &&
				screen.getPriceField().getText().trim().length() != 0 && 
				screen.getVehicleTypeField().getSelectedItem() != null && 
				screen.getSellerNameField().getText().trim().length() != 0 && 
				screen.getSellerAddressField().getText().trim().length() != 0 && 
				screen.getSellerPhoneField().getText().trim().length() != 0 && 
				screen.getSellerPaymentDescriptionField().getText().trim().length() != 0;
	}
	
	private Vehicle buildVehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setDescription(screen.getDescriptionField().getText().trim());
		vehicle.setPlate(screen.getPlateField().getText().trim());
		vehicle.setChassis(screen.getChassiField().getText().trim());
		vehicle.setRenavam(screen.getRenavamField().getText().trim());
		vehicle.setSalePrice(screen.getPriceField().getText().trim());
		vehicle.setObservation(screen.getObservationField().getText().trim());
		vehicle.setInName(screen.getSellerNameField().getText().trim());
		vehicle.setInAddress(screen.getSellerAddressField().getText().trim());
		vehicle.setInPhone(screen.getSellerPhoneField().getText().trim());
		vehicle.setInPaymentDescription(screen.getSellerPaymentDescriptionField().getText().trim());
		vehicle.setInCpf(screen.getSellerCpfField().getText().trim());
		vehicle.setInRg(screen.getSellerRgField().getText().trim());
		String vehicleType = (String) screen.getVehicleTypeField().getSelectedItem();
		vehicle.setType(vehicleType);
		return vehicle;
	}

}