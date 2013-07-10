package com.digital.dao;

import java.util.List;

import com.digital.bean.CargoBean;

public interface ICargoDAO {
	
	public Boolean salvar(CargoBean bean);
	
	public Boolean atualizar(CargoBean bean);
	
	public Boolean remover(CargoBean bean);
	
	public List<CargoBean> listar(Long idEmpresa);
	
	public void fecharConexao();

}
