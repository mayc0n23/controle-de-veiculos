package br.com.controledeveiculos.entity;

public class Archive {
	
	private int id;
	
	private int vehicleId;
	
	private String filename;
	
	private byte[] archive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public byte[] getArchive() {
		return archive;
	}

	public void setArchive(byte[] archive) {
		this.archive = archive;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}