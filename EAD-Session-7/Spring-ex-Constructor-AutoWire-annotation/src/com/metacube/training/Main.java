package com.metacube.training;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String args[]) {
		

		@SuppressWarnings("resource")
//		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


		TextEditor textEditor = (TextEditor) context.getBean("texteditor");
		System.out.println(textEditor);
		
	}
}