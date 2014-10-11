package br.com.dc.argentum.reader;

import junit.framework.Assert;

import org.junit.Test;

import br.com.dc.argentum.SerieTemporal;
import br.com.dc.argentum.indicadores.Indicador;
import br.com.dc.argentum.indicadores.MediaMovelSimples;
import br.comdc.argentum.testes.GeradorAleatorioDeXML;

public class MediaMovelSimplesTest {

	@Test
	public void sequenciaSimplesDeCandles(){
		SerieTemporal serie = GeradorDeSerie.criaSerie(1,2,3,4,3,4,5,4,3);
		Indicador mms = new MediaMovelSimples();
		
		Assert.assertEquals(2.0, mms.calcula(2, serie),0.00001);
		Assert.assertEquals(3.0, mms.calcula(3, serie),0.00001);
		Assert.assertEquals(10.0/3, mms.calcula(4, serie),0.00001);
		Assert.assertEquals(11.0/3, mms.calcula(5, serie),0.00001);
	}

}
