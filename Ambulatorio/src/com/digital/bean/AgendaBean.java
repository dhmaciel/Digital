package com.digital.bean;

import java.util.List;

public class AgendaBean {
	
	private Long idAgenda;
	private Long idCliente;
	private Long idServico;
	private Long idStatusServico;
	private Long idUsuario;
	private String nomeUsuario;
	private String dataServico;
	private String descricaoStatusServico;
	private String siglaStatusServico;
	private String servicosAgendamento; // Todos os serviços contidos no agendamento.
	private String obsAgendamento;
	private String obsConcluirAgendamento;
	private String obsCancelarServico;
	private Long idEmpresa;
	private Long idVeiculo;	
	private String descricaoVeiculo;	
	private String deHorarioServico;
	private String ateHorarioServico;
	private String deHorarioAgendamento;
	private String ateHorarioAgendamento;
	private String tempoTotalServico;
	private List<ServicosBean> listServicosBean;
	
	public Long getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Long getIdServico() {
		return idServico;
	}
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}
	public Long getIdStatusServico() {
		return idStatusServico;
	}
	public void setIdStatusServico(Long idStatusServico) {
		this.idStatusServico = idStatusServico;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getDataServico() {
		return dataServico;
	}
	public void setDataServico(String dataServico) {
		this.dataServico = dataServico;
	}
	public String getDescricaoStatusServico() {
		return descricaoStatusServico;
	}
	public void setDescricaoStatusServico(String descricaoStatusServico) {
		this.descricaoStatusServico = descricaoStatusServico;
	}
	public String getSiglaStatusServico() {
		return siglaStatusServico;
	}
	public void setSiglaStatusServico(String siglaStatusServico) {
		this.siglaStatusServico = siglaStatusServico;
	}
	public String getServicosAgendamento() {
		return servicosAgendamento;
	}
	public void setServicosAgendamento(String servicosAgendamento) {
		this.servicosAgendamento = servicosAgendamento;
	}
	public String getObsAgendamento() {
		return obsAgendamento;
	}
	public void setObsAgendamento(String obsAgendamento) {
		this.obsAgendamento = obsAgendamento;
	}
	public String getObsConcluirAgendamento() {
		return obsConcluirAgendamento;
	}
	public void setObsConcluirAgendamento(String obsConcluirAgendamento) {
		this.obsConcluirAgendamento = obsConcluirAgendamento;
	}
	public String getObsCancelarServico() {
		return obsCancelarServico;
	}
	public void setObsCancelarServico(String obsCancelarServico) {
		this.obsCancelarServico = obsCancelarServico;
	}
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getDeHorarioServico() {
		return deHorarioServico;
	}
	public void setDeHorarioServico(String deHorarioServico) {
		this.deHorarioServico = deHorarioServico;
	}
	public String getAteHorarioServico() {
		return ateHorarioServico;
	}
	public void setAteHorarioServico(String ateHorarioServico) {
		this.ateHorarioServico = ateHorarioServico;
	}
	public Long getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getDescricaoVeiculo() {
		return descricaoVeiculo;
	}
	public void setDescricaoVeiculo(String descricaoVeiculo) {
		this.descricaoVeiculo = descricaoVeiculo;
	}
	public String getDeHorarioAgendamento() {
		return deHorarioAgendamento;
	}
	public void setDeHorarioAgendamento(String deHorarioAgendamento) {
		this.deHorarioAgendamento = deHorarioAgendamento;
	}
	public String getAteHorarioAgendamento() {
		return ateHorarioAgendamento;
	}
	public void setAteHorarioAgendamento(String ateHorarioAgendamento) {
		this.ateHorarioAgendamento = ateHorarioAgendamento;
	}
	public String getTempoTotalServico() {
		return tempoTotalServico;
	}
	public void setTempoTotalServico(String tempoTotalServico) {
		this.tempoTotalServico = tempoTotalServico;
	}
	public List<ServicosBean> getListServicosBean() {
		return listServicosBean;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public void setListServicosBean(List<ServicosBean> listServicosBean) {
		this.listServicosBean = listServicosBean;
	}
	
	
	
	

}
