package bean
{

	[RemoteClass(alias="com.digital.bean.TipoVeiculoBean")]
	public class TipoVeiculoBean
	{
		
		private var _idTipoVeiculo:Number;
		private var _descricao:String;
		
		public function TipoVeiculoBean()
		{
		}

		public function get idTipoVeiculo():Number
		{
			return _idTipoVeiculo;
		}

		public function set idTipoVeiculo(value:Number):void
		{
			_idTipoVeiculo = value;
		}

		public function get descricao():String
		{
			return _descricao;
		}

		public function set descricao(value:String):void
		{
			_descricao = value;
		}
		

		
	}
}