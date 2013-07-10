package com.digital.business;

import java.util.List;

import com.digital.bean.CargoBean;
import com.digital.dao.CargoDAO;

public class CargoBusiness {
	

	public Boolean salvarCargo(CargoBean bean) {
		
		CargoDAO dao = new CargoDAO();
		
		if(bean.getIdCargo() == 0){
			return dao.salvar(bean);
		}else{
			return dao.atualizar(bean);
		}		
		
	}

	public List<CargoBean> findAllCargos(Long idEmpresa) {
		
		CargoDAO dao = new CargoDAO();
		
		return dao.listar(idEmpresa);
		
	}

	public Boolean removerCargo(CargoBean bean) {
		 
		CargoDAO dao = new CargoDAO();
		
		return dao.remover(bean);
	}


}
