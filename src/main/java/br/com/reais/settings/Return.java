package br.com.reais.settings;

import java.util.ArrayList;
import java.util.List;

public class Return<T>{
	private Boolean success;
	private String  mesage;
	private List<T> cod = new ArrayList<>();
	
	public Return () {
		
	}

	public Return(Boolean success, String mesage) {
		this.success = success;
		this.mesage = mesage;
	}

	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMesage() {
		return mesage;
	}
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	
	public List<T> getCod() {
		return cod;
	}

	public void setCod(List<T> cod) {
		this.cod = cod;
	}
		
	
}
