package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.Well;
import com.tbi.tbibase.repository.WellRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WellService {
    private final WellRepository wellRepository;

    public WellService(WellRepository wellRepository) {
        this.wellRepository = wellRepository;
    }

    public void save(Well well){
        wellRepository.save(well);
    }

    public void delete(Well well){
        wellRepository.delete(well);
    }

    public Optional<Well> getById(long id){
        return wellRepository.findById(id);
    }

    public Optional<Well> getWellByWellNumber(String well){
        return wellRepository.getWellByWellNumber(well);
    }
}
