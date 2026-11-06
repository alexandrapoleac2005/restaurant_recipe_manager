package home.project.restaurant.dao.repository;

import home.project.restaurant.dao.entity.Reteta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RetetaRepository extends JpaRepository<Reteta, Integer> {

    @Query(value = "SELECT * FROM reteta WHERE vegetariana = 'D' ORDER BY timp_preparare DESC, nume", nativeQuery = true)
    List<Reteta> findVegetarianRecipesOrdered();

    @Query(value = "SELECT ret.nume, ret.descriere, cat.tip " +
            "FROM reteta ret JOIN categorie cat ON ret.categ_id = cat.categ_id " +
            "JOIN set_ingrediente si ON ret.reteta_id = si.reteta_id " +
            "JOIN ingredient ing ON ing.ingred_id = si.ingred_id " +
            "WHERE si.cantitate = 500 AND ing.ingredient = 'Ceapa' AND si.um = 'gr'",
            nativeQuery = true)
    List<Object[]> findRecipesWith500gCeapa();

    @Query(value = "SELECT nume, descriere, timp_preparare " +
            "FROM reteta " +
            "WHERE vegetariana = 'D' " +
            "AND timp_preparare >= ALL (SELECT timp_preparare FROM reteta WHERE vegetariana = 'D')",
            nativeQuery = true)
    List<Object[]> findVegetarianRecipesWithMaxTime();

    @Query(value = "SELECT cat.tip, MIN(ret.timp_preparare), MAX(ret.timp_preparare), AVG(ret.timp_preparare) " +
            "FROM reteta ret " +
            "JOIN categorie cat ON ret.categ_id = cat.categ_id " +
            "GROUP BY cat.tip", nativeQuery = true)
    List<Object[]> getPreparationTimeStatsPerType();

    @Query(value = "SELECT r.* FROM reteta r " +
            "JOIN set_ingrediente si ON r.reteta_id = si.reteta_id " +
            "JOIN ingredient i ON si.ingred_id = i.ingred_id " +
            "WHERE i.ingredient = 'usturoi' " +
            "AND si.cantitate > ( " +
            "    SELECT si2.cantitate " +
            "    FROM set_ingrediente si2 " +
            "    JOIN reteta r2 ON si2.reteta_id = r2.reteta_id " +
            "    JOIN ingredient i2 ON si2.ingred_id = i2.ingred_id " +
            "    WHERE r2.nume = 'Tocăniță de pui' " +
            "    AND i2.ingredient = 'usturoi' " +
            "    AND si2.um = 'buc' " +
            ")", nativeQuery = true)
    List<Reteta> findRecipesWithMoreGarlicThanChickenStew();
}
