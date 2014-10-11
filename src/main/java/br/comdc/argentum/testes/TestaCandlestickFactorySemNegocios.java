package br.comdc.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.dc.argentum.Candle;
import br.com.dc.argentum.Negocio;
import br.com.dc.argentum.reader.CandlestickFactory;


public class TestaCandlestickFactorySemNegocios {

	public static void main(String[] args) {

		Calendar hoje = Calendar.getInstance();

		List<Negocio> negocios = Arrays.asList();

		CandlestickFactory fabrica = new CandlestickFactory();
		Candle candle = fabrica.constroiCandleParaData(hoje, negocios);

		System.out.println("Abertura " + candle.getAbertura());
		System.out.println("Fechamento " + candle.getFechamento());
		System.out.println("Minimo " + candle.getMinimo());
		System.out.println("Maximo " + candle.getMaximo());
		System.out.println("Volume " + candle.getVolume());
	}
}
