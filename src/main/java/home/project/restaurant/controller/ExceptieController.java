package home.project.restaurant.controller;

import home.project.restaurant.dao.entity.Exceptie;
import home.project.restaurant.service.ExceptieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/procedura-stocata")
public class ExceptieController {

    private final ExceptieService exceptieService;

    @Autowired
    public ExceptieController(ExceptieService exceptieService) {
        this.exceptieService = exceptieService;
    }

    @GetMapping
    public String paginaExceptii(@RequestParam(name = "cautare", required = false) String cautare, Model model) {
        List<Exceptie> rezultate = exceptieService.findAllExc(cautare);

        model.addAttribute("exceptii", rezultate);
        model.addAttribute("ultimaCautare", cautare);
        return "procedura-stocata";
    }
}