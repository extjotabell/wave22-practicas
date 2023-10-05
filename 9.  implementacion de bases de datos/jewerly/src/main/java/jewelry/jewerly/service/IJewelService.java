package jewelry.jewerly.service;

import jewelry.jewerly.dto.JewelDto;
import jewelry.jewerly.model.Jewel;

import java.util.List;

public interface IJewelService {
    long createJewel(JewelDto jewel);
    List<JewelDto> getJewels();
    void deleteJewel(long id);
    void updateJewel(long id, JewelDto jewel);
}
