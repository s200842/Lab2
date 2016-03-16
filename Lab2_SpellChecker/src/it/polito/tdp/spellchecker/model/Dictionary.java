package it.polito.tdp.spellchecker.model;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	protected List<String> dizionario;
	
	public String loadDictionary(){
		//Implementato nelle classi figlie
		return null;
	}
	
	public List<RichWord> spellCheckTest(List<String> inputTextList){
		//Metodo per il controllo ortografico del testo in input
		List<RichWord> listaSbagliate = new ArrayList<RichWord>();
		for(String s : inputTextList){
			//Assumendo che ci sia una parola per riga
			if(dizionario.contains(s)==false){
				RichWord wtemp = new RichWord(s, false);
				listaSbagliate.add(wtemp);
			}
		}
		return listaSbagliate;
	}
	
	public List<String> dividiTesto(String testo){
		//Ho una serie di parole che possono essere separate da spazi, \n oppure segni di punteggiatura (che devo ignorare)
		List<String> result = new ArrayList<String>();
		String[] testoSplit = testo.split("[\\s.,;:\\n\\*]+");
		for(String s : testoSplit){
			result.add(s);
		}
		return result;
	}
}

