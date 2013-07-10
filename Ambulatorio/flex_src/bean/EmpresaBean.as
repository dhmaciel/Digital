package bean
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="com.digital.bean.EmpresaBean")]
	public class EmpresaBean
	{
		public function EmpresaBean()
		{
		}
		
		private var _idEmpresa:Number;
		private var _razaoSocial:String;
		private var _cnpj:String;
		private var _telefone:String;
		private var _eMail:String;
		private var _endereco:String;
		private var _cidade:String;
		private var _estado:String;
		//private var _funcionamentoBeans:ArrayCollection;
		private var _horarioDeSegSexta:String;
		private var _horarioAteSegSexta:String;
		private var _horarioDeSabado:String;
		private var _horarioAteSabado:String;
		private var _horarioDeDomingo:String;
		private var _horarioAteDomingo:String;
		private var _empresaStr:String;

		

		public function get idEmpresa():Number
		{
			return _idEmpresa;
		}

		public function set idEmpresa(value:Number):void
		{
			_idEmpresa = value;
		}

		public function get razaoSocial():String
		{
			return _razaoSocial;
		}

		public function set razaoSocial(value:String):void
		{
			_razaoSocial = value;
		}

		public function get cnpj():String
		{
			return _cnpj;
		}

		public function set cnpj(value:String):void
		{
			_cnpj = value;
		}

		public function get telefone():String
		{
			return _telefone;
		}

		public function set telefone(value:String):void
		{
			_telefone = value;
		}

		public function get eMail():String
		{
			return _eMail;
		}

		public function set eMail(value:String):void
		{
			_eMail = value;
		}

		public function get endereco():String
		{
			return _endereco;
		}

		public function set endereco(value:String):void
		{
			_endereco = value;
		}

		public function get cidade():String
		{
			return _cidade;
		}

		public function set cidade(value:String):void
		{
			_cidade = value;
		}

		public function get estado():String
		{
			return _estado;
		}

		public function set estado(value:String):void
		{
			_estado = value;
		}

		public function get horarioDeSegSexta():String
		{
			return _horarioDeSegSexta;
		}

		public function set horarioDeSegSexta(value:String):void
		{
			_horarioDeSegSexta = value;
		}

		public function get horarioAteSegSexta():String
		{
			return _horarioAteSegSexta;
		}

		public function set horarioAteSegSexta(value:String):void
		{
			_horarioAteSegSexta = value;
		}

		public function get horarioDeSabado():String
		{
			return _horarioDeSabado;
		}

		public function set horarioDeSabado(value:String):void
		{
			_horarioDeSabado = value;
		}

		public function get horarioAteSabado():String
		{
			return _horarioAteSabado;
		}

		public function set horarioAteSabado(value:String):void
		{
			_horarioAteSabado = value;
		}

		public function get horarioDeDomingo():String
		{
			return _horarioDeDomingo;
		}

		public function set horarioDeDomingo(value:String):void
		{
			_horarioDeDomingo = value;
		}

		public function get horarioAteDomingo():String
		{
			return _horarioAteDomingo;
		}

		public function set horarioAteDomingo(value:String):void
		{
			_horarioAteDomingo = value;
		}

		public function get empresaStr():String
		{
			return _empresaStr;
		}

		public function set empresaStr(value:String):void
		{
			_empresaStr = value;
		}


		/*public function get funcionamentoBeans():ArrayCollection
		{
			return _funcionamentoBeans;
		}

		public function set funcionamentoBeans(value:ArrayCollection):void
		{
			_funcionamentoBeans = value;
		}*/


	}
}