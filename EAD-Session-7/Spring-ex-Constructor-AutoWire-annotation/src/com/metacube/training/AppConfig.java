package com.metacube.training;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {

	@Bean(name="texteditor")
	public TextEditor textEditor(SpellChecker spellChecker1, SpellChecker spellChecker2) {
		return new TextEditor(spellChecker1, spellChecker2);
	}

	@Bean
	public SpellChecker spellChecker1() {
		return new SpellChecker("mayank ji :");
	}

	@Bean
	public SpellChecker spellChecker2(){
		return new SpellChecker("mayank ji :");
	}

}
