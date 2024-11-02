package org.spring.mvc.task.controller;

import jakarta.servlet.http.HttpSession;
import org.spring.mvc.task.entity.Task;
import org.spring.mvc.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/home")
    public String home(HttpSession session){
        List<Task> taskList = taskService.findAllTasks();
        session.setAttribute("taskList", taskList);
        return "home";
    }

    @RequestMapping("/new")
    public String showTask(Map<String, Object> model){
        Task task = new Task();
        model.put("task", task);
        return "new_task";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTask(@ModelAttribute("task") Task task, HttpSession session){
        taskService.save(task);
        session.setAttribute("msg", "Задача добавлена!");
        return "redirect:/home";
    }

    @RequestMapping("/edit/{id}")
    public String showTask(@PathVariable("id") int id, Model model){
        Task task = taskService.getTaskById(id);
        model.addAttribute("editTask", task);
        return "edit_task";
    }

    @RequestMapping(value = "/updateTask", method = RequestMethod.POST)
    public String updateTask(@ModelAttribute("task") Task task, @RequestParam("id") long id, HttpSession session){
        taskService.update(task, id);
        session.setAttribute("msg", "Задача обновлена!");
        return "redirect:/home";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") long id, HttpSession session){
        taskService.deleteTask(id);
        session.setAttribute("msg", "Задача удалена!");
        return "redirect:/home";
    }
}
