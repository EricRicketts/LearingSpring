package org.example;

import org.example.model.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book book = context.getBean("book", Book.class);
        book.setTitle("Pride and Prejudice");
        System.out.println(book.getTitle());
    }
}
