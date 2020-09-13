package com.lucaswilliam.meuprimeiroapp.domains.enums;

public enum TipoCargo{
	
	//Attributes
	FUNCIONARIO(1, "ROLE_FUNCIONARIO"),
	CHEFE(2, "ROLE_CHEFE");
	
	private int code;
	private String descricao;
	
	//Constructor
	private TipoCargo(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	//Getters and Setters
	public int getCode() {
		return code;
	}


	public String getDescricao() {
		return descricao;
	}
	
	//Methods aux
	public static TipoCargo toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for(TipoCargo x: TipoCargo.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Codigo inválido");
	}
}
