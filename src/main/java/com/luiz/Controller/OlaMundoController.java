package com.luiz.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("olaMundoSpring")
public class OlaMundoController {


    @RequestMapping(method = RequestMethod.GET)
    public String execute() {
        System.out.println("Executando a lógica com Spring MVC");
        return "inicio";
    }

}
