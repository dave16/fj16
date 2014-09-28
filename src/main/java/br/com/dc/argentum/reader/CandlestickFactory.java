package br.com.dc.argentum.reader;

import java.util.ArrayList;
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

	public List<Candlestick> constroiCandles(List<Negocio> todosNegocios) {
		List<Candlestick> candles = new ArrayList<>();

		List<Negocio> negociosDoDia = new ArrayList<>();
		Calendar dataAtual = todosNegocios.get(0).getData();

		for (Negocio negocio : todosNegocios) {
			if (!negocio.isMesmoDia(dataAtual)) {
				Candlestick candleDoDia = constroiCandleParaData(dataAtual,
						negociosDoDia);
				candles.add(candleDoDia);
				negociosDoDia = new ArrayList<Negocio>();
				dataAtual = negocio.getData();
			}
			negociosDoDia.add(negocio);
		}
		Candlestick candleDoDia = constroiCandleParaData(dataAtual,
				negociosDoDia);
		candles.add(candleDoDia);
		return candles;
	}

}
