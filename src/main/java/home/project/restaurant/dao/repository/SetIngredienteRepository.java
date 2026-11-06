package home.project.restaurant.dao.repository;

import home.project.restaurant.dao.entity.SetIngrediente;
import home.project.restaurant.dao.entity.SetIngredienteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SetIngredienteRepository extends JpaRepository<SetIngrediente, SetIngredienteId> {

    @Query(value = "SELECT si1.ingred_id AS id1, si2.ingred_id AS id2 " +
            "FROM set_ingrediente si1 JOIN set_ingrediente si2 " +
            "ON si1.cantitate = si2.cantitate AND si1.um = si2.um " +
            "AND si1.reteta_id != si2.reteta_id AND si1.ingred_id < si2.ingred_id", nativeQuery = true)
    List<Object[]> findIngredientPairs();

    @Query(value = "SELECT AVG(si.cantitate) " +
            "FROM set_ingrediente si " +
            "JOIN reteta r ON si.reteta_id = r.reteta_id " +
            "JOIN ingredient i ON si.ingred_id = i.ingred_id " +
            "WHERE LOWER(r.nume) LIKE '%toc%' " +
            "AND LOWER(i.ingredient) = 'usturoi'",
            nativeQuery = true)
    Double findAverageGarlicForTocRecipes();
}