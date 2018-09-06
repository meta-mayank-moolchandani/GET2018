package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;


//Class to represent the working of Text Editor
public class TextEditor {

	private SpellChecker spellChecker;

	private SpellChecker spellChecker2;
	
	@Autowired
	public TextEditor(SpellChecker spellChecker, SpellChecker spellChecker2) {
		super();
		this.spellChecker = spellChecker;
		this.spellChecker2 = spellChecker2;
	}

	@Override
	public String toString() {
		return "TextEditor [spellChecker=" + spellChecker.checkSpelling() + ", spellChecker2="
				+ spellChecker2.checkSpelling() + "]";
	}
}