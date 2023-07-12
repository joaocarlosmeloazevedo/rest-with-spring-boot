//package br.com.erudio.converters;
//
//public class NumberConverter {
//	public static Double convertToDouble(String strNumber) {
//		if (strNumber == null) return 0D;
//		String number = strNumber.replaceAll(",", "."); //Recebendo vírgula e retornando ponto
//		if (isNumeric(number)) return Double.parseDouble(number);
//		return 0D;
//	}
//
//	public static boolean isNumeric(String strNumber) {
//		if (strNumber == null) return false;
//		String number = strNumber.replaceAll(",", "."); //Recebendo vírgula e retornando ponto
//		return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //Verificando se o número é negativo ou positivo, inteiro ou quebrado e se vai de 0 a 9.
//	}
//}
