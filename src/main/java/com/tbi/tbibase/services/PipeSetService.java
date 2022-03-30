package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.PipeName;
import com.tbi.tbibase.entities.PipeSet;
import com.tbi.tbibase.repository.PipeNameRepository;
import com.tbi.tbibase.repository.PipeSetRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class PipeSetService {
    private PipeNameRepository pipeNameRepository;
    private PipeSetRepository pipeSetRepository;

    public PipeSetService(PipeNameRepository pipeNameRepository, PipeSetRepository pipeSetRepository) {
        this.pipeNameRepository = pipeNameRepository;
        this.pipeSetRepository = pipeSetRepository;
    }

    public PipeSet createPipeSet(Long pipeId, String serialNumber){
        PipeName pipeName = pipeNameRepository.getById(pipeId);
        return new PipeSet(serialNumber, new Time(System.currentTimeMillis()),
                "норма", pipeName);
    }

    public void save(PipeSet pipeSet){
        pipeSetRepository.save(pipeSet);
    }

    public void delete(PipeSet pipeSet){
        pipeSetRepository.delete(pipeSet);
    }

    public PipeSet getById (long id){
        return pipeSetRepository.getById(id);
    }
}
