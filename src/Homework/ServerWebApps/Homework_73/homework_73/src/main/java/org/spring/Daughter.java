package org.spring;

public class Daughter implements Baby{
    public Daughter() {
        System.out.println("Daughter constructor");
    }

    @Override
    public void say(){
        System.out.println("Привет, папа! Я твоя дочь.");
    }
}
