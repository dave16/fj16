package br.com.dc.argentum.reader;

import java.util.Calendar;
import java.util.List;

import br.com.dc.argentum.Candlestick;
import br.com.dc.argentum.Negocio;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data,
			List<Negocio> negocios) {

		double maximo = negocios.get(0).getPreco();
		double minimo = negocios.get(0).getPreco();
		double volume = 0;

		for (Negocio negocio : negocios) {

			volume += negocio.getVolume();

			if (negocio.getPreco() > maximo) {
				maximo = negocio.getPreco();
			} else if (negocio.getPreco() < minimo) {
				minimo = negocio.getPreco();
			} else if (negocio == null) {
				System.out.println("Sem negócio");
			}
		}

		double abertura = negocios.get(0).getPreco();
		double fechamento = negocios.get(negocios.size() - 1).getPreco();

		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);

	}

}
