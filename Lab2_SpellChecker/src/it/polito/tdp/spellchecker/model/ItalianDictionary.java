package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

import it.polito.tdp.spellchecker.db.RichWordDAO;

public class ItalianDictionary extends Dictionary {

	public ItalianDictionary() {
		super();
		dizionario = new ArrayList<String>();
		this.loadDictionary();
	}

	public String loadDictionary() {
		//Lettura da file
		try {
			FileReader fr = new FileReader("rsc/Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				if(word.contains("'")){ //elimino apostrofi per poter eseguire la normale ricerca dicotomica
					word = word.replace("'", "");
				}
			// Aggiungo word alla struttura dati
				dizionario.add(word);
			}
			br.close();
			} 
		catch (IOException e){
				System.out.println("Errore nella lettura del file");
				return "Errore nella lettura del file";
			}
		return "Lettura file avvenuta correttamente";
	}

	@Override
	public List<RichWord> spellCheckTest(List<String> inputTextList) {
		//Metodo per il controllo ortografico del testo in input
		RichWordDAO dao = new RichWordDAO();
		List<RichWord> listaParole = new ArrayList<RichWord>();
		for(String s : inputTextList){
			//Assumendo che ci sia una parola per riga
			if(dao.cercaParola(s)==false){
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

}


