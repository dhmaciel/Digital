package com.digital.dao;

import java.util.List;

import com.digital.bean.ClienteBean;

	public interface IClienteDAO {
	
	public Boolean salvar(ClienteBean bean);
	
	public Boolean atualizar(ClienteBean bean);
	
	public Boolean remover(ClienteBean bean);
	
	public List<ClienteBean> listar();
	
	public void fecharConexao();

}
