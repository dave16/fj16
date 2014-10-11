package br.comdc.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.dc.argentum.Candle;
import br.com.dc.argentum.Negocio;
import br.com.dc.argentum.reader.CandlestickFactory;

public class TestaCandlestickFactory {

	public static void main(String [] args){
		Calendar hoje = Calendar.getInstance();
		
		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		Negocio negocio2 = new Negocio(45.0, 100, hoje);
		Negocio negocio3 = new Negocio(39.8, 100, hoje);
		Negocio negocio4 = new Negocio(42.3, 100, hoje);
		Negocio negocio5 = new Negocio(20.0, 100, hoje);
		
		List<Negocio> negocios = Arrays.asList(negocio1,negocio2,negocio3,negocio4,negocio5);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candle candle = fabrica.constroiCandleParaData(hoje, negocios);
		
		System.out.println("Abertura " + candle.getAbertura());
		System.out.println("Fechamento " + candle.getFechamento());
		System.out.println("Minimo " + candle.getMinimo());
		System.out.println("Maximo " + candle.getMaximo());
		System.out.println("Volume " + candle.getVolume());
		System.out.println("Data " + candle.toString());
	}
}
