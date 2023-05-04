package br.com.controledeveiculos.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.exception.FailedToUpdateVehicleException;
import br.com.controledeveiculos.service.VehicleService;
import br.com.controledeveiculos.view.EditSoldVehicleScreen;
import br.com.controledeveiculos.view.VehicleSoldListScreen;

public class EditSoldVehicleAction implements ActionListener {
	
private VehicleService vehicleService;
	
	private EditSoldVehicleScreen screen;
	
	private int vehicleId;
	
	public EditSoldVehicleAction(EditSoldVehicleScreen screen, int vehicleId) {
		this.screen = screen;
		this.vehicleService = new VehicleService();
		this.vehicleId = vehicleId;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isValidForm()) {
			Vehicle vehicle = buildVehicle();
			try {
				this.vehicleService.updateAvailableVehicle(vehicle);
				JOptionPane.showMessageDialog(null, "Veículo editado com sucesso!");
				new VehicleSoldListScreen();
				screen.dispose();
			} catch (FailedToUpdateVehicleException exception) {
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
		vehicle.setId(this.vehicleId);
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