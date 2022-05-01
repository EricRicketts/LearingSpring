package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/resources/applicationContext.xml")
public class AppTest {
    ApplicationContext context;
    @BeforeEach
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void testGetBookBean() {
        Book book = context.getBean("book", Book.class);
        assertInstanceOf(Book.class, book);
    }
}
