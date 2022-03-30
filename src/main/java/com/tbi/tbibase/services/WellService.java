package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.Well;
import com.tbi.tbibase.repository.WellRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;

@Service
public class WellService {
    private WellRepository wellRepository;

    public WellService(WellRepository wellRepository) {
        this.wellRepository = wellRepository;
    }

    public Well createWell(){
        return new Well("URN", "U77", "7709", new Date(System.currentTimeMillis()),
                new Time(System.currentTimeMillis()),"AO \"Arkticgaz\"", "E:\\Documents\\U77");
    }

    public void save(Well well){
        wellRepository.save(well);
    }

    public void delete(Well well){
        wellRepository.delete(well);
    }
}
