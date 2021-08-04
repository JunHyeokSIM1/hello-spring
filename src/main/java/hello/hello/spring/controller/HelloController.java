package hello.hello.spring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name , Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-String")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }


}
