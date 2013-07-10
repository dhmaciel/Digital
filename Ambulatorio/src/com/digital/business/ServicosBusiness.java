package com.digital.business;

import java.util.List;

import com.digital.bean.ServicosBean;
import com.digital.bean.TipoVeiculoBean;
import com.digital.dao.ServicosDAO;

public class ServicosBusiness{

	public List<TipoVeiculoBean> findTipoVeiculo() {
		
		ServicosDAO servicosDAO = new ServicosDAO();	
		
		return servicosDAO.findTipoVeiculo();
	}

	public Boolean salvarServico(ServicosBean bean) {
		
		ServicosDAO dao = new ServicosDAO();
		
		if(bean.getIdServicos() == 0){
			return dao.salvar(bean);
		}else{
			return dao.atualizar(bean);
		}		
		
	}

	public List<ServicosBean> findAllServicos(Long idEmpresa) {
		
		ServicosDAO dao = new ServicosDAO();
		
		return dao.listar(idEmpresa);
		
	}

	public Boolean removerServico(ServicosBean bean) {
		 
		ServicosDAO dao = new ServicosDAO();
		
		return dao.remover(bean);
	}

}
