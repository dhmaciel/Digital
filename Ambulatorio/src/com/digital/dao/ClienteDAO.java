package com.digital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.digital.bean.ClienteBean;
import com.digital.bean.PerfilSisBean;
import com.digital.util.ConnectionFactory;

public class ClienteDAO implements IClienteDAO{
	
	private Connection conn = null;

	public ClienteDAO() {
		this.conn = ConnectionFactory.getConnection();
	}


	@Override
	public Boolean salvar(ClienteBean bean) {
		Statement st = null;
		try{
			
			st = conn.createStatement();
			conn.setAutoCommit(false);
			String SQL = "INSERT INTO Dig_Usuario (nome, endereco, cidade, estado, telefone, cpf, email, id_Perfil_Sis) VALUES ('"+bean.getNome()+"','"+bean.getEndereco()+"','"
						+bean.getCidade()+"','"+bean.getEstado()+"','"+bean.getTelefone()+"','"+bean.getCpf()+"','"+bean.getEmail()+"',"+bean.getIdPerfilSis()+")";
			//ps = conn.prepareStatement(); 
			st.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
			//ps.executeUpdate();
			
			//Busca o id da coluna inserida
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()){
				int key = rs.getInt(1);
				//for(HorarioFuncionamentoBean funcionamentoBean : bean.getFuncionamentoBeans()){
					SQL = "INSERT INTO Dig_Usuario_Cliente_Sis (id_Perfil_Sis, id_Usuario, usuario, senha) VALUES ("+bean.getIdPerfilSis()+
							","+key+",'"+bean.getUsuarioStr()+"','"+bean.getSenhaStr()+"')";
					st.executeUpdate(SQL);					
				//}	
					
					for(int i = 0; i < bean.getListVeiculoBean().size(); i++){
						
						SQL = "INSERT INTO Dig_Veiculo (descricao, id_Tipo_Veiculo, id_Usuario) VALUES ('"+bean.getListVeiculoBean().get(i).getDescricao()+"',"+
						bean.getListVeiculoBean().get(i).getIdTipoVeiculo()+","+key+")";
						st.executeUpdate(SQL);
					}
					
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
	public Boolean atualizar(ClienteBean bean) {
		PreparedStatement ps = null;
		try{		
			 conn.setAutoCommit(false);
			
			 ps = conn.prepareStatement("UPDATE Dig_Usuario set nome = ?, endereco = ?, cidade = ?, estado = ?, telefone = ?, cpf = ?, email = ?,"+
						" id_Perfil_Sis = ? WHERE id_Usuario = ?");
			
			ps.setString(1, bean.getNome());
			ps.setString(2, bean.getEndereco());
			ps.setString(3, bean.getCidade());
			ps.setString(4, bean.getEstado());
			ps.setString(5, bean.getTelefone());
			ps.setString(6, bean.getCpf());
			ps.setString(7, bean.getEmail());
			ps.setLong(8, bean.getIdPerfilSis());
			ps.setLong(9, bean.getIdUsuario());
			
			ps.executeUpdate();
			
			 ps = conn.prepareStatement("UPDATE Dig_Usuario_Cliente_Sis set  id_Usuario = ?, usuario = ?, senha = ?"+
						" WHERE id_Usuario_Cliente_Sis = ?");
			 
			 ps.setLong(1, bean.getIdUsuario());
			 ps.setString(2, bean.getUsuarioStr());
			 ps.setString(3, bean.getSenhaStr());
			 ps.setLong(4, bean.getIdUsuarioClienteSis());
			 
			 ps.executeUpdate();
			 
			 /*Deleta os registros da tabela veiculo  */
			 ps = conn.prepareStatement("DELETE FROM Dig_Veiculo "+
						" WHERE id_Usuario = ?" );
			
			ps.setLong(1, bean.getIdUsuario());			
			
			ps.executeUpdate();
			
			/* Insere novamente os registros de veículo.*/			
			for(int i = 0; i < bean.getListVeiculoBean().size(); i++){
				
				ps = conn.prepareStatement("INSERT INTO Dig_Veiculo (descricao, id_Tipo_Veiculo, id_Usuario) VALUES ('"+bean.getListVeiculoBean().get(i).getDescricao()+"',"+
				bean.getListVeiculoBean().get(i).getIdTipoVeiculo()+","+bean.getIdUsuario()+")");				
				ps.executeUpdate();
			}			
			
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
	public Boolean remover(ClienteBean bean) {
		PreparedStatement ps = null;
		try{		
			 conn.setAutoCommit(false);
			 /*ps = conn.prepareStatement("DELETE FROM Dig_Usuario_Cliente_Sis "+
					 " WHERE id_Usuario_Cliente_Sis = ?" );
			 
			 ps.setLong(1, bean.getIdUsuarioClienteSis());
			 
			 ps.executeUpdate();
			 
			 for(VeiculoBean veiculoBean : bean.getListVeiculoBean()){
				 
				 ps = conn.prepareStatement("DELETE FROM Dig_Veiculo "+
						 " WHERE id_Veiculo = ?" );
				 
				 ps.setLong(1, veiculoBean.getIdTipoVeiculo());				 
				 ps.executeUpdate();
				 
				 conn.commit();
			 }*/
			 
			 ps = conn.prepareStatement("DELETE FROM Dig_Usuario "+
						" WHERE id_Usuario = ?" );
			
			ps.setLong(1, bean.getIdUsuario());			
			
			ps.executeUpdate();
			
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
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.fecharConexao();
		}		
		return true;
	}

	@Override
	public List<ClienteBean> listar() {
		List<ClienteBean> list = new ArrayList<ClienteBean>();
		ResultSet rs = null;
		//Statement st = null;
		PreparedStatement ps = null;
		try{
			//st = conn.createStatement();
			String SQL = "SELECT * FROM Dig_Usuario c INNER JOIN Dig_Usuario_Cliente_Sis u"+
						 " ON u.id_Usuario = c.id_Usuario"+
						 " INNER JOIN Dig_Perfil_Sis p"+
						 " ON p.id_Perfil_Sis = u.id_Perfil_Sis";
					
			ps = conn.prepareStatement(SQL);			
				
			rs = ps.executeQuery();
			
			VeiculoDAO dao = new VeiculoDAO();
			
			while(rs.next()){
				ClienteBean bean = new ClienteBean();
				bean.setIdUsuario(rs.getLong(1));
				bean.setNome(rs.getString("nome"));
				bean.setEndereco(rs.getString("endereco"));
				bean.setCidade(rs.getString("cidade"));
				bean.setEstado(rs.getString("estado"));
				bean.setTelefone(rs.getString("telefone"));
				bean.setCpf(rs.getString("cpf"));
				bean.setEmail(rs.getString("email"));
				bean.setIdPerfilSis( rs.getLong(9));
				bean.setIdUsuarioClienteSis( rs.getLong("id_Usuario_Cliente_Sis"));
				bean.setUsuarioStr(rs.getString("usuario"));
				bean.setSenhaStr(rs.getString("senha"));
				bean.setPerfilStr(rs.getString("nome_Perfil"));
				
				bean.setListVeiculoBean(dao.listar(bean.getIdUsuario()));				
				
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

	public PerfilSisBean findPerfilCliente() {
		PerfilSisBean perfil = new PerfilSisBean();
		ResultSet rs = null;
		//Statement st = null;
		PreparedStatement ps = null;
		try{
			//st = conn.createStatement();
			String SQL = "SELECT * FROM Dig_Perfil_Sis WHERE sigla = 'CLI'"; 
			
			ps = conn.prepareStatement(SQL);			
				
			rs = ps.executeQuery();
			
			if(rs.next()){
				perfil.setIdPerfilSis(rs.getLong("id_Perfil_Sis"));
				perfil.setNomePerfil(rs.getString("nome_Perfil"));
				perfil.setSigla(rs.getString("sigla"));					
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
				e.printStackTrace();
			}
			fecharConexao();
		}		
		return perfil;		
	}

}
