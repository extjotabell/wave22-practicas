package salvo.nicolas.jewelry.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter @Setter
//@SQLDelete(sql = "UPDATE jewel SET sellable = false WHERE id=?")
//@Where(clause = "sellable=true")
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String material;
    private double weight;
    private String peculiarity;
    private boolean hasStone;
    private boolean sellable = true;
}
