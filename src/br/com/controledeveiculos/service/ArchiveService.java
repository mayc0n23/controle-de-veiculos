package br.com.controledeveiculos.service;

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
}