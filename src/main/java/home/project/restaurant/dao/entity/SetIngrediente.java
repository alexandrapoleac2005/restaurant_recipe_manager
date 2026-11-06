package home.project.restaurant.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "set_ingrediente")
public class SetIngrediente {
    @EmbeddedId
    private SetIngredienteId id;

    @MapsId("retetaId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reteta_id", nullable = false)
    private Reteta reteta;

    @MapsId("ingredId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingred_id", nullable = false)
    private Ingredient ingred;

    @Column(name = "cantitate", precision = 10, scale = 2)
    private BigDecimal cantitate;

    @Column(name = "um", length = 10)
    private String um;

    @Column(name = "comentarii")
    private String comentarii;

}