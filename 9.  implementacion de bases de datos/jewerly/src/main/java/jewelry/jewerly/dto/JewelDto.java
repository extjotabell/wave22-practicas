package jewelry.jewerly.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JewelDto {
    private String name;
    private String material;
    private long weight;
    private String particularity;
    private boolean hasStone;
    private boolean sellOrNot;
}
