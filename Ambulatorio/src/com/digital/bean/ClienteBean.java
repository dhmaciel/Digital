package com.digital.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Este bean representa a tabela Dig_Usuário do BD.
 * @author Douglas
 *
 */
public class ClienteBean { 
	
	private Long idUsuario;
	private String nome;
	private String endereco;
	private String estado;
	private String cidade;
	private String telefone;
	private String email;
	private String cpf;	
	private Long idPerfilSis;
	private String perfilStr;
	private Long idUsuarioClienteSis;
	private String usuarioStr;
	private String senhaStr;
	private Long idVeiculo;
	private String veiculoStr;
	private List<VeiculoBean> listVeiculoBean = new ArrayList<VeiculoBean>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Long getIdPerfilSis() {
		return idPerfilSis;
	}
	public void setIdPerfilSis(Long idPerfilSis) {
		this.idPerfilSis = idPerfilSis;
	}
	public String getUsuarioStr() {
		return usuarioStr;
	}
	public void setUsuarioStr(String usuarioStr) {
		this.usuarioStr = usuarioStr;
	}
	public String getSenhaStr() {
		return senhaStr;
	}
	public void setSenhaStr(String senhaStr) {
		this.senhaStr = senhaStr;
	}
	public Long getIdUsuarioClienteSis() {
		return idUsuarioClienteSis;
	}
	public void setIdUsuarioClienteSis(Long idUsuarioClienteSis) {
		this.idUsuarioClienteSis = idUsuarioClienteSis;
	}
	
	public String getPerfilStr() {
		return perfilStr;
	}
	public void setPerfilStr(String perfilStr) {
		this.perfilStr = perfilStr;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getVeiculoStr() {
		return veiculoStr;
	}
	public void setVeiculoStr(String veiculoStr) {
		this.veiculoStr = veiculoStr;
	}
	public List<VeiculoBean> getListVeiculoBean() {
		return listVeiculoBean;
	}
	public void setListVeiculoBean(List<VeiculoBean> listVeiculoBean) {
		this.listVeiculoBean = listVeiculoBean;
	}
	
	

}
