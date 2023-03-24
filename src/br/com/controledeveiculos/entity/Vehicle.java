package br.com.controledeveiculos.entity;

public class Vehicle {
	
	private int id;
	
	/* Vehicle information */
	private String description;
	
	private String plate;
	
	private String chassis;
	
	private String renavam;
	
	private Double salePrice;
	
	private String type;
	
	private String observation;
	
	/* Pessoa que vendeu o veiculo para a loja */
	private String inName;
	
	private String inAddress;
	
	private String inPhone;
	
	private String inPaymentDescription;
	
	private String inRg;
	
	private String inCpf;
	
	/* Pessoa que comprou o veiculo da loja */
	private String outName;
	
	private String outAddress;
	
	private String outPhone;
	
	private String outPaymentDescription;
	
	private String outRg;
	
	private String outCpf;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getInName() {
		return inName;
	}

	public void setInName(String inName) {
		this.inName = inName;
	}

	public String getInAddress() {
		return inAddress;
	}

	public void setInAddress(String inAddress) {
		this.inAddress = inAddress;
	}

	public String getInPhone() {
		return inPhone;
	}

	public void setInPhone(String inPhone) {
		this.inPhone = inPhone;
	}

	public String getInPaymentDescription() {
		return inPaymentDescription;
	}

	public void setInPaymentDescription(String inPaymentDescription) {
		this.inPaymentDescription = inPaymentDescription;
	}

	public String getInRg() {
		return inRg;
	}

	public void setInRg(String inRg) {
		this.inRg = inRg;
	}

	public String getInCpf() {
		return inCpf;
	}

	public void setInCpf(String inCpf) {
		this.inCpf = inCpf;
	}

	public String getOutName() {
		return outName;
	}

	public void setOutName(String outName) {
		this.outName = outName;
	}

	public String getOutAddress() {
		return outAddress;
	}

	public void setOutAddress(String outAddress) {
		this.outAddress = outAddress;
	}

	public String getOutPhone() {
		return outPhone;
	}

	public void setOutPhone(String outPhone) {
		this.outPhone = outPhone;
	}

	public String getOutPaymentDescription() {
		return outPaymentDescription;
	}

	public void setOutPaymentDescription(String outPaymentDescription) {
		this.outPaymentDescription = outPaymentDescription;
	}

	public String getOutRg() {
		return outRg;
	}

	public void setOutRg(String outRg) {
		this.outRg = outRg;
	}

	public String getOutCpf() {
		return outCpf;
	}

	public void setOutCpf(String outCpf) {
		this.outCpf = outCpf;
	}

}