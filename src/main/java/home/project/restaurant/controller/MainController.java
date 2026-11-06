package home.project.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class MainController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
