package home.project.restaurant.dao.service;

import home.project.restaurant.dao.entity.Reteta;
import home.project.restaurant.dao.repository.RetetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetetaServiceDAO {

    private final RetetaRepository retetaRepository;

    @Autowired
    public RetetaServiceDAO(RetetaRepository retetaRepository) {
        this.retetaRepository = retetaRepository;
    }

    public List<Reteta> findAllReteteVegetariene(){
        return retetaRepository.findVegetarianRecipesOrdered();
    }

    public List<Object[]> findAllRetete500gCeapa(){
        return retetaRepository.findRecipesWith500gCeapa();
    }

    public List<Object[]> findAllReteteVegetarieneMaxime(){
        return retetaRepository.findVegetarianRecipesWithMaxTime();
    }

    public List<Reteta> findALlReteteCuMaiMultUsturoiDecatTocanita(){
        return retetaRepository.findRecipesWithMoreGarlicThanChickenStew();
    }

    public List<Object[]> findAllMinMaxAvg(){
        return retetaRepository.getPreparationTimeStatsPerType();
    }
}
