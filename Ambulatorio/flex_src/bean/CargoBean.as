package bean
{

	[RemoteClass(alias="com.digital.bean.CargoBean")]
	public class CargoBean
	{
		
		private var _idCargo:Number;
		private var _descricao:String;
		private var _idEmpresa:Number;
		
		public function CargoBean()
		{
		}

		public function get idCargo():Number
		{
			return _idCargo;
		}

		public function set idCargo(value:Number):void
		{
			_idCargo = value;
		}

		public function get descricao():String
		{
			return _descricao;
		}

		public function set descricao(value:String):void
		{
			_descricao = value;
		}

		public function get idEmpresa():Number
		{
			return _idEmpresa;
		}

		public function set idEmpresa(value:Number):void
		{
			_idEmpresa = value;
		}
		

		
	}
}