package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

//Class to represent the working of Text Editor
public class TextEditor {
	
	@Autowired
	private SpellChecker spellChecker;

	@Autowired
	private SpellChecker spellChecker2;
	
	public SpellChecker getSpellChecker2() {
		return spellChecker2;
	}
	public void setSpellChecker2(SpellChecker spellChecker2) {
		this.spellChecker2 = spellChecker2;
	}
	private String word;


	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Override
	public String toString() {
		return "TextEditor [spellChecker function call=" + spellChecker.checkSpelling() +"spell2: " + spellChecker2.checkSpelling()+ ", word=" + word
				+ "]";
	}
	
	 

}