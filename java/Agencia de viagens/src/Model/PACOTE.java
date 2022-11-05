package Model;

import java.time.LocalDate;

public class PACOTE {
	private int id;
	private String Destino;
	private LocalDate dataIda;
	private LocalDate dataVolta;
	private double valorTransporte;
	private double valorHospedagem;
	private double valoresExtra;
public PACOTE() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDestino() {
	return Destino;
}
public void setDestino(String destino) {
	Destino = destino;
}
public LocalDate getDataIda() {
	return dataIda;
}
public void setDataIda(LocalDate dataIda) {
	this.dataIda = dataIda;
}
public LocalDate getDataVolta() {
	return dataVolta;
}
public void setDataVolta(LocalDate dataVolta) {
	this.dataVolta = dataVolta;
}
public double getValorTransporte() {
	return valorTransporte;
}
public void setValorTransporte(double valorTransporte) {
	this.valorTransporte = valorTransporte;
}
public double getValorHospedagem() {
	return valorHospedagem;
}
public void setValorHospedagem(double valorHospedagem) {
	this.valorHospedagem = valorHospedagem;
}
public double getValoresExtra() {
	return valoresExtra;
}
public void setValoresExtra(double valoresExtra) {
	this.valoresExtra = valoresExtra;
}
}
