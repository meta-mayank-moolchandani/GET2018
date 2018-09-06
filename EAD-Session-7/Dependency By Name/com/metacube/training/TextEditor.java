package com.metacube.training;

//Class to represent the working of Text Editor
public class TextEditor {

	private SpellChecker spellChecker1;
	private SpellChecker spellChecker2;
	private String word;

	// Getters Setters
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setSpellChecker1(SpellChecker spellChecker) {
		this.spellChecker1 = spellChecker;
	}

	public SpellChecker getSpellChecker1() {
		return spellChecker1;
	}

	// Gettes Setters END

	public void check() {
		System.out.println(spellChecker1.checkSpelling()+spellChecker2.checkSpelling() + " of " + getWord());
	}

	public SpellChecker getSpellChecker2() {
		return spellChecker2;
	}

	public void setSpellChecker2(SpellChecker spellChecker2) {
		this.spellChecker2 = spellChecker2;
	}
}