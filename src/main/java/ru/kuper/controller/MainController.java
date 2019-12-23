package ru.kuper.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import ru.kuper.models.Auto;
import ru.kuper.models.User;
import ru.kuper.services.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class MainController {

    private UserService userService = new UserService();

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = false, defaultValue = "World") String name,
        Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping(value = "/addUserWithCarShow")
    public String showUserWithCar(@RequestParam(name="name", defaultValue = "myName", required = false) String name,
                          @RequestParam(name="age", defaultValue = "myAge", required = false) String age,
                          @RequestParam(name="auto", defaultValue = "myCar", required = false) String car,
                          Map<String, Object> model) {
        model.put("name", name);
        model.put("age", age);
        model.put("car", car);
        return "addUserWithCarShow";
    }

    @GetMapping(value = "/addUserWithCar")
    public String addUserWithCar() {
        return "addUserWithCar";
    }

    @PostMapping(value = "/addUserWithCar")
    public void addUserWithCar(@RequestBody String body, String userName, int userAge, String autoModel, String autoColor) {
        User user = new User(userName, userAge);
        Auto auto = new Auto(autoModel, autoColor);
        auto.setUser(user);
        user.addAuto(auto);
        List<User> list = new ArrayList<>();
        list.add(user);
        userService.saveUser(user);
    }

}
