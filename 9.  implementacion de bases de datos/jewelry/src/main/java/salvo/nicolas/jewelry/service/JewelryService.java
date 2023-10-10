package salvo.nicolas.jewelry.service;

import org.springframework.transaction.annotation.Transactional;
import salvo.nicolas.jewelry.dto.JewelDTO;
import salvo.nicolas.jewelry.entity.Jewel;
import salvo.nicolas.jewelry.exception.NotFoundException;
import salvo.nicolas.jewelry.repository.IJewerlryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salvo.nicolas.jewelry.util.Util;

import java.util.List;
import java.util.Optional;

@Service
public class JewelryService implements IJewelryService {

    @Autowired
    IJewerlryRepository jewelryRepository;

    @Override
    @Transactional
    public Long create(JewelDTO jewelDTO) {
        Jewel jewel = Util.mapper.convertValue(jewelDTO, Jewel.class);
        return jewelryRepository.save(jewel).getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<JewelDTO> getAll(boolean showDeleted) {
        List<Jewel> jewels = jewelryRepository.findAll();
        if (showDeleted) {
            return jewels.stream().map(jewel -> Util.mapper.convertValue(jewel, JewelDTO.class)).toList();
        }
        return jewels.stream().map(jewel -> Util.mapper.convertValue(jewel, JewelDTO.class)).filter(JewelDTO::isSellable).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public JewelDTO getById(Long id) {
        Optional<Jewel> foundJewel = jewelryRepository.findById(id);
        if (foundJewel.isPresent()) {
            return Util.mapper.convertValue(foundJewel, JewelDTO.class);
        }
        throw new NotFoundException("No se encontró la joya con id: " + id);
    }

// This one only work if overwritting behaviour of SQL DELETE statement on Jewel entity
//    @Override
//    @Transactional
//    public Long deleteById(Long id) {
//        Optional<Jewel> foundJewel = jewelryRepository.findById(id);
//        if (foundJewel.isPresent()) {
//            jewelryRepository.deleteById(id);
//            return id;
//        }
//        throw new NotFoundException("No se encontró la joya con id: " + id);
//    }

    @Override
    @Transactional
    public Long deleteById(Long id) {
        Optional<Jewel> foundJewel = jewelryRepository.findById(id);
        if (foundJewel.isPresent()) {
            foundJewel.get().setSellable(false);
            return jewelryRepository.save(foundJewel.get()).getId();
        }
        throw new NotFoundException("No se encontró la joya con id: " + id);
    }

    @Override
    @Transactional
    public JewelDTO updateById(Long id, JewelDTO updatedJewel) {
        Optional<Jewel> foundJewel = jewelryRepository.findById(id);
        if (foundJewel.isPresent()) {
            Jewel jewel = Util.mapper.convertValue(updatedJewel, Jewel.class);
            jewel.setId(id);
            jewelryRepository.save(jewel);
            return updatedJewel;
        }
        throw new NotFoundException("No se encontró la joya con id: " + id);
    }
}