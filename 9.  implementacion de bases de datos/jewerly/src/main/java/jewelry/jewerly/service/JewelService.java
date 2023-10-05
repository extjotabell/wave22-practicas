package jewelry.jewerly.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jewelry.jewerly.dto.JewelDto;
import jewelry.jewerly.exception.IdNotExistsException;
import jewelry.jewerly.model.Jewel;
import jewelry.jewerly.repository.IJewelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService{

    private final IJewelRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    public JewelService(IJewelRepository repository) {
        this.repository = repository;
    }

    @Override
    public long createJewel(JewelDto jewel) {
        Jewel jewel1toSave = mapper.convertValue(jewel, Jewel.class);
        repository.save(jewel1toSave);
        return jewel1toSave.getId();
    }

    @Override
    public List<JewelDto> getJewels() {
        return repository.findAll().stream()
                .filter(Jewel::isSellOrNot)
                .map(j -> mapper.convertValue(j, JewelDto.class))
                .toList();
    }

    @Override
    public void deleteJewel(long id) {
        Jewel jewel = repository.findById(id).orElse(null);
        if(jewel == null){
            throw new IdNotExistsException("A jewel with that id does not exists");
        }
        jewel.setSellOrNot(false);
        repository.save(jewel);
    }

    @Override
    public void updateJewel(long id, JewelDto jewel) {
        Jewel jewelToUpdate = repository.findById(id).orElse(null);
        if(jewelToUpdate == null){
            throw new IdNotExistsException("A jewel with that id does not exists");
        }

        if(jewel.getName() != null){
            jewelToUpdate.setName(jewel.getName());
        }
        if(jewel.getMaterial() != null){
            jewelToUpdate.setMaterial(jewel.getMaterial());
        }
        if(jewel.getParticularity() != null){
            jewelToUpdate.setParticularity(jewel.getParticularity());
        }
        if(jewel.getWeight() > 0){
            jewelToUpdate.setWeight(jewel.getWeight());
        }
        jewelToUpdate.setHasStone(jewel.isHasStone());
        jewelToUpdate.setSellOrNot(jewel.isSellOrNot());
        repository.save(jewelToUpdate);
    }
}
