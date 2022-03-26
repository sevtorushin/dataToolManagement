package com.tbi.tbibase.services;

import com.tbi.tbibase.entities.Well;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;

@Service
public class WellService {

    public Well createWell(){
        return new Well("field", "pad", "well", new Date(System.currentTimeMillis()),
                new Time(System.currentTimeMillis()),"customer", "directory");
    }
}
