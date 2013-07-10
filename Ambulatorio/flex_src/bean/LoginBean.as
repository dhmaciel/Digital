package bean
{

	[RemoteClass(alias="com.digital.bean.LoginBean")]
	public class LoginBean
	{
		
		private var _login:String;
		private var _senha:String;
		private var _isClienteSelected:Boolean;
		
		public function LoginBean()
		{
		}		

		
		public function get login():String
		{
			return _login;
		}

		public function set login(value:String):void
		{
			_login = value;
		}

		public function get senha():String
		{
			return _senha;
		}

		public function set senha(value:String):void
		{
			_senha = value;
		}

		public function get isClienteSelected():Boolean
		{
			return _isClienteSelected;
		}

		public function set isClienteSelected(value:Boolean):void
		{
			_isClienteSelected = value;
		}


	}
}