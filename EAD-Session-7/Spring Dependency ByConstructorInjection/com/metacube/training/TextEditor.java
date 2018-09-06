package com.metacube.training;

import textapplication.TextApplicationSpellChecker;


public class TextEditor {
	SpellChecker object;
	
	public TextEditor(SpellChecker object){
		this.object = object;
	}

	public void checkSpelling(){
		object.spellCheck();
	}
}
