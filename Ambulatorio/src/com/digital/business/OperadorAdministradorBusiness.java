package com.digital.business;

import java.util.List;

import com.digital.bean.OperadorAdministradorBean;
import com.digital.bean.PerfilSisBean;
import com.digital.dao.OperadorAdministradorDAO;

public class OperadorAdministradorBusiness {

	public List<PerfilSisBean> findAllTipoUsuario() {
		
		OperadorAdministradorDAO dao = new OperadorAdministradorDAO();
		
		return dao.listarTipoUsuario();
		
	}
	
	public List<OperadorAdministradorBean> findAllOperadorAdministrador (Long idEmpresa){
		
		OperadorAdministradorDAO dao = new OperadorAdministradorDAO();
		
		return dao.listar(idEmpresa);
		
	}

	public Boolean salvarOperadorAdministrador(OperadorAdministradorBean bean) {
		
		OperadorAdministradorDAO dao = new OperadorAdministradorDAO();
		
		if(bean.getIdCliente() == 0){
			return dao.salvar(bean);
		}else{
			return dao.atualizar(bean);
		}
		
	}
	
	public Boolean removerOperadorAdministrador (OperadorAdministradorBean bean){
		
		OperadorAdministradorDAO dao = new OperadorAdministradorDAO();
		
		return dao.remover(bean);
		
	}

}
