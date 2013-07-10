package com.digital.dao;

import java.util.List;

import com.digital.bean.EmpresaBean;

public interface IEmpresaDAO {
	
	public Boolean salvar(EmpresaBean bean);
	
	public Boolean atualizar(EmpresaBean bean);
	
	public void remover(EmpresaBean bean);
	
	public List<EmpresaBean> listar();
	
	public void fecharConexao();
	

}
