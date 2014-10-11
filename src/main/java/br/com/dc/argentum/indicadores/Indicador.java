package br.com.dc.argentum.indicadores;

import br.com.dc.argentum.SerieTemporal;

public interface Indicador {

	public abstract double calcula(int posicao, SerieTemporal serie);

}