package home.project.restaurant.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table (name = "exceptii")
public class Exceptie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reteta_id")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nume;

    @Column(columnDefinition = "TEXT")
    private String descriere;

    @Column(name = "categ_id", nullable = false)
    private Integer categId;

    @Column(length = 1)
    private String vegetariana;

    @Column(name = "timp_preparare")
    private Integer timpPreparare;

    private Integer portii;

    @Column(length = 100)
    private String autor;

    @Column(name = "natura_exceptiei", length = 50)
    private String naturaExceptiei;

}
