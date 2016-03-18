package it.polito.tdp.spellchecker.model;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class RichWord {
	
	private String parola;
	private boolean corretta;
	
	public RichWord(String parola, boolean corretta) {
		this.parola = parola;
		this.corretta = corretta;
	}
	
	public String getParola() {
		return parola;
	}

	public String toString(){
		return parola;
	}
	
	public int checkTrue(Text t){
		if(this.corretta == false){
			t.setFill(Color.RED);
			return -1;
		}
		else{
			return 0;
		}
	}
	
	
	
	

}
