package util
{
	import mx.controls.Alert;

	public class AlertaUtil
	{
		
		public function AlertaUtil(){
		
		}
		public static function exibirAlerta(messagem:String, tipo:String):void
		{
			Alert.show(messagem,tipo);
				
		}
		
		public static function exibirAlertaOperacaoOk():void{
			Alert.show('Operacao realizada com sucesso!', 'Sucesso');
		}
		
		public static function exibirAlertaOperacaoErro():void{
			Alert.show('Ocorreu um erro ao realizar a operação!', 'Erro');
		}
	}
}