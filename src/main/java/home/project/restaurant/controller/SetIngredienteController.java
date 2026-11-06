package home.project.restaurant.controller;

import home.project.restaurant.dao.repository.SetIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/set-ingrediente")
public class SetIngredienteController {

    private SetIngredienteRepository setIngredienteRepository;

    @Autowired
    public SetIngredienteController(SetIngredienteRepository setIngredienteRepository) {
        this.setIngredienteRepository = setIngredienteRepository;
    }

    @GetMapping("/perechi-cantitate-egala")
    public String getIngredientPairs(Model model) {
        List<Object[]> perechi = setIngredienteRepository.findIngredientPairs();
        model.addAttribute("titlu", "Perechi de ingrediente (Cantitate si UM identice)");
        model.addAttribute("perechi", perechi);
        return "ingrediente-perechi";
    }

    @GetMapping("/statistica-usturoi-toc")
    public String getAverageGarlic(Model model) {
        Double media = setIngredienteRepository.findAverageGarlicForTocRecipes();

        model.addAttribute("media", (media != null) ? media : 0.0);
        model.addAttribute("titlu", "Media Usturoiului în retete de tip 'Toc...'");

        return "statistica-usturoi";
    }
}