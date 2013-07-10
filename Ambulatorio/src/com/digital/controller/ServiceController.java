package com.digital.controller;

import java.util.List;

import com.digital.bean.AgendaBean;
import com.digital.bean.CargoBean;
import com.digital.bean.ClienteBean;
import com.digital.bean.EmpresaBean;
import com.digital.bean.HorarioFuncionamentoBean;
import com.digital.bean.LoginBean;
import com.digital.bean.OperadorAdministradorBean;
import com.digital.bean.PerfilSisBean;
import com.digital.bean.ServicosBean;
import com.digital.bean.TipoVeiculoBean;
import com.digital.bean.TotalServicosBean;
import com.digital.bean.UsuarioBean;
import com.digital.bean.VeiculoBean;
import com.digital.business.AgendaBusiness;
import com.digital.business.CargoBusiness;
import com.digital.business.ClienteBusiness;
import com.digital.business.EmpresaBusiness;
import com.digital.business.LoginBusiness;
import com.digital.business.OperadorAdministradorBusiness;
import com.digital.business.ServicosBusiness;


public class ServiceController {
	
	/**
	 * Salva ou realiza update de uma empresa 
	 * @param bean
	 * @return
	 */
	public Boolean salvarAtualizarEmpresa(EmpresaBean bean) {
		EmpresaBusiness business = new EmpresaBusiness();
		return business.salvarAtualizarEmpresa(bean);		
	}
	
	public List<EmpresaBean> listarEmpresasCadastradas(){
		EmpresaBusiness business = new EmpresaBusiness();
		return business.listarEmpresasCadastradas();
	}
	
	public List<TipoVeiculoBean> findTipoVeiculo(){
		ServicosBusiness business = new ServicosBusiness();
		return business.findTipoVeiculo();
	}
	
	public Boolean salvarServico(ServicosBean bean){
		ServicosBusiness business = new ServicosBusiness();
		return business.salvarServico(bean);
	}
	
	public List<ServicosBean> findAllServicos(Long idEmpresa){
		ServicosBusiness business = new ServicosBusiness();
		return business.findAllServicos(idEmpresa);
	}
	
	public Boolean removerServico(ServicosBean bean){
		ServicosBusiness business = new ServicosBusiness();
		return business.removerServico(bean);
	}

	public List<CargoBean> findAllCargos(Long idEmpresa){
		CargoBusiness business = new CargoBusiness();
		return business.findAllCargos(idEmpresa);
	}
	
	public Boolean removerCargo(CargoBean bean){
		CargoBusiness business = new CargoBusiness();
		return business.removerCargo(bean);
	}
	
	public Boolean salvarCargo(CargoBean bean){
		CargoBusiness business = new CargoBusiness();
		return business.salvarCargo(bean);
	}
	
	public List<PerfilSisBean> findAllTipoUsuario (){
		OperadorAdministradorBusiness business = new OperadorAdministradorBusiness();
		return business.findAllTipoUsuario();
	}
	
	public List<OperadorAdministradorBean> findAllOperadorAdministrador (Long idEmpresa){
		OperadorAdministradorBusiness business = new OperadorAdministradorBusiness();
		return business.findAllOperadorAdministrador(idEmpresa);
	}
	
	public Boolean salvarOperadorAdministrador(OperadorAdministradorBean bean){
		OperadorAdministradorBusiness business = new OperadorAdministradorBusiness();
		return business.salvarOperadorAdministrador(bean);
	}
	
	public Boolean removerOperadorAdministrador (OperadorAdministradorBean bean){
		OperadorAdministradorBusiness business = new OperadorAdministradorBusiness();
		return business.removerOperadorAdministrador(bean);
	}
	
	public List<ClienteBean> findAllCliente(){
		ClienteBusiness business = new ClienteBusiness();
		return business.findAllCliente();
	}
	
	public PerfilSisBean findPerfilCliente(){
		ClienteBusiness business = new ClienteBusiness();
		return business.findPerfilCliente();
	}
	
	public Boolean salvarCliente(ClienteBean bean){
		ClienteBusiness business = new ClienteBusiness();
		return business.salvarCliente(bean);
	}
	
	public Boolean removerCliente(ClienteBean bean){
		ClienteBusiness business = new ClienteBusiness();
		return business.removerCliente(bean);
	}
	
	public HorarioFuncionamentoBean findDiaAtual (Long idEmpresa){
		AgendaBusiness business = new AgendaBusiness();
		return business.findDiaAtual(idEmpresa);
	}
	
	public HorarioFuncionamentoBean findDiaSelecionado (Long idEmpresa, String dataSelecionada){
		AgendaBusiness business = new AgendaBusiness();
		return business.findDiaSelecionado(idEmpresa, dataSelecionada);
	}
	
	public List<ClienteBean> findClienteBy (String campoPesquisa){
		AgendaBusiness business = new AgendaBusiness();
		return business.findClienteBy(campoPesquisa);
	}
	
	public List<VeiculoBean> findAllVeiculosCliente (ClienteBean bean){
		AgendaBusiness business = new AgendaBusiness();
		return business.findAllVeiculosCliente(bean);
	}
	
	public List<ServicosBean> findAllServicosBy (VeiculoBean bean, String idEmpresa){
		AgendaBusiness business = new AgendaBusiness();
		return business.findAllServicosBy(bean, idEmpresa);
	}
	
	public TotalServicosBean calcularTotalServicos (List<ServicosBean> bean){
		AgendaBusiness business = new AgendaBusiness();
		return business.calcularTotalServicos(bean);
	}
	
	public List<AgendaBean> findAllAgendamentosBy (String diaSelecionado, Long idEmpresa){
		AgendaBusiness business = new AgendaBusiness();
		return business.findAllAgendamentosBy(diaSelecionado, idEmpresa);
	}
	
	public Boolean verificarHorarioSelecionado (String deHorarioFuncionamento, String ateHorarioFuncionamento, 
			String horarioSelecionado, TotalServicosBean servicosBean){
		AgendaBusiness business = new AgendaBusiness();
		return business.verificarHorarioSelecionado(deHorarioFuncionamento, ateHorarioFuncionamento, horarioSelecionado, servicosBean);
	}
	
	public Boolean verificarDisposicaoHorario (List<AgendaBean> list, TotalServicosBean servicosBean,
			String horarioSelecionado){
		AgendaBusiness business = new AgendaBusiness();
		return business.verificarDisposicaoHorario(list, servicosBean, horarioSelecionado);
	}
	
	public Boolean salvarAgendamento (AgendaBean bean){
		AgendaBusiness business = new AgendaBusiness();
		return business.salvarAgendamento(bean);
	}
	
	public Boolean changeStatusServico (AgendaBean bean, String statusServico){
		AgendaBusiness business = new AgendaBusiness();
		return business.changeStatusServico(bean, statusServico);
	}
	
	public UsuarioBean loginUser (LoginBean bean){
		LoginBusiness business = new LoginBusiness();
		return business.loginUser(bean);
	}
}

