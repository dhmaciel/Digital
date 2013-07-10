package util
{
	import flash.net.URLRequest;
	import flash.net.navigateToURL;
	
	import mx.controls.Alert;
	import mx.core.UIComponent;
	import mx.managers.PopUpManager;
	import mx.rpc.events.FaultEvent;
	import mx.utils.StringUtil;
	
	public class ProgressBarHelper
	{
		private static var enabledProgressBar:Boolean = false;
		public function ProgressBarHelper()
		{
		}
		
		private static var progressBar:ProgressBar = new ProgressBar();
		public static function openProgressBar(uIComponent:UIComponent):void{
			if(!enabledProgressBar) {
				PopUpManager.addPopUp(progressBar,uIComponent, true);
				
				var diferencaLargura:Number = progressBar.screen.width - progressBar.width;
        		var diferencaAltura:Number = progressBar.screen.height - progressBar.height;
        		progressBar.x = progressBar.screen.x + (diferencaLargura / 2);
        		progressBar.y = progressBar.screen.y + (diferencaAltura / 2);
        		progressBar.initializer();
        		
        		enabledProgressBar = true;
   			}
		}
	
		public static function removeProgressBar():void{
			if(enabledProgressBar) {
				PopUpManager.removePopUp(progressBar);
				enabledProgressBar = false;
			}
		}
		
		public static function erro(event:FaultEvent, urlLogin:String):void{
			
			var error:String = event.fault.faultString;
			var errorArray:Array = error.split(":");
			if(StringUtil.trim(errorArray[1]) == "false"){
				var url:URLRequest = new URLRequest(urlLogin);
				url.method = "GET";
				navigateToURL(url,"_self");
			}
		}
		
//		/**
//		 * Método que exibe uma mensagem de Erro
//		 */
//		public static function showErrorMessage(event:FaultEvent):void {
//			MessagesHelper.showErrorMessage(event)			
//		}
	}
}