package joyeriaCRUD.joyeriaCRUD.service;

import joyeriaCRUD.joyeriaCRUD.dto.JoyaDto;
import joyeriaCRUD.joyeriaCRUD.entity.Joya;

import java.util.List;

public interface JoyaService {
    public List<JoyaDto> getJoyas();
    public Long saveJoya(JoyaDto joya);
    public void deleteJoya(long id);
    public Joya findById (long id);
    public JoyaDto update(long id, JoyaDto joya);

}
