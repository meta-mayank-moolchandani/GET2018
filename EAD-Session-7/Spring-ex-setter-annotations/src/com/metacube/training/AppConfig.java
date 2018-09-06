package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;


@Configuration
public class AppConfig {
	
	@Bean
	public TextEditor textEditor(){
		TextEditor textEditor = new TextEditor();
		textEditor.setWord("hey");
		textEditor.setSpellChecker(spellChecker());
		textEditor.setSpellChecker2(spellChecker2());
		return textEditor;
		}
	
	@Bean
	public SpellChecker spellChecker(){
		SpellChecker spellChecker = new SpellChecker();
		spellChecker.setName("mayank ji :");
		return spellChecker;
	}
	
	@Bean
	public SpellChecker spellChecker2(){
		SpellChecker spellChecker = new SpellChecker();
		spellChecker.setName("sankalp: ");
		return spellChecker;
	}

	
	
}
