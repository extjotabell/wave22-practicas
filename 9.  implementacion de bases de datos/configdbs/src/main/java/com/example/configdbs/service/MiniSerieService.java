package com.example.configdbs.service;

import com.example.configdbs.repository.MiniSerieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {
    private final MiniSerieRepository miniSerieRepository;

    public MiniSerieService(MiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }


}
