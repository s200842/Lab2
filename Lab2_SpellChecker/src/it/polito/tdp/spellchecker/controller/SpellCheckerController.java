package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SpellCheckerController {

	private Dictionary model;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblChoose;
    @FXML
    private ComboBox<String> boxLanguage;
    @FXML
    private TextArea txtInput;
    @FXML
    private Button btnspellCheck;
    @FXML
    private TextFlow txtResult;
    @FXML
    private Label lblResult;
    @FXML
    private Button btnClearText;
    @FXML
    private Label lblTime;
    Text textEmpty = new Text("");
    Text errNoLingua = new Text("Scegliere una lingua per il controllo ortografico");
    Text errNoTesto = new Text("Inserire il testo per il controllo ortografico");
    
    public void setModel(Dictionary model){
    	this.model = model;
    }
    
    @FXML
    void doClearText(ActionEvent event) {
    	txtInput.setText("");
    	txtResult.getChildren().clear();
    	lblResult.setVisible(false);
    	lblTime.setVisible(false);
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	txtResult.getChildren().clear();
    	//Gestione eccezioni e controllo lingua dizionario
    	if(boxLanguage.getValue() == null){
    		txtResult.getChildren().add(errNoLingua);
    		return;
    	}
    	else if(boxLanguage.getValue().compareTo("English")== 0){
    		model = new EnglishDictionary();
    		model.loadDictionary();
    	}
    	else if(boxLanguage.getValue().compareTo("Italian")== 0){
    		model = new ItalianDictionary();
    		model.loadDictionary();
    	}
    	List<RichWord> paroleErrate = new ArrayList<RichWord>();
    	if(txtInput.getText().compareTo("")==0){
    		txtResult.getChildren().add(errNoTesto);
    		return;
    	}
    	//Controllo ortografico e calcolo tempo impiegato
    	String inputText = txtInput.getText().toLowerCase();
    	List<String> inputDiviso = new ArrayList<String>();
    	inputDiviso = model.dividiTesto(inputText);
    	long t0 = System.nanoTime();
    	paroleErrate = model.spellCheckTest(inputDiviso);
    	long t1 = System.nanoTime();
    	lblTime.setVisible(true);
    	lblTime.setText(String.format("Spell check completed in %f seconds", (t1-t0)/1e9));
    	//Formattazione e comparsa testo risultato
    	String result = "";
    	List<Text> risultato = new ArrayList<Text>();
    	for(int i=0; i<inputDiviso.size(); i++){
    		result = inputDiviso.get(i);
    		Text ttemp = new Text(result);
    		if(i!=inputDiviso.size()-1){
    			ttemp = new Text(result+" ");
    		}
    		for(RichWord rw : paroleErrate){
    			if(rw.getParola().equals(result)){
        			ttemp.setFill(Color.RED);
        		}
    		}
    		risultato.add(ttemp);
    	}
       	txtResult.getChildren().addAll(risultato);
    	if(result.compareTo("")!=0){
    		lblResult.setVisible(true);
    	}
    }

    @FXML
    void initialize() {
        assert lblTitle != null : "fx:id=\"lblTitle\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblChoose != null : "fx:id=\"lblChoose\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert boxLanguage != null : "fx:id=\"boxLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnspellCheck != null : "fx:id=\"btnspellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblResult != null : "fx:id=\"lblResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        
        boxLanguage.getItems().add("English");
        boxLanguage.getItems().add("Italian");
    }
}
