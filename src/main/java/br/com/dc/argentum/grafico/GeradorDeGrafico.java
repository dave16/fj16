package br.com.dc.argentum.grafico;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import br.com.dc.argentum.SerieTemporal;
import br.com.dc.argentum.indicadores.Indicador;
import br.com.dc.argentum.indicadores.MediaMovelSimples;

public class GeradorDeGrafico {

	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private DefaultCategoryDataset dados;
	private JFreeChart grafico;

	public GeradorDeGrafico(SerieTemporal serie, int comeco, int fim) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.dados = new DefaultCategoryDataset();
		this.grafico = ChartFactory.createLineChart("Indicadores", "Dias",
				"Valores", dados, PlotOrientation.VERTICAL, true, true, false);
	}

	public void plotaIndicador(Indicador ind) {
		for (int i = comeco; i <= fim; i++) {
			double valor = ind.calcula(i, serie);
			dados.addValue(valor, ind.toString(), Integer.valueOf(i));
		}
	}

	public void salva(OutputStream out) throws IOException {
		ChartUtilities.writeChartAsPNG(out, grafico, 500, 350);
	}
	
	public JPanel getPanel(){
		return new ChartPanel(grafico);
	}
}
