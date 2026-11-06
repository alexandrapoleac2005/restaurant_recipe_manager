package home.project.restaurant.dao.service;

import home.project.restaurant.dao.entity.Ingredient;
import home.project.restaurant.dao.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceDAO {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceDAO(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> findIngredienteOrdonate(){
        return ingredientRepository.findIngredientsWithE();
    }
}
