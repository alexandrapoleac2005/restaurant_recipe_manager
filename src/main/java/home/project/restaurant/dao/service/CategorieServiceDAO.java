package home.project.restaurant.dao.service;

import home.project.restaurant.dao.entity.Categorie;
import home.project.restaurant.dao.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceDAO {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieServiceDAO(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> findAll() {
        return this.categorieRepository.findAll();
    }

    public Categorie save(Categorie categorie) {
        return this.categorieRepository.save(categorie);
    }

    public Optional<Categorie> findById(Integer id) {
        return this.categorieRepository.findById(id);
    }

    public void deleteById(Integer id) {
        categorieRepository.deleteById(id);
    }
}
