package br.com.dc.argentum.indicadores;

import br.com.dc.argentum.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	/* (non-Javadoc)
	 * @see br.com.dc.argentum.indicadores.Indicador#calcula(int, br.com.dc.argentum.SerieTemporal)
	 */
	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao - 2; i <= posicao; i++) {

			// Candle c = serie.getCandle(i);
			// soma += c.getFechamento();

			// Refatorado inline local variable
			soma += serie.getCandle(i).getFechamento();
		}
		return soma / 3;
	}

	@Override
	public String toString() {
		
		return "Média móvel simples do fechamento";
	}
}
