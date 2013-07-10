package com.digital.business;

import java.util.List;

import com.digital.bean.EmpresaBean;
import com.digital.dao.EmpresaDAO;

public class EmpresaBusiness {

	public Boolean salvarAtualizarEmpresa(EmpresaBean bean) {
		
		EmpresaDAO dao = new EmpresaDAO();
		if(bean.getIdEmpresa() == 0){
			if(dao.salvar(bean)){
				return true;
			}
		}else{
			if(dao.atualizar(bean)){
				return true;
			}
		}
		
		return false;
	}

	public List<EmpresaBean> listarEmpresasCadastradas() {
		
		EmpresaDAO dao = new EmpresaDAO();
		
		return dao.listar();		
		
		
	}



}
