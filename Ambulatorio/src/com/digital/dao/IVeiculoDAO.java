package com.digital.dao;

import java.util.List;

import com.digital.bean.VeiculoBean;

public interface IVeiculoDAO {
	
	public Boolean salvar(VeiculoBean bean);
	
	public Boolean atualizar(VeiculoBean bean);
	
	public Boolean remover(VeiculoBean bean);
	
	public List<VeiculoBean> listar(Long idUsuario);
	
	public void fecharConexao();


}
