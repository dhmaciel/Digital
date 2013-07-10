package bean
{

	[RemoteClass(alias="com.digital.bean.PerfilSisBean")]
	public class PerfilSisBean
	{
		
		private var _idPerfilSis:Number;
		private var _nomePerfil:String;
		private var _sigla:String;
		
		public function PerfilSisBean()
		{
		}	

		
		public function get idPerfilSis():Number
		{
			return _idPerfilSis;
		}

		public function set idPerfilSis(value:Number):void
		{
			_idPerfilSis = value;
		}

		public function get nomePerfil():String
		{
			return _nomePerfil;
		}

		public function set nomePerfil(value:String):void
		{
			_nomePerfil = value;
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