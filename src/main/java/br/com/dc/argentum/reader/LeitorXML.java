package br.com.dc.argentum.reader;

import java.io.Reader;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.dc.argentum.Negocio;

public class LeitorXML {

	public List<Negocio> carrega(Reader fonte){
		XStream stream = new XStream(new DomDriver());
		stream.alias("negocio", Negocio.class);
		return (List<Negocio>) stream.fromXML(fonte);
	}
}
