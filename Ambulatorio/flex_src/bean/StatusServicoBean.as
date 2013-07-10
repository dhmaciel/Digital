package bean
{

	[RemoteClass(alias="com.digital.bean.StatusServicoBean")]
	public class StatusServicoBean
	{
		
		private var _idStatusServico:Number;
		private var _descricao:String;
		private var _sigla:String;
		
		public function StatusServicoBean()
		{
		}
		
		public function get idStatusServico():Number
		{
			return _idStatusServico;
		}

		public function set idStatusServico(value:Number):void
		{
			_idStatusServico = value;
		}

		public function get descricao():String
		{
			return _descricao;
		}

		public function set descricao(value:String):void
		{
			_descricao = value;
		}

		public function get sigla():String
		{
			return _sigla;
		}

		public function set sigla(value:String):void
		{
			_sigla = value;
		}


	}
}