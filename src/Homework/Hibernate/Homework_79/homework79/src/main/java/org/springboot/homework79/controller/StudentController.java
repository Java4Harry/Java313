package org.springboot.homework79.controller;

import org.springboot.homework79.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @GetMapping("/list")
    public String list(Model model){
        Student student1 = new Student("Алексей", "Воронов", 21, 4, "ИТ-4-2", "Информационные технологии");
        Student student2 = new Student("Геннадий", "Антонов", 20, 3, "ИБ-3-1", "Информационные безопасность");
        Student student3 = new Student("Алина", "Скворцова", 21, 4, "ИТ-4-2", "Информационные технологии");
        Student student4 = new Student("Станислав", "Беляшкин", 19, 2, "ИМ-2-3", "Интернет-маркетинг");
        Student student5 = new Student("Галина", "Голубева", 18, 1, "СТ-1-1", "Сетевые технологии");
        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        model.addAttribute("students", students);
        return "list";
    }
}
