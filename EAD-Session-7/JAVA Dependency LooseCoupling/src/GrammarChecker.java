import textapplication.TextApplicationSpellChecker;



public class GrammarChecker implements TextApplicationSpellChecker<GrammarChecker>{
public static final GrammarChecker SPELL_CHECKER_OBJECT = new GrammarChecker();
	
	private String stringToBeChecked;
	
	public GrammarChecker()
	{
	}
	
	public void setStringToBeChecked(String stringToBeChecked) {
		this.stringToBeChecked = stringToBeChecked;
	}

	public static GrammarChecker getSpellcheckerobject() {
		SPELL_CHECKER_OBJECT.stringToBeChecked = null;
		return SPELL_CHECKER_OBJECT;
	}
	
	public void GrammarChecker()
	{
		System.out.println(" String To Be Checked "+stringToBeChecked);
	}

	@Override
	public void spellCheck() {
		System.out.println(" String To Be Checked "+stringToBeChecked);
	}
}
