package jewelry.jewerly.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String material;
    private long weight;
    private String particularity;
    @Column(name = "has_stone")
    private boolean hasStone;
    @Column(name = "sell_or_not")
    private boolean sellOrNot;
}
