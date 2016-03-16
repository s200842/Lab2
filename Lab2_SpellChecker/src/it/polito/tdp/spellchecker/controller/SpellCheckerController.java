package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

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
    private TextArea txtResult;
    @FXML
    private Label lblResult;
    @FXML
    private Button btnClearText;
    @FXML
    private Label lblTime;
    
    public void setModel(Dictionary model){
    	this.model = model;
    }
    
    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

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
