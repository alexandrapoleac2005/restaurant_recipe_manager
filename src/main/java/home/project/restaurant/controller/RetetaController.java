package home.project.restaurant.controller;

import home.project.restaurant.dao.entity.Categorie;
import home.project.restaurant.dao.entity.Reteta;
import home.project.restaurant.dao.repository.RetetaRepository;
import home.project.restaurant.service.CatergorieService;
import home.project.restaurant.service.RetetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class RetetaController {

    private final RetetaService retetaService;

    @Autowired
    public RetetaController(RetetaService retetaService) {
        this.retetaService = retetaService;
    }

    @GetMapping("retete/vegetariene")
    public String getVegetarianRecipes(Model model) {
        List<Reteta> reteteVeg = retetaService.findVegetarianRecipesOrdered();

        model.addAttribute("titlu", "Retete Vegetariene");
        model.addAttribute("retete", reteteVeg);

        return "retete-vegetariene"; // Numele fișierului HTML
    }

    @GetMapping("/retete/ceapa-500g")
    public String getCeapaRecipes(Model model) {
        List<Object[]> rezultate = retetaService.findRetete500gCeapa();

        model.addAttribute("titlu", "Retete cu 500g Ceapa");
        model.addAttribute("date", rezultate);

        return "retete-ceapa";
    }

    @GetMapping("/retete/vegetarian-max-time")
    public String getVegetarianMaxTime(Model model) {
        List<Object[]> rezultate = retetaService.findReteteVegetarieneMax();

        model.addAttribute("titlu", "Retete Vegetariene cu Timp Maxim");
        model.addAttribute("date", rezultate);

        return "retete-timp-maxim";
    }

    @GetMapping("/retete/mai-mult-usturoi")
    public String getRecipesWithMoreGarlic(Model model) {
        List<Reteta> retete = retetaService.findReteteCuMaiMultUsturaoiDecatTocanita();

        model.addAttribute("titlu", "Retete cu mai mult usturoi decat Tocanita de pui");
        model.addAttribute("retete", retete);

        return "retete-usturoi";
    }

    @GetMapping("/retete/statistici-timp")
    public String getTimeStatistics(Model model) {
        List<Object[]> statistici = retetaService.findMinMaxAvg();

        model.addAttribute("titlu", "Statistici Timp Preparare pe Tip de Reteta");
        model.addAttribute("statistici", statistici);

        return "retete-statistici";
    }
}
