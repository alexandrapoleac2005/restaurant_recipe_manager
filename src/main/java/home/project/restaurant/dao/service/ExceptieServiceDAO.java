package home.project.restaurant.dao.service;

import home.project.restaurant.dao.entity.Exceptie;
import home.project.restaurant.dao.repository.ExceptieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptieServiceDAO {

    private final ExceptieRepository exceptieRepository;

    @Autowired
    public ExceptieServiceDAO(ExceptieRepository exceptieRepository) {
        this.exceptieRepository = exceptieRepository;
    }

    public List<Exceptie> findAllExceptions(String natura) {
        if(natura != null && !natura.isEmpty()){
           return exceptieRepository.findByNaturaExceptieiCustom(natura);
        }
       return exceptieRepository.findAllCustom();
    }
}
