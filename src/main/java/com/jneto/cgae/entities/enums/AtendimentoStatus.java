package com.jneto.cgae.entities.enums;

public enum AtendimentoStatus {
	
	WAITING(1),
	CANCELED(2),
	FORWARDED(3),
	CLOSED(4);
	
	private int code;
	
	private AtendimentoStatus (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static AtendimentoStatus valueOf(int code) {
		for(AtendimentoStatus value : AtendimentoStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de status inválido.");
	}
}
