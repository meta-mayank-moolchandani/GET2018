package com.metacube.training;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import textapplication.TextApplicationSpellChecker;



public class MyApp {
	
	public static void main(String args[]){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.checkSpelling();
		
	}
}
