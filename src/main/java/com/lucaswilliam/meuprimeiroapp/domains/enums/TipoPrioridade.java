package com.lucaswilliam.meuprimeiroapp.domains.enums;

public enum TipoPrioridade {
	
	//Attributes
	MINIMA(1, "Mínima"),
	NORMAL(2, "Normal"),
	MAXIMA(3, "Máxima");
	
	private int code;
	private String descricao;
	
	//Constructor
	private TipoPrioridade(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	//Getters
	public int getCode() {
		return code;
	}

	public String getDescricao() {
		return descricao;
	}
	
	//Methods aux
	public static TipoPrioridade toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		for(TipoPrioridade x: TipoPrioridade.values()) {
			if(x.getCode() ==code) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido");
	}
}
