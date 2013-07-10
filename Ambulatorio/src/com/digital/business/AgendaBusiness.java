package com.digital.business;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.ReadableInterval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.digital.bean.AgendaBean;
import com.digital.bean.ClienteBean;
import com.digital.bean.HorarioFuncionamentoBean;
import com.digital.bean.ServicosBean;
import com.digital.bean.TotalServicosBean;
import com.digital.bean.VeiculoBean;
import com.digital.dao.AgendaDAO;
import com.digital.dao.ServicosDAO;
import com.digital.dao.VeiculoDAO;
import com.digital.util.ValorMonetarioHelper;

public class AgendaBusiness {
	/**
	 * Data estilo dd/MM/yyyy
	 */
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * Horas estilo HH:mm:ss
	 */
	SimpleDateFormat smp = new SimpleDateFormat("HH:mm:ss"); 	
	/**
	 * Horas no estilo HH:mm
	 */
	SimpleDateFormat sdc = new SimpleDateFormat("HH:mm");  

	public HorarioFuncionamentoBean findDiaAtual(Long idEmpresa) {
		
		Date diaAtual = new Date();
		String diaSemana = "";
		AgendaDAO dao = new AgendaDAO();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(diaAtual); 
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		if(day == 1){
			
			diaSemana = "Domingo";
			
		}else if(day == 7){
			
			diaSemana = "Sabado";
			
		}else{
			
			diaSemana = "SegSexta";
		}
		
		return dao.buscarHorarioFuncionamento(sdf.format(diaAtual), diaSemana, idEmpresa);
	}
	
