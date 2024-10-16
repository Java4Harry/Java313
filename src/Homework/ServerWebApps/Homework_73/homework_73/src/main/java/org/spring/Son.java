package org.spring;

public class Son implements Baby{
    public Son() {
        System.out.println("Son constructor");
    }
        @Override
        public void say(){
            System.out.println("Привет, папа! Я твой сын.");
        }
}
