package com.metacube.training;
import textapplication.TextApplicationSpellChecker;

public class SpellChecker implements TextApplicationSpellChecker<SpellChecker> {
	
	private String stringToBeChecked;
	
	public SpellChecker(String stringToBeChecked)
	{
		this.stringToBeChecked = stringToBeChecked;
	}
	
	public void spellCheck()
	{
		System.out.println(" String To Be Checked "+stringToBeChecked);
	}
}
