package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.PipeName;
import com.tbi.tbibase.entities.Pipe;
import com.tbi.tbibase.repository.PipeNameRepository;
import com.tbi.tbibase.repository.PipeRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class PipeService {
    private PipeNameRepository pipeNameRepository;
    private PipeRepository pipeRepository;

    public PipeService(PipeNameRepository pipeNameRepository, PipeRepository pipeRepository) {
        this.pipeNameRepository = pipeNameRepository;
        this.pipeRepository = pipeRepository;
    }

    public Pipe createPipeSet(Long pipeId, String serialNumber){
        PipeName pipeName = pipeNameRepository.getById(pipeId);
        return new Pipe(serialNumber, new Time(System.currentTimeMillis()),
                "норма", pipeName);
    }

    public void save(Pipe pipe){
        pipeRepository.save(pipe);
    }

    public List<Pipe> getAll(){return pipeRepository.findAll();}

    public void delete(Pipe pipe){
        pipeRepository.delete(pipe);
    }

    public Optional<Pipe> getById (long id){
        return pipeRepository.findById(id);
    }

    public void deleteAll(){
        pipeNameRepository.deleteAll();
    }

    public List<Pipe> getPipeByPipeName(Long pipe_nameId){
        return pipeRepository.getPipeByPipeName(pipeNameRepository.getById(pipe_nameId));
    }
}
