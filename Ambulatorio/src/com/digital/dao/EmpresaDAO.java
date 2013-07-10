package com.digital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.digital.bean.EmpresaBean;
import com.digital.util.ConnectionFactory;

public class EmpresaDAO implements IEmpresaDAO{

	private Connection conn = null;
		
	public EmpresaDAO(){
		conn = ConnectionFactory.getConnection();
	}
	
	@Override
	public Boolean salvar(EmpresaBean bean) {
		//PreparedStatement ps = null;
		Statement st = null;
		try{
			st = conn.createStatement();
			conn.setAutoCommit(false);
			String SQL = "INSERT INTO Dig_Empresa (razao_Social, cnpj, telefone, email, endereco, cidade, estado) VALUES ('"+bean.getRazaoSocial()+"','"+bean.getCnpj()+"','"
						+bean.getTelefone()+"','"+bean.geteMail()+"','"+bean.getEndereco()+"','"+bean.getCidade()+"','"+bean.getEstado()+"')";
			//ps = conn.prepareStatement(); 
			st.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
			//ps.executeUpdate();
			
			//Busca o id da coluna inserida
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()){
				int key = rs.getInt(1);
				//for(HorarioFuncionamentoBean funcionamentoBean : bean.getFuncionamentoBeans()){
					SQL = "INSERT INTO Dig_Horario_Funcionamento (deSegSexta, ateSegSexta, deSabado, ateSabado, deDomingo, ateDomingo, id_empresa) VALUES ('"+bean.getHorarioDeSegSexta()+
							"','"+bean.getHorarioAteSegSexta()+"','"+bean.getHorarioDeSabado()+"','"+bean.getHorarioAteSabado()+"','"+bean.getHorarioDeDomingo()+
							"','"+bean.getHorarioAteDomingo()+"',"+key+")";
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
	public void remover(EmpresaBean bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmpresaBean> listar() {
		List<EmpresaBean> listBean = new ArrayList<EmpresaBean>();
		ResultSet rs = null;
		Statement st = null;
		try{
			st = conn.createStatement();
			String SQL = "SELECT * FROM Dig_Empresa emp INNER JOIN Dig_Horario_Funcionamento func"+
					" on emp.id_Empresa = func.id_empresa ORDER BY emp.razao_Social";
			rs = st.executeQuery(SQL);
			
			while(rs.next()){
				EmpresaBean bean = new EmpresaBean();
				bean.setIdEmpresa(rs.getLong("id_empresa"));
				bean.setRazaoSocial(rs.getString("razao_Social"));
				bean.setCnpj(rs.getString("cnpj"));
				bean.setTelefone(rs.getString("telefone"));
				bean.seteMail(rs.getString("email"));
				bean.setEndereco(rs.getString("endereco"));
				bean.setCidade(rs.getString("cidade"));
				bean.setEstado(rs.getString("estado"));
				bean.setHorarioDeSegSexta(rs.getTime("deSegSexta").toString());
				bean.setHorarioAteSegSexta(rs.getTime("ateSegSexta").toString());
				bean.setHorarioDeSabado(rs.getTime("deSabado").toString());
				bean.setHorarioAteSabado(rs.getTime("ateSabado").toString());
				bean.setHorarioDeDomingo(rs.getTime("deDomingo").toString());
				bean.setHorarioAteDomingo(rs.getTime("ateDomingo").toString());
				bean.setEmpresaStr(bean.getRazaoSocial()+" - " + bean.getEndereco()+" - " + bean.getCidade()+" - "+bean.getEstado());
				
				listBean.add(bean);					
			}
			
		}catch(SQLException sql){
			sql.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fecharConexao();
		}		
		
		return listBean;
	}

	@Override
	public Boolean atualizar(EmpresaBean bean) {
		PreparedStatement ps = null;
		try{
			int updateQuery = 0;
			conn.setAutoCommit(false);
			
			 ps = conn.prepareStatement("UPDATE dig_empresa set razao_Social = ?, cnpj = ?, telefone = ?,"+
						"email = ?, endereco = ?, cidade = ?, estado = ?"+
						"WHERE id_Empresa = ?");
			
			ps.setString(1, bean.getRazaoSocial());
			ps.setString(2, bean.getCnpj());
			ps.setString(3, bean.getTelefone());
			ps.setString(4, bean.geteMail());
			ps.setString(5, bean.getEndereco());
			ps.setString(5, bean.getEndereco());
			ps.setString(6, bean.getCidade());
			ps.setString(7, bean.getEstado());
			ps.setLong(8, bean.getIdEmpresa());
			
			updateQuery = ps.executeUpdate();
			//conn.commit();
			
			if(updateQuery == 1){
				ps = conn.prepareStatement("UPDATE dig_horario_funcionamento set deSegSexta = ?, ateSegSexta = ?, deSabado = ?,"+
							" ateSabado = ?, deDomingo = ?, ateDomingo = ?"+
							" WHERE id_empresa = ?");
				
				ps.setString(1, bean.getHorarioDeSegSexta());
				ps.setString(2, bean.getHorarioAteSegSexta());
				ps.setString(3, bean.getHorarioDeSabado());
				ps.setString(4, bean.getHorarioAteSabado());
				ps.setString(5, bean.getHorarioDeDomingo());
				ps.setString(6, bean.getHorarioAteDomingo());
				ps.setLong(7, bean.getIdEmpresa());
				
				updateQuery = ps.executeUpdate();
				
				conn.commit();
				
			}else{
				throw new Exception();
			}
			
			//System.out.println(updateQuery);
			
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
