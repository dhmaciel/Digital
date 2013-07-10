package com.digital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.digital.bean.CargoBean;
import com.digital.util.ConnectionFactory;

public class CargoDAO implements ICargoDAO{
	
	private Connection conn = null;	

	public CargoDAO() {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public Boolean salvar(CargoBean bean) {
		PreparedStatement ps = null;
		try{
			
			conn.setAutoCommit(false);
			
			 ps = conn.prepareStatement("INSERT INTO Dig_Cargo (descricao, id_Empresa)"+
					 		" VALUES (?, ?)");
			 
			 ps.setString(1, bean.getDescricao());
			 ps.setLong(2, bean.getIdEmpresa());
						 
			  ps.executeUpdate();
			 
			 conn.commit();
			 
			 return true;
			 
		}catch(SQLException sql){
			sql.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				this.fecharConexao();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		return false;
	}

	@Override
	public Boolean atualizar(CargoBean bean) {
		PreparedStatement ps = null;
		try{		
			
			 ps = conn.prepareStatement("UPDATE Dig_Cargo set descricao = ?"+
						" WHERE id_Cargo = ?" );
			
			ps.setString(1, bean.getDescricao());
			ps.setLong(2, bean.getIdCargo());			
						
			ps.executeUpdate();
			
		}catch(SQLException sql){
			sql.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.fecharConexao();
		}		
		return true;
	}

	@Override
	public Boolean remover(CargoBean bean) {
		PreparedStatement ps = null;
		try{		
			
			 ps = conn.prepareStatement("DELETE FROM Dig_Cargo "+
						" WHERE id_Cargo = ?" );
			
			ps.setLong(1, bean.getIdCargo());
			
			ps.executeUpdate();
			
		}catch(SQLException sql){
			sql.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.fecharConexao();
		}		
		return true;
		
	}

	@Override
	public List<CargoBean> listar(Long idEmpresa) {
		 List<CargoBean> list = new ArrayList<CargoBean>();
		 
		ResultSet rs = null;
		//Statement st = null;
		PreparedStatement ps = null;
		try{
			//st = conn.createStatement();
			String SQL = "SELECT * FROM Dig_Cargo WHERE id_Empresa = ?";
			
			ps = conn.prepareStatement(SQL);
			
			ps.setLong(1, idEmpresa);
				
			rs = ps.executeQuery();
			
			while(rs.next()){
				CargoBean bean = new CargoBean();
				bean.setIdCargo(rs.getLong("id_Cargo"));
				bean.setDescricao(rs.getString("descricao"));				
				
				list.add(bean);
				
			}
			
		}catch(SQLException sql){
			sql.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fecharConexao();
		}		
		
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
