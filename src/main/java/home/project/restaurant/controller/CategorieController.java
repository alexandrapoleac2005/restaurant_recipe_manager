package home.project.restaurant.controller;

import home.project.restaurant.dao.entity.Categorie;
import home.project.restaurant.service.CatergorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CategorieController {

    private final CatergorieService categorieService;

    @Autowired
    public CategorieController(CatergorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/categorii")
    public String listaCategorii(Model model) {
        List<Categorie> lista = categorieService.findAll();
        model.addAttribute("categorii", lista);

        if (!model.containsAttribute("categorieNoua")) {
            model.addAttribute("categorieNoua", new Categorie());
        }
        return "categorii";
    }

    @PostMapping("/save-cat")
    public String saveCategorie(@ModelAttribute("categorieNoua") Categorie categorie) {
        categorieService.save(categorie);
        return "redirect:/api/categorii";
    }

    @GetMapping("/delete-cat/{id}")
    public String stergeCategorie(@PathVariable Integer id) {
        categorieService.delete(id);
        return "redirect:/api/categorii";
    }

    @GetMapping("/edit-cat/{id}")
    public String editeazaCategorie(@PathVariable Integer id, Model model) {
        Categorie cat = categorieService.findById(id);
        model.addAttribute("categorieNoua", cat);
        model.addAttribute("categorii", categorieService.findAll());
        return "categorii";
    }
}