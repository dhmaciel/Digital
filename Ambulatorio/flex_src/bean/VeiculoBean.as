package bean
{

	[RemoteClass(alias="com.digital.bean.VeiculoBean")]
	public class VeiculoBean
	{
		
		private var _idVeiculo:Number;
		private var _descricao:String;
		private var _idTipoVeiculo:Number;
		private var _tipoVeiculoStr:String;
		private var _idUsuario:Number;
		
		public function VeiculoBean()
		{
		}

		
		public function get descricao():String
		{
			return _descricao;
		}

		public function set descricao(value:String):void
		{
			_descricao = value;
		}

		public function get idVeiculo():Number
		{
			return _idVeiculo;
		}

		public function set idVeiculo(value:Number):void
		{
			_idVeiculo = value;
		}

		public function get idTipoVeiculo():Number
		{
			return _idTipoVeiculo;
		}

		public function set idTipoVeiculo(value:Number):void
		{
			_idTipoVeiculo = value;
		}

		public function get tipoVeiculoStr():String
		{
			return _tipoVeiculoStr;
		}

		public function set tipoVeiculoStr(value:String):void
		{
			_tipoVeiculoStr = value;
		}

		public function get idUsuario():Number
		{
			return _idUsuario;
		}

		public function set idUsuario(value:Number):void
		{
			_idUsuario = value;
		}
		
		

		
	}
}