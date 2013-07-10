package com.digital.dao;

import java.util.List;

import com.digital.bean.OperadorAdministradorBean;

public interface IOperadorAdministradorDAO {
	
	 public Boolean salvar(OperadorAdministradorBean bean);
		
		public Boolean atualizar(OperadorAdministradorBean bean);
		
		public Boolean remover(OperadorAdministradorBean bean);
		
		public List<OperadorAdministradorBean> listar(Long idEmpresa);
		
		public void fecharConexao();

}
