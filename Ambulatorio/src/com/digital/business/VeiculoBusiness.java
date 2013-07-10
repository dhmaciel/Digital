package com.digital.business;

import com.digital.bean.VeiculoBean;
import com.digital.dao.VeiculoDAO;

public class VeiculoBusiness {
	
	public Boolean salvarServico(VeiculoBean bean) {
		
		VeiculoDAO dao = new VeiculoDAO();
		
		if(bean.getIdUsuario() == 0){
			return dao.salvar(bean);
		}else{
			return dao.atualizar(bean);
		}		
		
	}

	public Boolean removerServico(VeiculoBean bean) {
		 
		VeiculoDAO dao = new VeiculoDAO();
		
		return dao.remover(bean);
	}


}
