package br.com.dc.argentum.reader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.dc.argentum.Candle;
import br.com.dc.argentum.SerieTemporal;

public class GeradorDeSerie {

	public static SerieTemporal criaSerie(double ... valores) {
		List<Candle> candles = new ArrayList<>();
		for(double d : valores){
			candles.add(new Candle(d, d, d, d, 1000, Calendar.getInstance()));
		}
		return new SerieTemporal(candles);
	}

}
