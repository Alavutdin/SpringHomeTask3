package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domains.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**@RestController — это составная аннотация, которая сама мета-аннотируется
 * аннотациями @Controller
 *@RequestMapping - это типичная аннотация в среде Spring, которая позволяет
 * нам сопоставлять HTTP-запросы с методами, которые мы хотели бы запустить.
 * */

@RestController
@RequestMapping("/tasks")
public class TaskController {
/*
* Сервис обработки задач*/
    @Autowired
    private DataProcessingService service;
/**
 * Метод получения списка поддерживаемых задач
 * tasks - список задач
 * @Getmapping("") указывает, что методы обрабатывают GET-запросы.
 * */
    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }
/*
* Метод списка пользователей отсортированных по возрасту
* */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    //метод filterUsersByAge
    //Подсказка  @GetMapping("/filter/{age}")
    // 3) В TaskController добавить обработчики filterUsersByAge()(Подсказка
    // @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))

    /**
     * Метод получения списка польз. старше заданного возраста
     * @PathVariable в Spring используется для привязки переменных
     * шаблона URI запроса к параметрам метода контроллера.
     * */
    @GetMapping("/filter/{age}")
    //4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable
    public List<User> filterUsersByAge(@PathVariable int age){
        return service.filterUsersByAge(service.getRepository().getUsers(),age);
        //В методе filterUsersByAge в age получать через аннотацию @PathVariable
    }

    /**
     *Метод calculateAverageAge получение среднего возрата пользователей
     * Подсказка @GetMapping("/calc")
        */

    @GetMapping("/calc")
    public double calculateAverageAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
