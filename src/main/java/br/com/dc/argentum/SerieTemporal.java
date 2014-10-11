package br.com.dc.argentum;

import java.util.List;

public class SerieTemporal {

	private  List<Candle> candles;
	
	public SerieTemporal(List<Candle> candles){
		this.candles = candles;
	}
	
	public Candle getCandle(int i){
		return this.candles.get(i);
	}
	
	public int getTotal(){
		return this.candles.size();
	}
}
