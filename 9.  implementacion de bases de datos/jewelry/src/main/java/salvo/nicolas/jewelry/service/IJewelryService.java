package salvo.nicolas.jewelry.service;

import org.springframework.transaction.annotation.Transactional;
import salvo.nicolas.jewelry.dto.JewelDTO;

import java.util.List;

public interface IJewelryService {

    Long create(JewelDTO jewelDTO);

    List<JewelDTO> getAll();

    JewelDTO getById(Long id);

    Long deleteById(Long id);

//    JewelDTO updateById(Long id, JewelDTO updatedJewel);
}
