package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domains.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
*@Service - Аннотация, объявляющая, что этот класс представляет собой сервис –
* компонент сервис-слоя.
* */
@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
    /*
     *Поле сервиса работы с хранилищем польз.
     * @Autowired используется для дальнейшего контроля над внедрением зависимостей.
     * Он используется для подключения одного компонента к другому без создания
     * экземпляра первого
     * */
    @Autowired
    private DataProcessingService dataProcessingService;
    /*
     *Поле сервиса создания пользователей
     * */
    @Autowired
    private UserService userService;
    /*
     *Поле сервиса консольных уведомлений
     * */
    @Autowired
    private NotificationService notificationService;


    @Autowired
    private UserRepository userRepository;
    // Связи с репозиториями

    //Поля UserService, NotificationService
    //Метод processRegistration
    // 1) В класс RegistrationService добавить поля UserService, NotificationService(добавить в
    // IOC контейнер аннотацией @Autowired или через конструктор класса)
    //2) Разработать метод processRegistration в котором:

    /*
     * Метод сохраниния пользователей в базе данных
     * Имя name пользователя
     * Возраст age пользователя
     * email пользователя
     * */
    public void processRegistration(String name, int age, String email) {
        // Создается пользователь из параметров метода
        User newUser = userService.createUser(name, age, email);
        // Созданный пользователь добавляется в репозиторий
        dataProcessingService.addUserToList(newUser);
        // Через notificationService выводится сообщение в консоль
        notificationService.sendNotification("Новый пользователь успешно создан!");
    }
}
