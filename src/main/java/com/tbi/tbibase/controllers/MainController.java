package com.tbi.tbibase.controllers;

import com.tbi.tbibase.entities.JobStart;
import com.tbi.tbibase.entities.Pipe;
import com.tbi.tbibase.entities.Well;
import com.tbi.tbibase.services.JobStartService;
import com.tbi.tbibase.services.PipeNameService;
import com.tbi.tbibase.services.PipeService;
import com.tbi.tbibase.services.WellService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {
    private final WellService wellService;
    private final JobStartService jobStartService;
    private final PipeService pipeService;
    private final PipeNameService pipeNameService;

    public MainController(WellService wellService, JobStartService jobStartService, PipeService pipeService, PipeNameService pipeNameService) {
        this.wellService = wellService;
        this.jobStartService = jobStartService;
        this.pipeService = pipeService;
        this.pipeNameService = pipeNameService;
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
    public String jobEditor(@ModelAttribute("jobStart") JobStart jobStart,
                            Model model) {
        model.addAttribute("listPipeName", pipeNameService.getAll());
        model.addAttribute("listPipeSet", pipeService.getAll());
        return "html/createNewJob";
    }

    @PostMapping("/job_editor/new_job")
    public String createJob(@ModelAttribute("jobStart") JobStart jobStart,
                            @RequestParam("well-number") String wellNumber) {
        jobStartService.save(jobStart, wellNumber);
        return "html/createNewJob";
    }

    @GetMapping("/tools/all")
    public String toolsSet(Model model) {
        List<Pipe> insulators = new ArrayList<>(pipeService.getPipeByPipeName(1L));
        insulators.addAll(pipeService.getPipeByPipeName(2L));
        model.addAttribute("insulators", insulators);
        model.addAttribute("nonMagPipe_solid", pipeService.getPipeByPipeName(3L));
        model.addAttribute("nonMagPipe_flex", pipeService.getPipeByPipeName(4L));
        model.addAttribute("sub", pipeService.getPipeByPipeName(5L));
        return "html/toolsSet";
    }
}
