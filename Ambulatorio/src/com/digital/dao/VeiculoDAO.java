package com.digital.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.digital.bean.VeiculoBean;
import com.digital.util.ConnectionFactory;

public class VeiculoDAO implements IVeiculoDAO{
	
	private Connection conn = null;
	
	public VeiculoDAO() {
		this.conn = ConnectionFactory.getConnection();
	}


	@Override
	public Boolean salvar(VeiculoBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean atualizar(VeiculoBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remover(VeiculoBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VeiculoBean> listar(Long idUsuario) {
		List<VeiculoBean> list = new ArrayList<VeiculoBean>();
		ResultSet rs = null;
		Statement st = null;
		try{
			st = conn.createStatement();
			String SQL = "SELECT * FROM Dig_Veiculo WHERE id_Usuario = "+idUsuario;
			
			rs = st.executeQuery(SQL);
			
			while(rs.next()){
				VeiculoBean veiculo = new VeiculoBean();
				veiculo.setIdVeiculo(rs.getLong("id_veiculo"));
				veiculo.setDescricao(rs.getString("descricao"));
				veiculo.setIdTipoVeiculo(rs.getLong("id_tipo_veiculo"));
				veiculo.setIdUsuario(rs.getLong("id_Usuario"));
				list.add(veiculo);
			}
		}catch(SQLException sql){
			sql.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		/*finally{
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		this.fecharConexao();*/
		
		return list;
	}

	@Override
	public void fecharConexao() {
		try {
			if(conn != null && conn.isClosed() == false){
				conn.close();
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}

}
