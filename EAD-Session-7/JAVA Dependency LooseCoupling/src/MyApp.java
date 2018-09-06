import textapplication.TextApplicationSpellChecker;



public class MyApp {
	
	public static void main(String args[]){
		TextEditor newTextEditor = new TextEditor();
		SpellChecker object = SpellChecker.getSpellcheckerobject();
		GrammarChecker object2 = GrammarChecker.getSpellcheckerobject();
		object.setStringToBeChecked("Hello World !");
		object2.setStringToBeChecked(" Have A Nice Day! ");
		newTextEditor.checkSpelling(object);
		newTextEditor.checkSpelling(object2);
	}
}
