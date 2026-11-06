package home.project.restaurant.service;

import home.project.restaurant.dao.entity.Categorie;
import home.project.restaurant.dao.service.CategorieServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatergorieService {

    private final CategorieServiceDAO categorieServiceDAO;

    @Autowired
    public CatergorieService(CategorieServiceDAO categorieServiceDAO) {
        this.categorieServiceDAO = categorieServiceDAO;
    }

    public Categorie save(Categorie categorie) {
        return categorieServiceDAO.save(categorie);
    }

    public List<Categorie> findAll() {
        return categorieServiceDAO.findAll();
    }

    public Categorie findById(Integer id) {
        return categorieServiceDAO.findById(id).orElse(null);
    }

    public void delete(Integer id){
        categorieServiceDAO.deleteById(id);
    }

}
