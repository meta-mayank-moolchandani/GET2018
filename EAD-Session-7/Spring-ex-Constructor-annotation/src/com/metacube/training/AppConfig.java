package com.metacube.training;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;


@Configuration
public class AppConfig {
	
	@Bean
	public TextEditor textEditor(){
		TextEditor textEditor = new TextEditor(spellChecker(),spellChecker2());
		return textEditor;
		}
	
	@Bean
	public SpellChecker spellChecker(){
		SpellChecker spellChecker = new SpellChecker("mayank ji :");
		return spellChecker;
	}
	
	@Bean
	public SpellChecker spellChecker2(){
		SpellChecker spellChecker = new SpellChecker("Sankalp :");
		return spellChecker;
	}

	
	
}
