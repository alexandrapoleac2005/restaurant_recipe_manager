package home.project.restaurant.dao.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categ_id")
    private Integer id;

    @Column(name = "tip", nullable = false, length = 50, unique = true)
    private String tip;

    @OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
    private List<Reteta> retete;
}