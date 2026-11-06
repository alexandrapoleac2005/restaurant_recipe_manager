package home.project.restaurant.service;

import home.project.restaurant.dao.entity.Ingredient;
import home.project.restaurant.dao.service.IngredientServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientServiceDAO ingredientServiceDAO;

    @Autowired
    public IngredientService(IngredientServiceDAO ingredientServiceDAO) {
        this.ingredientServiceDAO = ingredientServiceDAO;
    }

    public List<Ingredient> findIndgredients(){
        return ingredientServiceDAO.findIngredienteOrdonate();
    }

}
