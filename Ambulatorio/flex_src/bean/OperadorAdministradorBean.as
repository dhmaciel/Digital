package bean
{

	[RemoteClass(alias="com.digital.bean.OperadorAdministradorBean")]
	public class OperadorAdministradorBean
	{
		
		private var _idCliente:Number;
		private var _nome:String;
		private var _endereco:String;
		private var _estado:String;
		private var _cidade:String;
		private var _telefone:String;
		private var _email:String;
		private var _cpf:String;
		private var _idCargo:Number;
		private var _inicioAtividades:String;
		private var _terminoAtividades:String;
		private var _idEmpresa:Number;
		private var _idPerfilSis:Number;
		private var _perfilStr:String;
		private var _idUsuarioClienteSis:Number;
		private var _usuarioStr:String;
		private var _senhaStr:String;
		private var _cargoStr:String;
		
		public function OperadorAdministradorBean()
		{
		}

		public function get idCliente():Number
		{
			return _idCliente;
		}

		public function set idCliente(value:Number):void
		{
			_idCliente = value;
		}

		public function get nome():String
		{
			return _nome;
		}

		public function set nome(value:String):void
		{
			_nome = value;
		}

		public function get endereco():String
		{
			return _endereco;
		}

		public function set endereco(value:String):void
		{
			_endereco = value;
		}

		public function get estado():String
		{
			return _estado;
		}

		public function set estado(value:String):void
		{
			_estado = value;
		}

		public function get telefone():String
		{
			return _telefone;
		}

		public function set telefone(value:String):void
		{
			_telefone = value;
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

		public function get idCargo():Number
		{
			return _idCargo;
		}

		public function set idCargo(value:Number):void
		{
			_idCargo = value;
		}

		public function get inicioAtividades():String
		{
			return _inicioAtividades;
		}

		public function set inicioAtividades(value:String):void
		{
			_inicioAtividades = value;
		}

		public function get terminoAtividades():String
		{
			return _terminoAtividades;
		}

		public function set terminoAtividades(value:String):void
		{
			_terminoAtividades = value;
		}

		public function get idEmpresa():Number
		{
			return _idEmpresa;
		}

		public function set idEmpresa(value:Number):void
		{
			_idEmpresa = value;
		}

		public function get idPerfilSis():Number
		{
			return _idPerfilSis;
		}

		public function set idPerfilSis(value:Number):void
		{
			_idPerfilSis = value;
		}

		public function get cidade():String
		{
			return _cidade;
		}

		public function set cidade(value:String):void
		{
			_cidade = value;
		}

		public function get usuarioStr():String
		{
			return _usuarioStr;
		}

		public function set usuarioStr(value:String):void
		{
			_usuarioStr = value;
		}

		public function get senhaStr():String
		{
			return _senhaStr;
		}

		public function set senhaStr(value:String):void
		{
			_senhaStr = value;
		}

		public function get idUsuarioClienteSis():Number
		{
			return _idUsuarioClienteSis;
		}

		public function set idUsuarioClienteSis(value:Number):void
		{
			_idUsuarioClienteSis = value;
		}

		public function get cargoStr():String
		{
			return _cargoStr;
		}

		public function set cargoStr(value:String):void
		{
			_cargoStr = value;
		}

		public function get perfilStr():String
		{
			return _perfilStr;
		}

		public function set perfilStr(value:String):void
		{
			_perfilStr = value;
		}

		
	}
}