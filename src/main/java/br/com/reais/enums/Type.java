package br.com.reais.enums;

public enum Type {
	ML(1),
	G(2);
	
	private Integer code;
	
	private Type(Integer code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static Type toEnum(Integer code) {
		for (Type x : Type.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ERROR:R001-EN<br><br>Valor informado para o tipo é inválido");
	}
}
