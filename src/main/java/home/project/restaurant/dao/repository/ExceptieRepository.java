package home.project.restaurant.dao.repository;

import home.project.restaurant.dao.entity.Exceptie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExceptieRepository extends JpaRepository<Exceptie, Integer> {

    @Query(value = "SELECT * FROM exceptii WHERE natura_exceptiei = :natura", nativeQuery = true)
    List<Exceptie> findByNaturaExceptieiCustom(@Param("natura") String natura);

    @Query(value = "SELECT * FROM exceptii ORDER BY nume ASC", nativeQuery = true)
    List<Exceptie> findAllCustom();

}
