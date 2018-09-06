import textapplication.TextApplicationSpellChecker;

public class SpellChecker implements TextApplicationSpellChecker<SpellChecker> {
	
	public static final SpellChecker SPELL_CHECKER_OBJECT = new SpellChecker();
	
	private String stringToBeChecked;
	
	public SpellChecker()
	{
	}
	
	public void setStringToBeChecked(String stringToBeChecked) {
		this.stringToBeChecked = stringToBeChecked;
	}

	public static SpellChecker getSpellcheckerobject() {
		SPELL_CHECKER_OBJECT.stringToBeChecked = null;
		return SPELL_CHECKER_OBJECT;
	}
	
	public void spellCheck()
	{
		System.out.println(" String To Be Checked "+stringToBeChecked);
	}
}
