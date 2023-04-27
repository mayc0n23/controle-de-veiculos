package br.com.controledeveiculos.service;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import br.com.controledeveiculos.entity.Archive;
import br.com.controledeveiculos.exception.FailedToDeleteFileException;
import br.com.controledeveiculos.exception.FailedToSaveFileException;
import br.com.controledeveiculos.repository.ArchiveRepository;

public class ArchiveService {
	
	private ArchiveRepository repository;
	
	public ArchiveService() {
		this.repository = new ArchiveRepository();
	}
	
	public void saveArchive(Archive archive) throws FailedToSaveFileException {
		repository.save(archive);
	}
	
	public void deleteFileIfExist(int vehicleId) throws FailedToDeleteFileException {
		repository.delete(vehicleId);
	}
	
	public List<Archive> searchByVehicleId(int vehicleId) {
		return repository.findByVehicleId(vehicleId);
	}
	
	public void openFiles(List<Archive> archives) {
		archives.forEach(archive -> {
			File file = new File(archive.getFilename());
			try {
				FileOutputStream outputStream = new FileOutputStream(file);
				outputStream.write(archive.getArchive());
				Desktop.getDesktop().open(file);
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
	
}