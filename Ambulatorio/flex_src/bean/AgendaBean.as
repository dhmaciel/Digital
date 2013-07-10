package bean
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="com.digital.bean.AgendaBean")]
	public class AgendaBean
	{
		
		private var _idAgenda:Number;
		private var _idCliente:Number;
		private var _idServico:Number;
		private var _idStatusServico:Number;
		private var _idUsuario:Number;
		private var _nomeUsuario:String;
		private var _dataServico:String;
		private var _descricaoStatusServico:String;
		private var _siglaStatusServico:String;
		private var _servicosAgendamento:String;
		private var _obsAgendamento:String;
		private var _obsConcluirAgendamento:String;
		private var _obsCancelarServico:String;
		private var _idEmpresa:Number;
		private var _idVeiculo:Number;
		private var _descricaoVeiculo:String;
		private var _deHorarioServico:String;
		private var _ateHorarioServico:String;
		private var _deHorarioAgendamento:String;
		private var _ateHorarioAgendamento:String;
		private var _tempoTotalServico:String;
		private var _listServicosBean:ArrayCollection;
		
		public function AgendaBean()
		{
		}
		
		public function get idAgenda():Number
		{
			return _idAgenda;
		}

		public function set idAgenda(value:Number):void
		{
			_idAgenda = value;
		}

		public function get idCliente():Number
		{
			return _idCliente;
		}

		public function set idCliente(value:Number):void
		{
			_idCliente = value;
		}

		public function get idServico():Number
		{
			return _idServico;
		}

		public function set idServico(value:Number):void
		{
			_idServico = value;
		}

		public function get idStatusServico():Number
		{
			return _idStatusServico;
		}

		public function set idStatusServico(value:Number):void
		{
			_idStatusServico = value;
		}

		public function get idUsuario():Number
		{
			return _idUsuario;
		}

		public function set idUsuario(value:Number):void
		{
			_idUsuario = value;
		}

		public function get dataServico():String
		{
			return _dataServico;
		}

		public function set dataServico(value:String):void
		{
			_dataServico = value;
		}

		public function get descricaoStatusServico():String
		{
			return _descricaoStatusServico;
		}

		public function set descricaoStatusServico(value:String):void
		{
			_descricaoStatusServico = value;
		}

		public function get siglaStatusServico():String
		{
			return _siglaStatusServico;
		}

		public function set siglaStatusServico(value:String):void
		{
			_siglaStatusServico = value;
		}

		public function get obsAgendamento():String
		{
			return _obsAgendamento;
		}

		public function set obsAgendamento(value:String):void
		{
			_obsAgendamento = value;
		}

		public function get idEmpresa():Number
		{
			return _idEmpresa;
		}

		public function set idEmpresa(value:Number):void
		{
			_idEmpresa = value;
		}

		public function get listServicosBean():ArrayCollection
		{
			return _listServicosBean;
		}

		public function set listServicosBean(value:ArrayCollection):void
		{
			_listServicosBean = value;
		}

		public function get idVeiculo():Number
		{
			return _idVeiculo;
		}

		public function set idVeiculo(value:Number):void
		{
			_idVeiculo = value;
		}

		public function get deHorarioServico():String
		{
			return _deHorarioServico;
		}

		public function set deHorarioServico(value:String):void
		{
			_deHorarioServico = value;
		}

		public function get ateHorarioServico():String
		{
			return _ateHorarioServico;
		}

		public function set ateHorarioServico(value:String):void
		{
			_ateHorarioServico = value;
		}

		public function get deHorarioAgendamento():String
		{
			return _deHorarioAgendamento;
		}

		public function set deHorarioAgendamento(value:String):void
		{
			_deHorarioAgendamento = value;
		}

		public function get ateHorarioAgendamento():String
		{
			return _ateHorarioAgendamento;
		}

		public function set ateHorarioAgendamento(value:String):void
		{
			_ateHorarioAgendamento = value;
		}

		public function get nomeUsuario():String
		{
			return _nomeUsuario;
		}

		public function set nomeUsuario(value:String):void
		{
			_nomeUsuario = value;
		}

		public function get servicosAgendamento():String
		{
			return _servicosAgendamento;
		}

		public function set servicosAgendamento(value:String):void
		{
			_servicosAgendamento = value;
		}

		public function get tempoTotalServico():String
		{
			return _tempoTotalServico;
		}

		public function set tempoTotalServico(value:String):void
		{
			_tempoTotalServico = value;
		}

		public function get descricaoVeiculo():String
		{
			return _descricaoVeiculo;
		}

		public function set descricaoVeiculo(value:String):void
		{
			_descricaoVeiculo = value;
		}

		public function get obsConcluirAgendamento():String
		{
			return _obsConcluirAgendamento;
		}

		public function set obsConcluirAgendamento(value:String):void
		{
			_obsConcluirAgendamento = value;
		}

		public function get obsCancelarServico():String
		{
			return _obsCancelarServico;
		}

		public function set obsCancelarServico(value:String):void
		{
			_obsCancelarServico = value;
		}


	}
}