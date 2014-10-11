package br.comdc.argentum.testes;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

import br.com.dc.argentum.SerieTemporal;
import br.com.dc.argentum.grafico.GeradorDeGrafico;
import br.com.dc.argentum.indicadores.IndicadorFechamento;
import br.com.dc.argentum.indicadores.MediaMovelSimples;
import br.com.dc.argentum.reader.GeradorDeSerie;

public class TestaGrafico {

	public static void main(String[] args) throws IOException {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6, 7, 8,
				8, 9, 9, 4, 3, 2, 1, 2, 2, 4, 5, 6, 7, 8, 9, 10, 11, 10, 6, 3,
				2, 6, 7, 8, 9);
		GeradorDeGrafico g = new GeradorDeGrafico(serie, 3, 32);
		g.plotaIndicador(new MediaMovelSimples());
		g.plotaIndicador(new IndicadorFechamento());
		g.salva(new FileOutputStream("grafico.png"));
		
		JFrame frame = new JFrame("Minha janela");
		frame.add(g.getPanel());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
