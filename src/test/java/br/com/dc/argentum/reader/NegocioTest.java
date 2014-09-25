package br.com.dc.argentum.reader;

import static org.junit.Assert.*;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

import br.com.dc.argentum.Negocio;

public class NegocioTest {

	@Test
	public void dataDoNegocioEhImutavel() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negocio negocio = new Negocio(10, 5, c);
		
		negocio.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		
		Assert.assertEquals(15, negocio.getData().get(Calendar.DAY_OF_MONTH));
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegocioComDataNula(){
		new Negocio(10, 5, null);
		
	}
}
