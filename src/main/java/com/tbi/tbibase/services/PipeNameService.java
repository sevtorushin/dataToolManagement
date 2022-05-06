package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.PipeName;
import com.tbi.tbibase.repository.PipeNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PipeNameService {
    private PipeNameRepository pipeNameRepository;

    public PipeNameService(PipeNameRepository pipeNameRepository) {
        this.pipeNameRepository = pipeNameRepository;
    }

    public PipeName createPipeName(){
        return new PipeName("СИБ 2.1");
    }

    public List<PipeName> getAll(){return pipeNameRepository.findAll();}

    public void save(PipeName pipeName){
        pipeNameRepository.save(pipeName);
    }

    public void delete(PipeName pipeName) {
        pipeNameRepository.delete(pipeName);
    }
}
