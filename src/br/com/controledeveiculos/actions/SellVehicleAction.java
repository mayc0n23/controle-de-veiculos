package br.com.controledeveiculos.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JOptionPane;

import br.com.controledeveiculos.entity.Archive;
import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.exception.FailedToSaveFileException;
import br.com.controledeveiculos.exception.FailedToUpdateVehicleException;
import br.com.controledeveiculos.service.ArchiveService;
import br.com.controledeveiculos.service.VehicleService;
import br.com.controledeveiculos.view.VehicleSalesScreen;
import br.com.controledeveiculos.view.VehicleSoldListScreen;

public class SellVehicleAction implements ActionListener {
	
	private VehicleService vehicleService;
	
	private ArchiveService archiveService;
	
	private VehicleSalesScreen screen;
	
	private Vehicle vehicle;
	
	public SellVehicleAction(VehicleSalesScreen screen, Vehicle vehicle) {
		this.screen = screen;
		this.vehicle = vehicle;
		this.vehicleService = new VehicleService();
		this.archiveService = new ArchiveService();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isValidForm()) {
			populateVehicleWithBuyerData();
			try {
				this.vehicleService.sellVehicle(vehicle);
				if (hasFiles()) {
					saveFiles();
				}
				JOptionPane.showMessageDialog(null, "Ve�culo editado com sucesso!");
				new VehicleSoldListScreen();
				screen.dispose();
			} catch (FailedToUpdateVehicleException exception) {
				JOptionPane.showMessageDialog(null, exception.getMessage());
			}
		} else {
			if (vehicle != null) JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos (*)");
		}
	}
	
	private boolean isValidForm() {
		return screen.getBuyerNameField().getText().trim().length() != 0 && 
				screen.getBuyerAddressField().getText().trim().length() != 0 &&
				screen.getBuyerPhoneField().getText().trim().length() != 0 && 
				screen.getBuyerPaymentDescriptionField().getText().trim().length() != 0 &&
				vehicle != null;
	}
	
	private void populateVehicleWithBuyerData() {
		vehicle.setOutName(screen.getBuyerNameField().getText().trim());
		vehicle.setOutAddress(screen.getBuyerAddressField().getText().trim());
		vehicle.setOutPhone(screen.getBuyerPhoneField().getText().trim());
		vehicle.setOutPaymentDescription(screen.getBuyerPaymentDescriptionField().getText().trim());
		vehicle.setOutCpf(screen.getBuyerCpfField().getText().trim());
		vehicle.setOutRg(screen.getBuyerRgField().getText().trim());
	}
	
	private boolean hasFiles() {
		return screen.getFirstFileChooser().getSelectedFile() != null ||
				screen.getSecondFileChooser().getSelectedFile() != null;
	}
	
	private void saveFiles() {
		if (screen.getFirstFileChooser().getSelectedFile() != null) {
			File file = screen.getFirstFileChooser().getSelectedFile();
			try {
				byte[] fileContent = Files.readAllBytes(file.toPath());
				Archive archive = new Archive();
				archive.setVehicleId(vehicle.getId());
				archive.setFilename(file.getName());
				archive.setArchive(fileContent);
				this.archiveService.saveArchive(archive);
			} catch (IOException | FailedToSaveFileException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
		if (screen.getSecondFileChooser().getSelectedFile() != null) {
			File file = screen.getSecondFileChooser().getSelectedFile();
			try {
				byte[] fileContent = Files.readAllBytes(file.toPath());
				Archive archive = new Archive();
				archive.setVehicleId(vehicle.getId());
				archive.setFilename(file.getName());
				archive.setArchive(fileContent);
				this.archiveService.saveArchive(archive);
			} catch (IOException | FailedToSaveFileException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

}