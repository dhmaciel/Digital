package com.digital.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.digital.bean.ServicosBean;
import com.digital.bean.TipoVeiculoBean;
import com.digital.bean.VeiculoBean;
import com.digital.util.ConnectionFactory;
import com.digital.util.ValorMonetarioHelper;

public class ServicosDAO implements IServicosDAO{
	
	private Connection conn = null;

	public ServicosDAO() {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public Boolean salvar(ServicosBean bean) {
		PreparedStatement ps = null;
		try{
			
			conn.setAutoCommit(false);
			
			 ps = conn.prepareStatement("INSERT INTO Dig_Servicos (descricao, valor, tempo_Execucao, id_Empresa, id_Tipo_Veiculo)"+
					 		" VALUES (?, ?, ?, ?, ?)");
			 
			 ps.setString(1, bean.getDescricao());
			 ps.setBigDecimal(2, (BigDecimal.valueOf(Double.valueOf(bean.getValor().replace(".", "").replace(",", ".")))));				 
			 ps.setString(3, bean.getTempoExecucao());
			 ps.setLong(4, bean.getIdEmpresa());
			 ps.setLong(5, bean.getIdTipoVeiculo());
			 
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return false;
	}

	@Override
	public Boolean atualizar(ServicosBean bean) {
		PreparedStatement ps = null;
		try{		
			
			 ps = conn.prepareStatement("UPDATE Dig_Servicos set descricao = ?, valor = ?, tempo_execucao = ?,"+
						" id_tipo_veiculo = ?"+
						" WHERE id_Empresa = ? AND id_servicos = ?" );
			
			ps.setString(1, bean.getDescricao());
			ps.setBigDecimal(2, (BigDecimal.valueOf(Double.valueOf(bean.getValor().replace(".", "").replace(",", ".")))));				
			ps.setString(3, bean.getTempoExecucao());
			ps.setLong(4, bean.getIdTipoVeiculo());		
			ps.setLong(5, bean.getIdEmpresa());
			ps.setLong(6, bean.getIdServicos());
			
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
	public Boolean remover(ServicosBean bean) {
		PreparedStatement ps = null;
		try{		
			
			 ps = conn.prepareStatement("DELETE FROM Dig_Servicos "+
						" WHERE id_servicos = ?" );
			
			ps.setLong(1, bean.getIdServicos());
			
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
	public List<ServicosBean> listar(Long idEmpresa) {
		List<ServicosBean> list = new ArrayList<ServicosBean>();
		ResultSet rs = null;
		//Statement st = null;
		PreparedStatement ps = null;
		try{
			//st = conn.createStatement();
			String SQL = "SELECT * FROM Dig_Servicos s"+ 
						" INNER JOIN dig_tipo_veiculo t on s.id_tipo_veiculo = t. id_tipo_veiculo"+
						" WHERE s.id_Empresa = ?";
			ps = conn.prepareStatement(SQL);
			
			ps.setLong(1, idEmpresa);
				
			rs = ps.executeQuery();
			
			while(rs.next()){
				ServicosBean bean = new ServicosBean();
				bean.setIdServicos(rs.getLong("id_Servicos"));
				bean.setDescricao(rs.getString("descricao"));
				//bean.setValor(rs.getBigDecimal("valor").setScale(2).toString());
				bean.setValor(ValorMonetarioHelper.formata("###,##0.00",(rs.getDouble("valor"))));						
				bean.setTempoExecucao((rs.getTime("tempo_Execucao")).toString());
				bean.setIdEmpresa(rs.getLong("id_Empresa"));
				bean.setIdTipoVeiculo(rs.getLong("id_Tipo_Veiculo"));
				bean.setDescricaoTipoVeiculo(rs.getString(8));
				
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

	public List<TipoVeiculoBean> findTipoVeiculo() {
		List<TipoVeiculoBean> list = new ArrayList<TipoVeiculoBean>();
		ResultSet rs = null;
		Statement st = null;
		try{
			st = conn.createStatement();
			String SQL = "SELECT * FROM dig_tipo_veiculo";
			
			rs = st.executeQuery(SQL);
			
			while(rs.next()){
				TipoVeiculoBean veiculo = new TipoVeiculoBean();
				veiculo.setIdTipoVeiculo(rs.getLong("id_tipo_veiculo"));
				veiculo.setDescricao(rs.getString("descricao"));
				
				list.add(veiculo);
			}
		}catch(SQLException sql){
			sql.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		this.fecharConexao();
		return list;
	}

	public List<ServicosBean> findAllServicosBy(VeiculoBean bean,
			String idEmpresa) {
		List<ServicosBean> list = new ArrayList<ServicosBean>();
		
		ResultSet rs = null;
		Statement st = null;
		try{
			st = conn.createStatement();
			String SQL = "SELECT * FROM dig_servicos WHERE id_Tipo_Veiculo = "+bean.getIdTipoVeiculo()+ 
					" AND id_Empresa = "+idEmpresa;
			
			rs = st.executeQuery(SQL);
			
			while(rs.next()){
				ServicosBean servicos = new ServicosBean();
				servicos.setIdServicos(rs.getLong("id_Servicos"));
				servicos.setIdTipoVeiculo(rs.getLong("id_tipo_veiculo"));
				servicos.setDescricao(rs.getString("descricao"));
				servicos.setValor(ValorMonetarioHelper.formata("###,##0.00",(rs.getDouble("valor"))));						
				servicos.setTempoExecucao((rs.getTime("tempo_Execucao")).toString());
				servicos.setIdEmpresa(rs.getLong("id_Empresa"));
				servicos.setIdTipoVeiculo(rs.getLong("id_Tipo_Veiculo"));
				list.add(servicos);
			}
		}catch(SQLException sql){
			sql.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		this.fecharConexao();
		return list;
	}

}
