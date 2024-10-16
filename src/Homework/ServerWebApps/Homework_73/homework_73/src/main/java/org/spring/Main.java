package org.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Father father = context.getBean("fatherBean", Father.class);
        father.callBaby();
        context.close();
    }
}