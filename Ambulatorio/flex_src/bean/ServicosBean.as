package bean
{

	[RemoteClass(alias="com.digital.bean.ServicosBean")]
	public class ServicosBean
	{
		
		private var _idServicos:Number;
		private var _descricao:String;
		private var _valor:String;
		private var _tempoExecucao:String;
		private var _idEmpresa:Number;
		private var _idTipoVeiculo:Number;
		private var _descricaoTipoVeiculo:String;
		private var _isSelected:Boolean;
		
		public function ServicosBean()
		{
		}
		
		public function get idServicos():Number
		{
			return _idServicos;
		}

		public function set idServicos(value:Number):void
		{
			_idServicos = value;
		}

		public function get descricao():String
		{
			return _descricao;
		}

		public function set descricao(value:String):void
		{
			_descricao = value;
		}

		public function get valor():String
		{
			return _valor;
		}

		public function set valor(value:String):void
		{
			_valor = value;
		}

		public function get tempoExecucao():String
		{
			return _tempoExecucao;
		}

		public function set tempoExecucao(value:String):void
		{
			_tempoExecucao = value;
		}

		public function get idEmpresa():Number
		{
			return _idEmpresa;
		}

		public function set idEmpresa(value:Number):void
		{
			_idEmpresa = value;
		}

		public function get idTipoVeiculo():Number
		{
			return _idTipoVeiculo;
		}

		public function set idTipoVeiculo(value:Number):void
		{
			_idTipoVeiculo = value;
		}

		public function get descricaoTipoVeiculo():String
		{
			return _descricaoTipoVeiculo;
		}

		public function set descricaoTipoVeiculo(value:String):void
		{
			_descricaoTipoVeiculo = value;
		}

		public function get isSelected():Boolean
		{
			return _isSelected;
		}

		public function set isSelected(value:Boolean):void
		{
			_isSelected = value;
		}


	}
}