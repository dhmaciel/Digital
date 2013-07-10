package com.digital.dao;

import java.util.List;

import com.digital.bean.AgendaBean;

public interface IAgendaDAO {
	
	public void fecharConexao();
	
	public List<AgendaBean> listar();
	
	public Boolean salvar(AgendaBean bean);

}
