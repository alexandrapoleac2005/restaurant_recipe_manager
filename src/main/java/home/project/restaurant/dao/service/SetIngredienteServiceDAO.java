package home.project.restaurant.dao.service;

import home.project.restaurant.dao.repository.SetIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetIngredienteServiceDAO {

    private final SetIngredienteRepository setIngredienteRepository;

    @Autowired
    public SetIngredienteServiceDAO(SetIngredienteRepository setIngredienteRepository) {
        this.setIngredienteRepository = setIngredienteRepository;
    }

    public List<Object[]> findAllIngredientePereche(){
        return setIngredienteRepository.findIngredientPairs();
    }

    public Double findAllAvgForRecipeWithToc(){
        return setIngredienteRepository.findAverageGarlicForTocRecipes();
    }
}
