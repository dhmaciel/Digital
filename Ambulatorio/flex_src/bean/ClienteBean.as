package bean
{
	import mx.collections.ArrayCollection;

	/**
	 * Este bean representa a tabela Dig_Usuário do BD.
	 * @author Douglas
	 *
	 */
	[RemoteClass(alias="com.digital.bean.ClienteBean")]
	public class ClienteBean
	{
		
		private var _idUsuario:Number;
		private var _nome:String;
		private var _endereco:String;
		private var _estado:String;
		private var _cidade:String;
		private var _telefone:String;
		private var _email:String;
		private var _cpf:String;		
		private var _idPerfilSis:Number;
		private var _perfilStr:String;
		private var _idUsuarioClienteSis:Number;
		private var _usuarioStr:String;
		private var _senhaStr:String;
		private var _idVeiculo:Number;
		private var _veiculoStr:String;
		private var _listVeiculoBean:ArrayCollection = new ArrayCollection();
		
		public function ClienteBean()
		{
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

		
		public function get perfilStr():String
		{
			return _perfilStr;
		}

		public function set perfilStr(value:String):void
		{
			_perfilStr = value;
		}

		public function get idUsuario():Number
		{
			return _idUsuario;
		}

		public function set idUsuario(value:Number):void
		{
			_idUsuario = value;
		}

		public function get idVeiculo():Number
		{
			return _idVeiculo;
		}

		public function set idVeiculo(value:Number):void
		{
			_idVeiculo = value;
		}

		public function get veiculoStr():String
		{
			return _veiculoStr;
		}

		public function set veiculoStr(value:String):void
		{
			_veiculoStr = value;
		}

		public function get listVeiculoBean():ArrayCollection
		{
			return _listVeiculoBean;
		}

		public function set listVeiculoBean(value:ArrayCollection):void
		{
			_listVeiculoBean = value;
		}

		
	}
}