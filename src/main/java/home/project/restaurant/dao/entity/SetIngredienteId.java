package home.project.restaurant.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SetIngredienteId implements Serializable {
    private static final long serialVersionUID = 8365103310549340104L;
    @Column(name = "reteta_id", nullable = false)
    private Integer retetaId;

    @Column(name = "ingred_id", nullable = false)
    private Integer ingredId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SetIngredienteId entity = (SetIngredienteId) o;
        return Objects.equals(this.ingredId, entity.ingredId) &&
                Objects.equals(this.retetaId, entity.retetaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredId, retetaId);
    }

}