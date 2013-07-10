package com.digital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.digital.bean.LoginBean;
import com.digital.bean.UsuarioBean;
import com.digital.util.ConnectionFactory;

public class LoginDAO implements ILoginDAO{
	
	private Connection conn = null;

	public LoginDAO() {
		conn = ConnectionFactory.getConnection();
	}

	public UsuarioBean loginUser(LoginBean bean) {
		UsuarioBean usuarioBean;
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			String SQL = "SELECT * FROM Dig_Usuario_Cliente_Sis usu"+
					" INNER JOIN Dig_Perfil_Sis per ON per.id_Perfil_Sis = usu.id_Perfil_Sis"+
					" WHERE usu.usuario = ?"+ 
					" AND usu.senha = ?";
			
			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, bean.getLogin());
			ps.setString(2, bean.getSenha());
				
			rs = ps.executeQuery();
			
			if(rs.next()){
				usuarioBean  = new UsuarioBean();
				
				usuarioBean.setIdCliente(rs.getLong("id_Cliente"));
				usuarioBean.setIdPerfilSis(rs.getLong("id_Perfil_sis"));
				usuarioBean.setIdUsuario(rs.getLong("id_Usuario"));
				usuarioBean.setIdUsuarioClienteSis(rs.getLong("id_Usuario_Cliente_Sis"));
				usuarioBean.setNomePerfil(rs.getString("nome_Perfil"));
				usuarioBean.setUsuario(rs.getString("usuario"));
				usuarioBean.setSenha(rs.getString("senha"));
				usuarioBean.setSiglaPerfil(rs.getString("sigla"));
				
				if(usuarioBean.getIdUsuario() != null && usuarioBean.getIdUsuario() != 0){ //Operador (Funcionário.)
					if(bean.getIsClienteSelected()){
						SQL = "SELECT * FROM dig_usuario usu"+
								" INNER JOIN Dig_Usuario_Cliente_Sis cli ON usu.id_Usuario = cli.id_Usuario"+
								" AND usu.id_Usuario = ?";
						
						ps = conn.prepareStatement(SQL);
						
						ps.setLong(1, usuarioBean.getIdUsuario());
						
						rs = ps.executeQuery();
						
						if(rs.next()){
							usuarioBean.setNome(rs.getString("nome"));
							usuarioBean.setEmail(rs.getString("email"));
							usuarioBean.setCpf(rs.getString("cpf"));
							
							return usuarioBean;
						}		
						
					}
				}else{
					if(bean.getIsClienteSelected() == false){ // Cliente do lava á jato
					SQL = "SELECT * FROM Dig_Cliente cli"+
							" INNER JOIN Dig_Usuario_Cliente_Sis usuSis ON cli.id_Cliente = usuSis.id_Cliente"+
							" AND usuSis.id_Cliente = ?";
					
					ps = conn.prepareStatement(SQL);
					
					ps.setLong(1, usuarioBean.getIdCliente());
					
					rs = ps.executeQuery();
					
					if(rs.next()){
						usuarioBean.setNome(rs.getString("nome"));
						usuarioBean.setEmail(rs.getString("email"));
						usuarioBean.setCpf(rs.getString("cpf"));
						usuarioBean.setIdEmpresa(rs.getLong("id_Empresa"));
						usuarioBean.setIdCargo(rs.getLong("id_Cargo"));
						
						return usuarioBean;
						}	
					}
					
				}
				
								
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
		
		
		return null;
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
