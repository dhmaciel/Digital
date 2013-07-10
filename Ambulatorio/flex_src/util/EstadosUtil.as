package util
{
	import mx.collections.ArrayCollection;

	public class EstadosUtil
	{
		public function EstadosUtil()
		{			
		}
		
		public static function obterListaEstados():ArrayCollection{
			 var estados:ArrayCollection = new ArrayCollection([
				{estado: "AC"},
				{estado: "AL"},
				{estado: "AP"}, 
				{estado: "AM"}, 
				{estado: "BA"}, 
				{estado: "CE"}, 
				{estado: "DF"}, 
				{estado: "ES"}, 
				{estado: "GO"}, 
				{estado: "MA"}, 
				{estado: "MT"}, 
				{estado: "MS"}, 
				{estado: "MG"}, 
				{estado: "PA"}, 
				{estado: "PB"}, 
				{estado: "PR"}, 
				{estado: "PE"}, 
				{estado: "PI"}, 
				{estado: "RJ"}, 
				{estado: "RN"}, 
				{estado: "RS"}, 
				{estado: "RO"}, 
				{estado: "RR"}, 
				{estado: "SC"}, 
				{estado: "SP"}, 
				{estado: "SE"}, 
				{estado: "TO"}]);		
			 
			 return estados;
		}
	}
}