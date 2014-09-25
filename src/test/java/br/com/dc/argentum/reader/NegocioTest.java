package br.com.dc.argentum.reader;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.Assert;

import org.junit.Test;

import br.com.dc.argentum.Negocio;

public class NegocioTest {
	
	@Test
	public void mesmoDiaHorasDiferentesNaoEhDoMesmoDia(){
		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);
		
		Negocio negocio = new Negocio(40.0, 100, manha);
		Assert.assertTrue(negocio.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoMilissegundoEhDoMesmoDia(){
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negocio negocio = new Negocio(40.0, 100, agora);
		Assert.assertTrue(negocio.isMesmoDia(mesmoMomento));
	}

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
