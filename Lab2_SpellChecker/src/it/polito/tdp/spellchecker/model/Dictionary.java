package it.polito.tdp.spellchecker.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Dictionary {
	
	protected List<String> dizionario;
	
	public abstract String loadDictionary();
	
	public List<RichWord> spellCheckTest(List<String> inputTextList){
		//Metodo per il controllo ortografico del testo in input
		List<RichWord> listaParole = new ArrayList<RichWord>();
		for(String s : inputTextList){
			//Assumendo che ci sia una parola per riga
			if(dizionario.contains(s)==false){
				RichWord wtemp = new RichWord(s, false);
				listaParole.add(wtemp);
			}
			else{
				RichWord wtemp = new RichWord(s, true);
				listaParole.add(wtemp);
			}
		}
		return listaParole;
	}
	
	public List<RichWord> spellCheckTestDicotomica(List<String> inputTextList){
		//Metodo per il controllo ortografico del testo in input
		List<RichWord> listaParole = new ArrayList<RichWord>();
		for(String s : inputTextList){
			//Assumendo che ci sia una parola per riga
			int i = ricercaDicotomica(dizionario, s, 0, dizionario.size()-1);
			if(i == -1){
				RichWord wtemp = new RichWord(s, false);
				listaParole.add(wtemp);
			}
			else{
				RichWord wtemp = new RichWord(s, true);
				listaParole.add(wtemp);
			}
		}
		return listaParole;
	}
	
	public int ricercaDicotomica(List<String> inputTextList, String s, int low, int high){
		int mid = (low+high)/2;
		if((mid<low) || (high <0)){
			return -1; //non trovato
		}
		else if(s.compareTo(inputTextList.get(mid).toLowerCase())<0){
			return ricercaDicotomica(inputTextList, s, low, mid-1);
		}
		else if(s.compareTo(inputTextList.get(mid).toLowerCase())>0){
			return ricercaDicotomica(inputTextList, s, mid+1, high);
		}
		else{
			return mid; //trovato
		}
	}
	
	public List<String> dividiTesto(String testo){
		//Ho una serie di parole che possono essere separate da spazi, \n oppure segni di punteggiatura (che devo ignorare)
		List<String> result = new ArrayList<String>();
		String[] testoSplit = testo.split("[\\s.,;:\\n\\*\\!\\']+");
		for(String s : testoSplit){
			result.add(s);
		}
		return result;
	}
	
	
}

