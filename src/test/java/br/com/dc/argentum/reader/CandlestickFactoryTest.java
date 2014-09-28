package br.com.dc.argentum.reader;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import br.com.dc.argentum.Candlestick;
import br.com.dc.argentum.Negocio;

public class CandlestickFactoryTest {

	@Test
	public void paraNegociosDeTresDiasDistintosGeraTresCandles() {
		Calendar hoje = Calendar.getInstance();

		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		Negocio negocio2 = new Negocio(45.0, 100, hoje);
		Negocio negocio3 = new Negocio(39.8, 100, hoje);
		Negocio negocio4 = new Negocio(42.3, 100, hoje);

		Calendar amanha = (Calendar) hoje.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Negocio negocio5 = new Negocio(48.8, 100, amanha);
		Negocio negocio6 = new Negocio(49.3, 100, amanha);

		Calendar depois = (Calendar) amanha.clone();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		Negocio negocio7 = new Negocio(51.8, 100, depois);
		Negocio negocio8 = new Negocio(52.3, 100, depois);

		List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3,
				negocio4, negocio5, negocio6, negocio7, negocio8);

		CandlestickFactory fabrica = new CandlestickFactory();

		List<Candlestick> candles = fabrica.constroiCandles(negocios);

		Assert.assertEquals(3, candles.size());
		Assert.assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);
		Assert.assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
		Assert.assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
		Assert.assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);
		Assert.assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);
	}

	@Test
	public void sequenciaSimplesDeNegocios() {

		Calendar hoje = Calendar.getInstance();

		Negocio negocio1 = new Negocio(40.5, 100, hoje);
		Negocio negocio2 = new Negocio(45.0, 100, hoje);
		Negocio negocio3 = new Negocio(39.8, 100, hoje);
		Negocio negocio4 = new Negocio(42.3, 100, hoje);

		List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3,
				negocio4);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);

		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(42.3, candle.getFechamento(), 0.00001);
		Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);

	}

	@Test
	public void apenasUmNegocioGeraCandleComValoreIguais() {

		Calendar hoje = Calendar.getInstance();

		Negocio negocio1 = new Negocio(40.5, 100, hoje);

		List<Negocio> negocios = Arrays.asList(negocio1);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);

		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);

	}

}
