package com.tbi.tbibase.controllers;

import com.tbi.tbibase.entities.JobStart;
import com.tbi.tbibase.entities.Well;
import com.tbi.tbibase.services.JobStartService;
import com.tbi.tbibase.services.WellService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {
    private WellService wellService;
    private JobStartService jobStartService;
    private ConfigurableApplicationContext context;

    public MainController(WellService wellService, JobStartService jobStartService, ConfigurableApplicationContext context) {
        this.wellService = wellService;
        this.jobStartService = jobStartService;
        this.context = context;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/well_editor/new_well")
    public String wellEditor(@ModelAttribute("well") Well well) {
        return "html/createNewWell";
    }

    @PostMapping("/well_editor/new_well")
    public String createWell(@ModelAttribute("well") Well well) {
        wellService.save(well);
        return "html/createNewWell";
    }


    @GetMapping("/job_editor/new_job")
    public String jobEditor(@ModelAttribute("jobStart") JobStart jobStart) {
        return "html/createNewJob";
    }

    @PostMapping("/job_editor/new_job")
    public String createJob(@ModelAttribute("jobStart") JobStart jobStart,
                            @RequestParam("well") String well) {
        jobStart.setWell(wellService.getWellByWell(well).get());
        jobStartService.save(jobStart);
        return "html/createNewJob";
    }
}
