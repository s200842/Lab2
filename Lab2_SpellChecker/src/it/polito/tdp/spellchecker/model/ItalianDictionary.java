package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

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

}
