package br.com.controledeveiculos.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JOptionPane;

import br.com.controledeveiculos.entity.Archive;
import br.com.controledeveiculos.entity.Vehicle;
import br.com.controledeveiculos.enums.FileType;
import br.com.controledeveiculos.exception.FailedToDeleteFileException;
import br.com.controledeveiculos.exception.FailedToSaveFileException;
import br.com.controledeveiculos.exception.FailedToUpdateVehicleException;
import br.com.controledeveiculos.service.ArchiveService;
import br.com.controledeveiculos.service.VehicleService;
import br.com.controledeveiculos.view.AvailableVehicleListScreen;
import br.com.controledeveiculos.view.EditAvailableVehicleScreen;

public class EditAvailableVehicleAction implements ActionListener {
	
	private VehicleService vehicleService;

	private ArchiveService archiveService;
	
	private EditAvailableVehicleScreen screen;
	
	private int vehicleId;
	
	public EditAvailableVehicleAction(EditAvailableVehicleScreen screen, int vehicleId) {
		this.screen = screen;
		this.vehicleService = new VehicleService();
		this.archiveService = new ArchiveService();
		this.vehicleId = vehicleId;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isValidForm()) {
			Vehicle vehicle = buildVehicle();
			try {
				this.vehicleService.updateAvailableVehicle(vehicle);
				if (hasFiles()) {
					this.archiveService.deleteFileIfExist(vehicle.getId());
					saveFiles(vehicle.getId());
				}
				JOptionPane.showMessageDialog(null, "Ve�culo editado com sucesso!");
				new AvailableVehicleListScreen();
				screen.dispose();
			} catch (FailedToUpdateVehicleException | FailedToDeleteFileException exception) {
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

	private boolean hasFiles() {
		return screen.getVehicleFirstFileChooser().getSelectedFile() != null ||
				screen.getVehicleSecondFileChooser().getSelectedFile() != null;
	}

	private void saveFiles(int vehicleId) {
		if (screen.getVehicleFirstFileChooser().getSelectedFile() != null) {
			File file = screen.getVehicleFirstFileChooser().getSelectedFile();
			try {
				byte[] fileContent = Files.readAllBytes(file.toPath());
				Archive archive = new Archive();
				archive.setVehicleId(vehicleId);
				archive.setFilename(file.getName());
				archive.setArchive(fileContent);
				archive.setFileType(FileType.VEHICLE);
				this.archiveService.saveArchive(archive);
			} catch (IOException | FailedToSaveFileException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}

		if (screen.getVehicleSecondFileChooser().getSelectedFile() != null) {
			File file = screen.getVehicleSecondFileChooser().getSelectedFile();
			try {
				byte[] fileContent = Files.readAllBytes(file.toPath());
				Archive archive = new Archive();
				archive.setVehicleId(vehicleId);
				archive.setFilename(file.getName());
				archive.setArchive(fileContent);
				archive.setFileType(FileType.VEHICLE);
				this.archiveService.saveArchive(archive);
			} catch (IOException | FailedToSaveFileException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

}