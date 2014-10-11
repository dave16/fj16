package br.com.dc.argentum.indicadores;

import br.com.dc.argentum.SerieTemporal;

public class IndicadorFechamento  implements Indicador{

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandle(posicao).getFechamento();
	}
	
	@Override
	public String toString(){
		return "Indicador de Fechamento";
	}

}
