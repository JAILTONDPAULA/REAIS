package br.com.reais.enums;

public enum MultiOption {
	SIM('S'),
	NAO('N');
	
	private char code;
	
	private MultiOption(char code) {
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}
	
	public static MultiOption toEnum(char code) {
		for (MultiOption x : MultiOption.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ERROR:R003BE<br><br>Valor recebido inválido");
	}
}
