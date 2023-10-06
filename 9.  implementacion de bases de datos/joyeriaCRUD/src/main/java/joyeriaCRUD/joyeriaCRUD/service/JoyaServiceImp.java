package joyeriaCRUD.joyeriaCRUD.service;

import joyeriaCRUD.joyeriaCRUD.dto.JoyaDto;
import joyeriaCRUD.joyeriaCRUD.entity.Joya;
import joyeriaCRUD.joyeriaCRUD.repository.JoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoyaServiceImp implements JoyaService {

    private final JoyaRepository joyaRepo;

    public JoyaServiceImp(JoyaRepository joyaRepo) {
        this.joyaRepo = joyaRepo;
    }

    @Override
    @Transactional (readOnly = true)
    public List<JoyaDto> getJoyas() {
        List<Joya> joyas = joyaRepo.findAll();
        List<Joya> joyasVenta = joyas.stream().filter(j -> j.isVentaONo() == true).toList();
        List<JoyaDto> response = joyasVenta.stream().map(j-> new JoyaDto(j.getNombre(),j.getMaterial(),j.getPeso(),j.getParticularidades(),j.isPoseePiedra(),j.isVentaONo())).toList();
        return response;
    }

    @Override
    @Transactional
    public Long saveJoya(JoyaDto joya) {
        Joya newJoya = new Joya(joya.getNombre(),joya.getMaterial(),joya.getPeso(),joya.getParticularidades(),joya.isPoseePiedra(),joya.isVentaONo());
        Joya saveJoya = joyaRepo.save(newJoya);
        return saveJoya.getId();
    }

    @Override
    public void deleteJoya(long id) {
        Joya joya = findById(id);
        if(joya.isVentaONo() == true){joya.setVentaONo(false);}
        joyaRepo.save(joya);
    }

    @Override
    public Joya findById(long id) {
        return joyaRepo.findById(id).orElse(null);
    }

    @Override
    public JoyaDto update(long id, JoyaDto joya) {
        Joya newJoya = findById(id);
        newJoya.setNombre(joya.getNombre());
        newJoya.setMaterial(joya.getMaterial());
        newJoya.setPeso(joya.getPeso());
        newJoya.setParticularidades(joya.getParticularidades());
        newJoya.setPoseePiedra(joya.isPoseePiedra());
        joyaRepo.save(newJoya);
        return new JoyaDto(newJoya.getNombre(), newJoya.getMaterial(), newJoya.getPeso(), newJoya.getParticularidades(), newJoya.isPoseePiedra(), newJoya.isVentaONo());
    }

}
