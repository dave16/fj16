package br.com.dc.argentum;

import java.util.Calendar;

public final class Negocio {

	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negocio(double preco, int quantidade, Calendar data) {
		super();
		if (data == null) {
			throw new IllegalArgumentException("Data n�o pode ser nula");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) data.clone();
	}

	public double getVolume() {
		return preco * quantidade;
	}

	public boolean isMesmoDia(Calendar outraData) {
		return data.get(Calendar.DATE) == outraData.get(Calendar.DATE)
				&& data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH)
				&& data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
		
	}
}
