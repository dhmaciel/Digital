package com.digital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.digital.bean.AgendaBean;
import com.digital.bean.ClienteBean;
import com.digital.bean.HorarioFuncionamentoBean;
import com.digital.bean.ServicosBean;
import com.digital.bean.StatusServicoBean;
import com.digital.util.ConnectionFactory;
import com.digital.util.ValorMonetarioHelper;

public class AgendaDAO implements IAgendaDAO{
	
	/**
	 * Data estilo dd/MM/yyyy
	 */
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Connection conn = null;

	public AgendaDAO() {
		conn = ConnectionFactory.getConnection();
	}

	public HorarioFuncionamentoBean buscarHorarioFuncionamento(String data,
			String diaSemana, Long idEmpresa) {
		
		HorarioFuncionamentoBean bean = new HorarioFuncionamentoBean();
		
		ResultSet rs = null;
		//Statement st = null;
		PreparedStatement ps = null;
		try{
			//st = conn.createStatement();
			String SQL = "SELECT de"+diaSemana+", ate"+diaSemana+" FROM dig_horario_funcionamento " +
					"WHERE id_empresa = "+idEmpresa;
			ps = conn.prepareStatement(SQL);
	
			rs = ps.executeQuery();
			
			if(rs.next()){
				bean.setDe(rs.getTime(1).toString().substring(0, 5));
				bean.setAte(rs.getTime(2).toString().substring(0, 5));				
			}
			bean.setDiasSemana(data);			
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
		return bean;
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

	public List<ClienteBean> findClienteBy(String campoPesquisa) {

		List<ClienteBean> list = new ArrayList<ClienteBean>();
		ResultSet rs = null;
		//Statement st = null;
		PreparedStatement ps = null;
		try{
			//st = conn.createStatement();
			String SQL = "SELECT * FROM Dig_Usuario usu"+ 
						" WHERE nome LIKE '%"+campoPesquisa+"%' OR cpf LIKE '%"+campoPesquisa+"%'";
			
			ps = conn.prepareStatement(SQL);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				ClienteBean bean = new ClienteBean();
				bean.setIdUsuario(rs.getLong("id_Usuario"));
				bean.setNome(rs.getString("nome"));
				bean.setEndereco(rs.getString("endereco"));
				bean.setCidade(rs.getString("cidade"));
				bean.setEstado(rs.getString("estado"));
				bean.setTelefone(rs.getString("telefone"));
				bean.setEmail(rs.getString("email"));
				bean.setCpf(rs.getString("cpf"));
				bean.setIdPerfilSis(rs.getLong("id_Perfil_Sis"));
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
	public List<AgendaBean> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Método sobrecarregado para listar os agendamento do dia selecionado.
	 * @param dia
	 * @return Uma lista com todos os agendamentos AgendaBean.
	 */
	public List<AgendaBean> listar(String dia, Long idEmpresa) {
		List<AgendaBean> list = new ArrayList<AgendaBean>();

		ResultSet rs = null;
		ResultSet result = null;
		PreparedStatement ps = null;
		try{
			String SQL = "SELECT ag.id_Agenda, usu.nome, CONVERT(varchar(10), data_Servico,103) data_Servico, ag.deHorarioAgendamento, ag.ateHorarioAgendamento," +
					" ag.obs, ss.id_Status_Servico, ss.descricao, ss.sigla, vei.descricao as veiculo" +
					" FROM dig_agenda ag"+ 
					" INNER JOIN Dig_Usuario usu ON ag.id_Usuario = usu.id_Usuario"+
					" INNER JOIN Dig_Status_Servico ss ON ss.id_Status_Servico = ag.id_Status_Servico" +
					" INNER JOIN Dig_Veiculo vei ON vei.id_Veiculo = ag.id_Veiculo"+
					" WHERE CONVERT(varchar(10), data_Servico,103) = ?"+
					" AND ag.id_Empresa = ?" +
					" ORDER BY ag.deHorarioAgendamento";
					
			ps = conn.prepareStatement(SQL);

			ps.setString(1, dia);
			ps.setLong(2, idEmpresa);

			rs = ps.executeQuery();

			while(rs.next()){
				AgendaBean bean = new AgendaBean();
				
				bean.setIdAgenda(rs.getLong("id_Agenda"));
				bean.setNomeUsuario(rs.getString("nome").toUpperCase());
				bean.setDataServico(rs.getString("data_Servico"));
				bean.setDeHorarioAgendamento(rs.getTime("deHorarioAgendamento").toString());
				bean.setAteHorarioAgendamento(rs.getTime("ateHorarioAgendamento").toString());
				bean.setDescricaoStatusServico(rs.getString("descricao"));
				bean.setSiglaStatusServico(rs.getString("sigla"));
				bean.setObsAgendamento(rs.getString("obs"));
				bean.setDescricaoVeiculo(rs.getString("veiculo").toUpperCase());
				
				SQL = "SELECT serv.* FROM Dig_Servicos serv"+
						" INNER JOIN Dig_Agenda_Servicos ags ON serv.id_Servicos = ags.id_Servicos"+
						" WHERE ags.id_Agenda = ?";
				
				ps = conn.prepareStatement(SQL);

				ps.setLong(1, bean.getIdAgenda());

				result = ps.executeQuery();
				
				List<ServicosBean> listServicosBean = new ArrayList<ServicosBean>();
				String servicosAgendamento = "";
				
				while(result.next()){
					ServicosBean servicosBean = new ServicosBean();
					
					servicosBean.setIdServicos(result.getLong("id_Servicos"));
					servicosBean.setDescricao(result.getString("descricao"));
					servicosBean.setValor(ValorMonetarioHelper.formata("###,##0.00",(result.getDouble("valor"))));
					servicosBean.setTempoExecucao((result.getTime("tempo_Execucao")).toString());
					servicosBean.setIdEmpresa(result.getLong("id_Empresa"));
					servicosBean.setIdTipoVeiculo(result.getLong("id_Tipo_Veiculo"));
					servicosAgendamento += servicosBean.getDescricao()+"\n";
					
					listServicosBean.add(servicosBean);
				}
				
				bean.setListServicosBean(listServicosBean);
				//bean.setServicosAgendamento(servicosAgendamento.substring(0, servicosAgendamento.length()-1));
				bean.setServicosAgendamento(servicosAgendamento);
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
	public Boolean salvar(AgendaBean bean) {
		PreparedStatement ps = null;
		Long key = 0L;
		
		try {
			StatusServicoBean statusBean = getStatusServicoBy(bean.getSiglaStatusServico());
			bean.setIdStatusServico(statusBean.getIdStatusServico());
			
			Date date =  sdf.parse(bean.getDataServico());
			Timestamp timestamp = new Timestamp(date.getTime());
						
			conn.setAutoCommit(false);
			
			String SQL = "INSERT INTO Dig_Agenda (id_Cliente, id_Status_Servico, id_Usuario, id_Veiculo, data_Servico, deHorarioAgendamento, ateHorarioAgendamento, id_Empresa, obs)" +
			 		" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			 ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);	
			 
			 if(bean.getIdCliente() == null || bean.getIdCliente() == 0){
				 ps.setNull(1, java.sql.Types.BIGINT);
			 }else{
				 ps.setLong(1, bean.getIdCliente());				 
			 }			 
			 ps.setLong(2, bean.getIdStatusServico());
			 ps.setLong(3, bean.getIdUsuario());
			 ps.setLong(4, bean.getIdVeiculo());
			 ps.setTimestamp(5, timestamp);
			 ps.setString(6, bean.getDeHorarioAgendamento());
			 ps.setString(7, bean.getAteHorarioAgendamento());
			 ps.setLong(8, bean.getIdEmpresa());
			 ps.setString(9, bean.getObsAgendamento());
			 
			 ps.execute();
			 
			 ResultSet rs = ps.getGeneratedKeys();
			 
			 if (rs != null && rs.next()) {
				    key = rs.getLong(1);
				}	
			 
			 for(ServicosBean servicosBean : bean.getListServicosBean()){
				 
				 SQL = "INSERT INTO Dig_Agenda_Servicos VALUES (?, ?)";
				 
				 ps = conn.prepareStatement(SQL);
				 
				 ps.setLong(1, key);
				 ps.setLong(2, servicosBean.getIdServicos());
				 
				 ps.execute();
			 }
			 
			 conn.commit();
			
			 return true;
			 
		}catch(SQLException sql){
			sql.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();

		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			fecharConexao();
		}		
		return false;
	}	
	
	/**
	 * Obtém o objeto statusServicoBean a partir da sigla informada;
	 * @param siglaStatus
	 * @return StatusServicoBean
	 * @throws Exception
	 */
	private StatusServicoBean getStatusServicoBy(String siglaStatus)throws Exception{

		ResultSet rs = null;
		PreparedStatement ps = null;
		try{
			String SQL = "SELECT * FROM Dig_Status_Servico WHERE sigla = ?";
			ps = conn.prepareStatement(SQL);

			ps.setString(1, siglaStatus);

			rs = ps.executeQuery();

			if(rs.next()){
				StatusServicoBean bean = new StatusServicoBean();

				bean.setIdStatusServico(rs.getLong("id_Status_Servico"));
				bean.setDescricao(rs.getString("descricao"));
				bean.setSigla(rs.getString("sigla"));

				return bean;
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
		}
		return null;
	}

	public Boolean mudarStatusServico(AgendaBean bean, String statusServico) {
		PreparedStatement ps = null;
		try{		
			
			 ps = conn.prepareStatement("UPDATE Dig_Agenda set id_Status_Servico = (SELECT id_Status_Servico FROM Dig_Status_Servico WHERE sigla = ?)," +
			 		" obs_Concluir = ?" +
			 		" WHERE id_Agenda = ?");
			 
			 ps.setString(1, statusServico);
			 ps.setString(2, bean.getObsConcluirAgendamento());
			 ps.setLong(3, bean.getIdAgenda());
			 
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
	

}
