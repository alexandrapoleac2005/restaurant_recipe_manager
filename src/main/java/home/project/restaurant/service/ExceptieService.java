package home.project.restaurant.service;

import home.project.restaurant.dao.entity.Exceptie;
import home.project.restaurant.dao.service.ExceptieServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptieService {

    private final ExceptieServiceDAO exceptieServiceDAO;

    @Autowired
    public  ExceptieService(ExceptieServiceDAO exceptieServiceDAO) {
        this.exceptieServiceDAO = exceptieServiceDAO;
    }

    public List<Exceptie> findAllExc(String natura){
        return exceptieServiceDAO.findAllExceptions(natura);
    }

}
