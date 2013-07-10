package bean
{

	[RemoteClass(alias="com.digital.bean.UsuarioBean")]
	public class UsuarioBean
	{
		
		private var _idUsuarioClienteSis:Number;
		private var _idUsuario:Number;
		private var _idPerfilSis:Number;
		private var _idCliente:Number;
		private var _usuario:String;
		private var _senha:String;
		private var _nomePerfil:String;
		private var _siglaPerfil:String;
		private var _nome:String;
		private var _email:String;
		private var _cpf:String;
		private var _idEmpresa:Number;
		private var _idCargo:Number;
		
	
		public function UsuarioBean()
		{
		}

		
		
		public function get idUsuarioClienteSis():Number
		{
			return _idUsuarioClienteSis;
		}

		public function set idUsuarioClienteSis(value:Number):void
		{
			_idUsuarioClienteSis = value;
		}

		public function get idUsuario():Number
		{
			return _idUsuario;
		}

		public function set idUsuario(value:Number):void
		{
			_idUsuario = value;
		}

		public function get idPerfilSis():Number
		{
			return _idPerfilSis;
		}

		public function set idPerfilSis(value:Number):void
		{
			_idPerfilSis = value;
		}

		public function get idCliente():Number
		{
			return _idCliente;
		}

		public function set idCliente(value:Number):void
		{
			_idCliente = value;
		}

		public function get usuario():String
		{
			return _usuario;
		}

		public function set usuario(value:String):void
		{
			_usuario = value;
		}

		public function get senha():String
		{
			return _senha;
		}

		public function set senha(value:String):void
		{
			_senha = value;
		}

		public function get nomePerfil():String
		{
			return _nomePerfil;
		}

		public function set nomePerfil(value:String):void
		{
			_nomePerfil = value;
		}

		public function get siglaPerfil():String
		{
			return _siglaPerfil;
		}

		public function set siglaPerfil(value:String):void
		{
			_siglaPerfil = value;
		}

		public function get nome():String
		{
			return _nome;
		}

		public function set nome(value:String):void
		{
			_nome = value;
		}

		public function get email():String
		{
			return _email;
		}

		public function set email(value:String):void
		{
			_email = value;
		}

		public function get cpf():String
		{
			return _cpf;
		}

		public function set cpf(value:String):void
		{
			_cpf = value;
		}

		public function get idEmpresa():Number
		{
			return _idEmpresa;
		}

		public function set idEmpresa(value:Number):void
		{
			_idEmpresa = value;
		}

		public function get idCargo():Number
		{
			return _idCargo;
		}

		public function set idCargo(value:Number):void
		{
			_idCargo = value;
		}


	}
}