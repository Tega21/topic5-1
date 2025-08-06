package com.gcu.controller;

import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import com.gcu.topic42.business.OrdersBusinessServiceInterface;
import com.gcu.topic42.business.SecurityBusinessService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {


    private final SecurityBusinessService security;
    private final OrdersBusinessServiceInterface service;

    @Autowired
    public LoginController(OrdersBusinessServiceInterface service, SecurityBusinessService security) {
        this.service = service;
        this.security = security;
    }

    @GetMapping("")
    public String display(Model model){
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin (@Valid LoginModel loginModel, BindingResult bindingResult, Model model){

        service.test();

        security.authenticate(loginModel.getUsername(), loginModel.getPassword());

        System.out.println("Username: " + loginModel.getUsername());
        System.out.println("Password: " + loginModel.getPassword());

        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Login Form");
            model.addAttribute("loginModel", loginModel);
            return "login";
        }

        //Order List
        List<OrderModel> orders = new ArrayList<>();
        orders.add(new OrderModel(1l, "1001", "Playstation 5", 499.99f, 1));
        orders.add(new OrderModel(2l, "1002", "27in Monitor", 399.99f, 2));
        orders.add(new OrderModel(3l, "1003", "Dualsense Controller", 69.99f, 1));
        orders.add(new OrderModel(4l, "1004", "Microphone", 39.99f, 1));

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", service.getOrders());

        return "orders";

    }

    @GetMapping("/test-layout")
    public String testLayout(Model model) {
        model.addAttribute("title", "Test Layout Page");
        return "test-layout"; // this matches the file name in /templates
    }
}
