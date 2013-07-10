package com.digital.dao;

import java.util.List;

import com.digital.bean.ServicosBean;

public interface IServicosDAO {
	
   public Boolean salvar(ServicosBean bean);
	
	public Boolean atualizar(ServicosBean bean);
	
	public Boolean remover(ServicosBean bean);
	
	public List<ServicosBean> listar(Long idEmpresa);
	
	public void fecharConexao();

}
