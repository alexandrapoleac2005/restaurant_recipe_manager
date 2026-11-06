package home.project.restaurant.service;

import home.project.restaurant.dao.entity.Reteta;
import home.project.restaurant.dao.service.RetetaServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetetaService {

    private final RetetaServiceDAO retetaServiceDAO;

    @Autowired
    public RetetaService(RetetaServiceDAO retetaServiceDAO) {
        this.retetaServiceDAO = retetaServiceDAO;
    }

    public List<Reteta> findVegetarianRecipesOrdered() {
        return retetaServiceDAO.findAllReteteVegetariene();
    }

    public List<Object[]> findRetete500gCeapa(){
        return retetaServiceDAO.findAllRetete500gCeapa();
    }

    public List<Object[]> findReteteVegetarieneMax(){
        return retetaServiceDAO.findAllReteteVegetarieneMaxime();
    }

    public List<Reteta> findReteteCuMaiMultUsturaoiDecatTocanita(){
        return retetaServiceDAO.findALlReteteCuMaiMultUsturoiDecatTocanita();
    }

    public List<Object[]> findMinMaxAvg(){
        return retetaServiceDAO.findAllMinMaxAvg();
    }
}
