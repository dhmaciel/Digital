package bean
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="com.digital.bean.HorarioFuncionamentoBean")]
	public class HorarioFuncionamentoBean
	{
		public function HorarioFuncionamentoBean()
		{
		}
		
		private var _diasSemana:String;
		private var _de:String;
		private var _ate:String;	
		
		
		public function get diasSemana():String
		{
			return _diasSemana;
		}

		public function set diasSemana(value:String):void
		{
			_diasSemana = value;
		}

		public function get de():String
		{
			return _de;
		}

		public function set de(value:String):void
		{
			_de = value;
		}

		public function get ate():String
		{
			return _ate;
		}

		public function set ate(value:String):void
		{
			_ate = value;
		}

		
	}
}