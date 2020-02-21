package com.konrad.edu.entity;

import java.io.Serializable;

public class LabelConstantes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String labelNombre;
	private String labelPrimerApellido;
	private String labelSegundoApellido;
	private String labeledad;
	private String labelNoDocumento;
	
	public LabelConstantes() {
		this.labelNombre = IConstantes.LABELNOMBRE;
		this.labelPrimerApellido = IConstantes.LABELPRIMERAPELLIDO;
		this.labelSegundoApellido = IConstantes.LABELSEGUNDOAPELLIDO;
		this.labeledad = IConstantes.LABELEDAD;
		this.labelNoDocumento = IConstantes.LABELNODOCUMENTO;
	}
	
	public String getLabelNombre() {
		return labelNombre;
	}
	public void setLabelNombre(String labelNombre) {
		this.labelNombre = labelNombre;
	}
	public String getLabeledad() {
		return labeledad;
	}
	public void setLabeledad(String labeledad) {
		this.labeledad = labeledad;
	}
	public String getLabelNoDocumento() {
		return labelNoDocumento;
	}
	public void setLabelNoDocumento(String labelNoDocumento) {
		this.labelNoDocumento = labelNoDocumento;
	}

	
	public String getLabelPrimerApellido() {
		return labelPrimerApellido;
	}

	public void setLabelPrimerApellido(String labelPrimerApellido) {
		this.labelPrimerApellido = labelPrimerApellido;
	}

	public String getLabelSegundoApellido() {
		return labelSegundoApellido;
	}

	public void setLabelSegundoApellido(String labelSegundoApellido) {
		this.labelSegundoApellido = labelSegundoApellido;
	}

	@Override
	public String toString() {
		return "LabelConstantes [labelNombre=" + labelNombre + ", labelPrimerApellido=" + labelPrimerApellido
				+ ", labelSegundoApellido=" + labelSegundoApellido + ", labeledad=" + labeledad + ", labelNoDocumento="
				+ labelNoDocumento + "]";
	}


	
	
	
}