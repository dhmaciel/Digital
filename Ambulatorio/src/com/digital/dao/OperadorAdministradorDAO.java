package com.digital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.digital.bean.OperadorAdministradorBean;
import com.digital.bean.PerfilSisBean;
import com.digital.util.ConnectionFactory;

public class OperadorAdministradorDAO implements IOperadorAdministradorDAO{
	
	private Connection conn = null;
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	public OperadorAdministradorDAO() {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public Boolean salvar(OperadorAdministradorBean bean) {
		Statement st = null;
		try{
			st = conn.createStatement();
			conn.setAutoCommit(false);
			String SQL = "INSERT INTO Dig_Cliente (nome, endereco, cidade, estado, telefone, cpf, email, id_Cargo, inicio_Atividades, desligamento, id_Empresa, id_Perfil_Sis) VALUES ('"+bean.getNome()+"','"+bean.getEndereco()+"','"
						+bean.getCidade()+"','"+bean.getEstado()+"','"+bean.getTelefone()+"','"+bean.getCpf()+"','"+bean.getEmail()+"',"+(bean.getIdCargo() == 0 ? null : bean.getIdCargo())+",'"+bean.getInicioAtividades()+"','"+bean.getTerminoAtividades()+"',"+bean.getIdEmpresa()+","+bean.getIdPerfilSis()+")";
			//ps = conn.prepareStatement(); 
			st.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
			//ps.executeUpdate();
			
			//Busca o id da coluna inserida
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()){
				int key = rs.getInt(1);
				//for(HorarioFuncionamentoBean funcionamentoBean : bean.getFuncionamentoBeans()){
					SQL = "INSERT INTO Dig_Usuario_Cliente_Sis (id_Perfil_Sis, id_Cliente, usuario, senha) VALUES ("+bean.getIdPerfilSis()+
							","+key+",'"+bean.getUsuarioStr()+"','"+bean.getSenhaStr()+"')";
					st.executeUpdate(SQL);					
				//}			
			}
			
			conn.commit();
			
		}catch(SQLException sql){
			if(conn != null){
				try {
					conn.rollback();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
			sql.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			fecharConexao();
		}
		
		return true;
	}

	@Override
	public Boolean atualizar(OperadorAdministradorBean bean) {
		PreparedStatement ps = null;
		try{		
			 conn.setAutoCommit(false);
			 if(bean.getIdCargo() == 0){
				bean.setIdCargo(null); 
			 }
			 ps = conn.prepareStatement("UPDATE Dig_Cliente set nome = ?, endereco = ?, cidade = ?, estado = ?, telefone = ?, cpf = ?, email = ?,"+
						" id_Cargo = "+bean.getIdCargo()+", inicio_Atividades = ?, desligamento = ?, id_Perfil_Sis = ?"+
						" WHERE id_Cliente = ?");
			
			ps.setString(1, bean.getNome());
			ps.setString(2, bean.getEndereco());
			ps.setString(3, bean.getCidade());
			ps.setString(4, bean.getEstado());
			ps.setString(5, bean.getTelefone());
			ps.setString(6, bean.getCpf());
			ps.setString(7, bean.getEmail());
			//ps.setLong(8, (bean.getIdCargo() == 0) ? null : bean.getIdCargo());		
			ps.setString(8, bean.getInicioAtividades());
			ps.setString(9, bean.getTerminoAtividades());
			ps.setLong(10, bean.getIdPerfilSis());
			ps.setLong(11, bean.getIdCliente());
			
			ps.executeUpdate();
			
			 ps = conn.prepareStatement("UPDATE Dig_Usuario_Cliente_Sis set id_Perfil_Sis = ?, id_Cliente = ?, usuario = ?, senha = ?"+
						" WHERE id_Usuario_Cliente_Sis = ?");
			 
			 ps.setLong(1, bean.getIdPerfilSis());
			 ps.setLong(2, bean.getIdCliente());
			 ps.setString(3, bean.getUsuarioStr());
			 ps.setString(4, bean.getSenhaStr());
			 ps.setLong(5, bean.getIdUsuarioClienteSis());
			 
			 ps.executeUpdate();
			
			conn.commit();
			
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
	public Boolean remover(OperadorAdministradorBean bean) {		
		PreparedStatement ps = null;
		try{		
			 conn.setAutoCommit(false);
			 ps = conn.prepareStatement("DELETE FROM Dig_Usuario_Cliente_Sis "+
					 " WHERE id_Usuario_Cliente_Sis = ?" );
			 
			 ps.setLong(1, bean.getIdUsuarioClienteSis());
			 
			 ps.executeUpdate();
			 
			 ps = conn.prepareStatement("DELETE FROM Dig_Cliente "+
						" WHERE id_Cliente = ?" );
			
			ps.setLong(1, bean.getIdCliente());			
			
			ps.executeUpdate();
			
			conn.commit();
			
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
	public List<OperadorAdministradorBean> listar(Long idEmpresa) {
		List<OperadorAdministradorBean> list = new ArrayList<OperadorAdministradorBean>();
		ResultSet rs = null;
		//Statement st = null;
		PreparedStatement ps = null;
		try{
			//st = conn.createStatement();
			String SQL = "SELECT * FROM dig_cliente c INNER JOIN Dig_Usuario_Cliente_Sis u"+
						" ON u.id_Cliente = c.id_Cliente"+
						" INNER JOIN Dig_Perfil_Sis p"+
						" ON p.id_Perfil_Sis = u.id_Perfil_Sis"+
						" LEFT JOIN Dig_Cargo car"+
						" ON c.id_Cargo = car.id_Cargo"+
						" AND c.id_Empresa =  ?";
			
			ps = conn.prepareStatement(SQL);
			
			ps.setLong(1, idEmpresa);
				
			rs = ps.executeQuery();
			
			while(rs.next()){
				OperadorAdministradorBean bean = new OperadorAdministradorBean();
				bean.setIdCliente(rs.getLong(1));
				bean.setNome(rs.getString("nome"));
				bean.setEndereco(rs.getString("endereco"));
				bean.setCidade(rs.getString("cidade"));
				bean.setEstado(rs.getString("estado"));
				bean.setTelefone(rs.getString("telefone"));
				bean.setCpf(rs.getString("cpf"));
				bean.setEmail(rs.getString("email"));
				bean.setIdCargo(rs.getLong(9));
				bean.setInicioAtividades((format.format(rs.getDate("inicio_Atividades")).toString()));
				bean.setTerminoAtividades((format.format(rs.getDate("desligamento")).toString()));
				bean.setIdEmpresa( rs.getLong("id_Empresa"));
				bean.setIdPerfilSis( rs.getLong(13));
				bean.setIdUsuarioClienteSis( rs.getLong("id_Usuario_Cliente_Sis"));
				bean.setUsuarioStr(rs.getString("usuario"));
				bean.setSenhaStr(rs.getString("senha"));
				bean.setCargoStr(rs.getString("descricao"));
				bean.setPerfilStr(rs.getString("nome_Perfil"));
				
				if(bean.getTerminoAtividades().equals("01/01/1900")){
					bean.setTerminoAtividades("");
				}
				
				
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
	
	public List<PerfilSisBean> listarTipoUsuario(){
		List<PerfilSisBean> list = new ArrayList<PerfilSisBean>();
		ResultSet rs = null;
		//Statement st = null;
		PreparedStatement ps = null;
		try{
			//st = conn.createStatement();
			String SQL = "SELECT * FROM Dig_Perfil_Sis WHERE sigla <> 'CLI'"; 
			
					ps = conn.prepareStatement(SQL);			
				
			rs = ps.executeQuery();
			
			while(rs.next()){
				PerfilSisBean bean = new PerfilSisBean();
				bean.setIdPerfilSis(rs.getLong("id_Perfil_Sis"));
				bean.setNomePerfil(rs.getString("nome_Perfil"));
				bean.setSigla(rs.getString("sigla"));
				
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
		//Query: SELECT * FROM Dig_Perfil_Sis WHERE sigla <> 'CLI'		
		return list;
		
	}

}
