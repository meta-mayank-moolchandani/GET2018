package com.metacube.training;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String args[]) {
		

		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		TextEditor textEditor = context.getBean(TextEditor.class);
		System.out.println(textEditor);
		
	}
}