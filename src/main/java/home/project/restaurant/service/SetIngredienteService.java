package home.project.restaurant.service;

import home.project.restaurant.dao.service.SetIngredienteServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetIngredienteService {

    private final SetIngredienteServiceDAO setIngredienteServiceDAO;

    @Autowired
    public SetIngredienteService(SetIngredienteServiceDAO setIngredienteServiceDAO) {
        this.setIngredienteServiceDAO = setIngredienteServiceDAO;
    }

    public List<Object[]> findAllPairIngredients(){
        return setIngredienteServiceDAO.findAllIngredientePereche();
    }

    public Double findValMedieUsturoiPentruReteteCareContinToc(){
        return setIngredienteServiceDAO.findAllAvgForRecipeWithToc();
    }
}
