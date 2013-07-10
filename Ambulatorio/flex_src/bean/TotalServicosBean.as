package bean
{

	[RemoteClass(alias="com.digital.bean.TotalServicosBean")]
	public class TotalServicosBean
	{
		
		private var _servicosSelecionados:Number;
		private var _tempoTotal:String;
		private var _valorTotal:String;
		
		public function TotalServicosBean()
		{
		}

		
		public function get servicosSelecionados():Number
		{
			return _servicosSelecionados;
		}

		public function set servicosSelecionados(value:Number):void
		{
			_servicosSelecionados = value;
		}

		public function get tempoTotal():String
		{
			return _tempoTotal;
		}

		public function set tempoTotal(value:String):void
		{
			_tempoTotal = value;
		}

		public function get valorTotal():String
		{
			return _valorTotal;
		}

		public function set valorTotal(value:String):void
		{
			_valorTotal = value;
		}


	}
}