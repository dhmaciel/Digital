package com.digital.bean;

public class VeiculoBean {
	
	private Long idVeiculo;
	private String descricao;
	private Long idTipoVeiculo;
	private String tipoVeiculoStr;
	private Long idUsuario;
	
	public Long getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getIdTipoVeiculo() {
		return idTipoVeiculo;
	}
	public void setIdTipoVeiculo(Long idTipoVeiculo) {
		this.idTipoVeiculo = idTipoVeiculo;
	}
	public String getTipoVeiculoStr() {
		return tipoVeiculoStr;
	}
	public void setTipoVeiculoStr(String tipoVeiculoStr) {
		this.tipoVeiculoStr = tipoVeiculoStr;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

}
