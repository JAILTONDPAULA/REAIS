package br.com.reais.enums;

public enum Kinship {
	MAE(1,"MÃE")          ,
	IRMAO(2,"IRMÃO")      ,
	SOGRA(3,"SOGRA")      ,
	CONJUGUE(4,"CONJUGUE"),
	AMIGOS(5,"AMIGOS")    ,
	PET(6,"PET")          ,
	AVO(7,"AVÓ")          ,
	SOBRINHO(8,"SOBRINHO"),
	TITULAR(7,"TITULAR")  ,
	OUTROS(10,"OUTROS")   ;
	
	private Integer code;
	private String  description;
	
	private Kinship(Integer code,String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Kinship toEnum(Integer code) {
		for (Kinship x : Kinship.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ERROR:R001KINSHIP<br><br>Valor recebido inválido");
	}
	
	public static Kinship toEnum(String description) {
		for (Kinship x : Kinship.values()) {
			if(x.getDescription() == description) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("ERROR:R002KINSHIP<br><br>Valor recebido inválido");
	}
}