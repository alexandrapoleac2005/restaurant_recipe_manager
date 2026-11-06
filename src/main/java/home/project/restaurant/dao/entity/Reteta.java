package home.project.restaurant.dao.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "reteta")
public class Reteta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reteta_id")
    private Integer id;

    @Column(name = "nume", nullable = false, length = 100)
    private String nume;

    @Lob
    @Column(name = "descriere", columnDefinition = "TEXT")
    private String descriere;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categ_id", nullable = false)
    private Categorie categorie;

    @Column(name = "vegetariana", length = 1)
    private Character vegetariana;

    @Column(name = "timp_preparare")
    private Integer timpPreparare;

    @Column(name = "portii")
    private Integer portii;

    @Column(name = "autor", length = 100)
    private String autor;
}