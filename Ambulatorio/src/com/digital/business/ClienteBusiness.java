package com.digital.business;

import java.util.List;

import com.digital.bean.ClienteBean;
import com.digital.bean.PerfilSisBean;
import com.digital.dao.ClienteDAO;

public class ClienteBusiness {
	
	public Boolean salvarCliente(ClienteBean bean) {
		
		ClienteDAO dao = new ClienteDAO();
		
		if(bean.getIdUsuario() == 0){
			return dao.salvar(bean);
		}else{
			return dao.atualizar(bean);
		}		
		
	}

	public Boolean removerCliente(ClienteBean bean){
		 
		ClienteDAO dao = new ClienteDAO();
		
		return dao.remover(bean);
	}
	
	public List<ClienteBean> findAllCliente (){
		
		ClienteDAO dao = new ClienteDAO();
		
		return dao.listar();
	}

	public PerfilSisBean findPerfilCliente() {
		
		ClienteDAO dao = new ClienteDAO();
		
		return dao.findPerfilCliente();
	}


}
