
import textapplication.TextApplicationSpellChecker;


public class TextEditor {
	TextApplicationSpellChecker object;
	
	public TextEditor(){}

	public void checkSpelling(TextApplicationSpellChecker object){
		this.object = object;
		object.spellCheck();
	}
}
