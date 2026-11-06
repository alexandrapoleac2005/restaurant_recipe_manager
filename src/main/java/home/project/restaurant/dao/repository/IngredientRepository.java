package home.project.restaurant.dao.repository;

import home.project.restaurant.dao.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    @Query(value = "SELECT * FROM ingredient WHERE LOWER(ingredient) LIKE '%e%' ORDER BY ingredient", nativeQuery = true)
    List<Ingredient> findIngredientsWithE();

}
