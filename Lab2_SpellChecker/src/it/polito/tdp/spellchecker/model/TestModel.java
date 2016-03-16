package it.polito.tdp.spellchecker.model;

import java.util.*;

public class TestModel {

	public static void main(String[] args) {
		//Test ItalianDictionary
		System.out.println("-----TEST CARICAMENTO DIZIONARIO-----");
		Dictionary model = new ItalianDictionary();
		System.out.println(model.loadDictionary());
		System.out.println("\n-----TEST RICERCA PAROLE SINGOLE-----");
		List<String> listaParole = new ArrayList<String>();
		listaParole.add("caso");
		listaParole.add("idrifobo");
		listaParole.add("presidenziale");
		listaParole.add("cannenata");
		listaParole.add("sesquipedale");
		listaParole.add("pazzerollo");
		listaParole.add("simpiosi");
		listaParole.add("zuffa");
		List<RichWord> result = new ArrayList<RichWord>();
		result = model.spellCheckTest(listaParole);
		System.out.println(result.toString());
		//Test EnglishDictionary
		System.out.println("\n-----TEST CARICAMENTO DIZIONARIO ENG-----");
		Dictionary modelEng = new EnglishDictionary();
		System.out.println(modelEng.loadDictionary());	
		System.out.println("\n-----TEST RICERCA PAROLE SINGOLE ENG-----");
		List<String> listaParoleEng = new ArrayList<String>();
		listaParoleEng.add("this");
		listaParoleEng.add("houze");
		listaParoleEng.add("presidenziale");
		listaParoleEng.add("cannenata");
		listaParoleEng.add("obvious");
		listaParoleEng.add("pazzerollo");
		listaParoleEng.add("simpiosi");
		listaParoleEng.add("zuffa");	
		List<RichWord> resultEng = new ArrayList<RichWord>();
		resultEng = modelEng.spellCheckTest(listaParoleEng);
		System.out.println(resultEng.toString());

	}

}