	public HorarioFuncionamentoBean findDiaSelecionado (Long idEmpresa, String dataSelecionada){
		
		Date diaSelecionado = null;
		try {
			diaSelecionado = sdf.parse(dataSelecionada);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String diaSemana = "";
		AgendaDAO dao = new AgendaDAO();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(diaSelecionado); 
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		if(day == 1){
			
			diaSemana = "Domingo";
			
		}else if(day == 7){
			
			diaSemana = "Sabado";
			
		}else{
			
			diaSemana = "SegSexta";
		}
		
		return dao.buscarHorarioFuncionamento(sdf.format(diaSelecionado), diaSemana, idEmpresa);
	}

	public List<ClienteBean> findClienteBy(String campoPesquisa) {
		
		AgendaDAO dao = new AgendaDAO();	
		
		return dao.findClienteBy(campoPesquisa);
	}

	public List<VeiculoBean> findAllVeiculosCliente(ClienteBean bean) {
		
		VeiculoDAO dao = new VeiculoDAO();
		
		List<VeiculoBean> list =  dao.listar(bean.getIdUsuario());
		
		dao.fecharConexao();
		
		return list;
	}

	public List<ServicosBean> findAllServicosBy(VeiculoBean bean,
			String idEmpresa) {
		
		ServicosDAO dao = new ServicosDAO();
		
		return dao.findAllServicosBy(bean, idEmpresa);	
		 
	}
	
	/**
	 * Calcula o total de serviços, horas e valor selecionados.
	 * @param listBean
	 * @return o valor total de serviços, horas e valor selecionados.
	 */
	public TotalServicosBean calcularTotalServicos(List<ServicosBean> listBean) {
		TotalServicosBean totalServicosBean = new TotalServicosBean();

		try{

			Calendar calendarInicial = Calendar.getInstance();	

			int totalServicos = 0;
			//String horasInicial = listBean.get(0).getTempoExecucao();
			Double valorAux = 0D;
			Boolean isHorasInicial = true;
			
			//Date dateInicial =  smp.parse(horasInicial);	
			//calendarInicial.setTime(dateInicial);

			for(ServicosBean bean : listBean){
				if(bean.getIsSelected() == false){
					continue;
				}
				
				valorAux += Double.valueOf(bean.getValor().replace(".", "").replace(",", "."));

				totalServicos ++;		
				
				if(isHorasInicial){
					String horasInicial = bean.getTempoExecucao();
					Date dateInicial =  smp.parse(horasInicial);
					calendarInicial.setTime(dateInicial);
					
					isHorasInicial = false;
					continue;
				}
				

				Calendar calendarAtual = Calendar.getInstance();
				Date dateAtual = smp.parse(bean.getTempoExecucao());
				calendarAtual.setTime(dateAtual);

				calendarInicial.add(Calendar.HOUR_OF_DAY, calendarAtual.get(Calendar.HOUR_OF_DAY));
				calendarInicial.add(Calendar.MINUTE, calendarAtual.get(Calendar.MINUTE));
				calendarInicial.add(Calendar.SECOND, calendarAtual.get(Calendar.SECOND));			

			}
			
			totalServicosBean.setServicosSelecionados(totalServicos);
			totalServicosBean.setTempoTotal(smp.format(calendarInicial.getTime()));
			totalServicosBean.setValorTotal(ValorMonetarioHelper.formata("###,##0.00",(valorAux)));
			
		}catch(ParseException parse){
			parse.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}

		return totalServicosBean;
	}
	
	/**
	 * Busca todos os agendamentos do dia e da empresa que foi logada.
	 * @param diaSelecionado
	 * @param idEmpresa
	 * @return List AgendaBean
	 */
	public List<AgendaBean> findAllAgendamentosBy(String diaSelecionado, Long idEmpresa) {
		
		AgendaDAO dao = new AgendaDAO();
		
		return dao.listar(diaSelecionado, idEmpresa);
		
	}
	/**
	 * Verifica se o horário informado para o atendimento está entre o horário de funcionamento do dia.
	 * @param deHorarioFuncionamento
	 * @param ateHorarioFuncionamento
	 * @param horarioSelecionado
	 * @param servicosBean
	 * @return true se está entre o horário e false fora do intervalo.
	 */
	public Boolean verificarHorarioSelecionado(String deHorarioFuncionamento,
			String ateHorarioFuncionamento, String horarioSelecionado, TotalServicosBean servicosBean) {
		
		try{
			
			Calendar calendarVerFinal = getHorarioFinalServico(horarioSelecionado,servicosBean.getTempoTotal());
			//Calendar calendarTempoTotal = Calendar.getInstance();
			
			Date dateVerInicial = sdc.parse(horarioSelecionado);
			
			//Date dateTempoTotal = sdc.parse(servicosBean.getTempoTotal());
			//calendarTempoTotal.setTime(dateTempoTotal);
			
			Date dateVerFinal = calendarVerFinal.getTime();			
										
			Date deFuncionamento = sdc.parse(deHorarioFuncionamento);
			Date ateFuncionamento = sdc.parse(ateHorarioFuncionamento);
			
			Calendar calendarDeFuncionamento = Calendar.getInstance();
			Calendar calendarAteFuncionamento = Calendar.getInstance();
			
			calendarDeFuncionamento.setTime(deFuncionamento);
			calendarDeFuncionamento.add(Calendar.MINUTE, -1);
			
			calendarAteFuncionamento.setTime(ateFuncionamento);
			calendarAteFuncionamento.add(Calendar.MINUTE, +1);
			
			deFuncionamento = calendarDeFuncionamento.getTime();
			ateFuncionamento = calendarAteFuncionamento.getTime();
			
			if((dateVerInicial.after(deFuncionamento) && dateVerInicial.before(ateFuncionamento)) && dateVerFinal.before(ateFuncionamento) ){
				return true;
				
			}		
			
			return false;
			
		}catch(Exception e){
			e.printStackTrace();			
			return null;
		}		
		
	}
	/**
	 * Verifica se não existe agendamento no horário informado.
	 * @param list
	 * @param servicosBean
	 * @param horarioSelecionado
	 * @return false se existe agendamento e true se não existe.
	 */
	public Boolean verificarDisposicaoHorario(List<AgendaBean> list,
			TotalServicosBean servicosBean, String horarioSelecionado) {		
		
		try{
			
			Calendar calendarVerInicial = Calendar.getInstance();
			Calendar calendarVerFinal = getHorarioFinalServico(horarioSelecionado,servicosBean.getTempoTotal());
			
			Date dateVerInicial = sdc.parse(horarioSelecionado);
			calendarVerInicial.setTime(dateVerInicial);

			String horaInicialSelecionadaStr = smp.format(calendarVerInicial.getTime());
			String horaFinalSelecionadaStr = smp.format(calendarVerFinal.getTime());
			
			DateTimeFormatter formatador = DateTimeFormat.forPattern("HH:mm:ss");
			
			DateTime horaInicialSelecionada = formatador.parseDateTime(horaInicialSelecionadaStr);
			DateTime horaFinalSelecionada = formatador.parseDateTime(horaFinalSelecionadaStr);
			
			for(AgendaBean agendaBean : list){
				
				DateTime horaInicialVerificar = formatador.parseDateTime(agendaBean.getDeHorarioAgendamento());
				DateTime horaFinalVerificar = formatador.parseDateTime(agendaBean.getAteHorarioAgendamento());
				
				Interval interval = new Interval(horaInicialSelecionada, horaFinalSelecionada);
				Interval interval2 = new Interval(horaInicialVerificar, horaFinalVerificar);

				ReadableInterval readableInterval = interval2;
				
				if(interval.overlaps(readableInterval)){
					return false;
				}
				
			}	
			
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Obtém o horário final a partir de um horário informado e o tempo total.
	 * @param horarioSelecionado
	 * @param tempoTotal
	 * @return
	 * @throws Exception
	 */
	public Calendar getHorarioFinalServico(String horarioSelecionado, String tempoTotal)throws Exception{
		
		Calendar calendarVerFinal = Calendar.getInstance();
		Calendar calendarTempoTotal = Calendar.getInstance();
		
		Date dateTempoTotal = sdc.parse(tempoTotal);
		calendarTempoTotal.setTime(dateTempoTotal);
		
		Date dateVerFinal = sdc.parse(horarioSelecionado);			
		calendarVerFinal.setTime(dateVerFinal);
		
		calendarVerFinal.add(Calendar.HOUR_OF_DAY, calendarTempoTotal.get(Calendar.HOUR_OF_DAY));
		calendarVerFinal.add(Calendar.MINUTE, calendarTempoTotal.get(Calendar.MINUTE));
		
		return calendarVerFinal;
	}

	public Boolean salvarAgendamento(AgendaBean bean) {
		
		AgendaDAO dao = new AgendaDAO();
		
		try {
			Calendar calendarVerFinal = getHorarioFinalServico(bean.getDeHorarioAgendamento(),bean.getTempoTotalServico());
			Date horarioFinalServico = calendarVerFinal.getTime();
			
			bean.setAteHorarioAgendamento(sdc.format(horarioFinalServico));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao.salvar(bean);		
	}
	
	public static void main (String [] args){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String atual = "17/05/2013";
		
		try {
			Date date =  sdf.parse(atual);

			Timestamp timestamp = new Timestamp(date.getTime());
			
			System.out.println(timestamp);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boolean changeStatusServico(AgendaBean bean, String statusServico) {
		
		AgendaDAO dao = new AgendaDAO();
		
		return dao.mudarStatusServico(bean, statusServico);
		
	}
	

}
