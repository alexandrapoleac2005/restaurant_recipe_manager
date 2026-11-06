package home.project.restaurant.controller;

import home.project.restaurant.dao.entity.Ingredient;
import home.project.restaurant.dao.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/ingrediente")
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @GetMapping("/cu-litera-e")
    public String getIngredientsWithE(Model model) {
        List<Ingredient> listaIngrediente = ingredientRepository.findIngredientsWithE();

        model.addAttribute("titlu", "Ingrediente care contin litera 'e'");
        model.addAttribute("ingrediente", listaIngrediente);

        return "ingrediente-lista"; // Numele fișierului HTML
    }


}