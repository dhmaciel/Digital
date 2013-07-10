package com.digital.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ValorMonetarioHelper {
	public static  String formata(String formato, double valor) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols (new Locale ("pt", "BR"));  
        return new DecimalFormat(formato, dfs).format(valor);
           
	}
}
