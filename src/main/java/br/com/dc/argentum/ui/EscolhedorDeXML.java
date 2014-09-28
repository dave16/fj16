package br.com.dc.argentum.ui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.dc.argentum.Negocio;
import br.com.dc.argentum.reader.LeitorXML;

public class EscolhedorDeXML {

	public void escolhe() {
		try {

			JFileChooser chooser = new JFileChooser("/C:/users/Roberto/documents/java/workspace jboss");
			chooser.setFileFilter(new FileNameExtensionFilter("Apenas XML", "xml"));
			int retorno = chooser.showOpenDialog(null);

			if (retorno == JFileChooser.APPROVE_OPTION) {
				FileReader reader = new FileReader(chooser.getSelectedFile());
				List<Negocio> negocios = new LeitorXML().carrega(reader);

				Negocio primeiroNegocio = negocios.get(0);
				String mensagem = "Primeiro neg�cio : "
						+ primeiroNegocio.getPreco();
				JOptionPane.showMessageDialog(null, mensagem);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EscolhedorDeXML().escolhe();
	}
}
