package br.com.dc.argentum.reader;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;

import junit.framework.Assert;
import br.com.dc.argentum.Negocio;

import org.junit.Test;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmNegocioEmListaUnitaria() {

		String xmlDeTeste = "<list>" + "<negocio>" + "<preco>43.5</preco>"
				+ "<quantidade>1000</quantidade>" + "<data>"
				+ "<time>1322233344455</time>" + "</data>" + "</negocio>"
				+ "</list>";

		LeitorXML leitor = new LeitorXML();
		List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));

		for (Negocio negocio : negocios) {

			Assert.assertEquals(43.5, negocio.getPreco());
			Assert.assertEquals(1000, negocio.getQuantidade());

		}
		Assert.assertEquals(1, negocios.size());
	}

}
