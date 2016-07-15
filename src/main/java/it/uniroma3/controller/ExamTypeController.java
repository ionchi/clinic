package it.uniroma3.controller;

import it.uniroma3.form.PrerequisiteForm;
import it.uniroma3.model.Indicator;
import it.uniroma3.model.Prerequisite;
import it.uniroma3.service.IndicatorService;
import it.uniroma3.service.PrerequisiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import it.uniroma3.model.ExamType;
import it.uniroma3.service.ExamTypeService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ExamTypeController extends WebMvcConfigurerAdapter {

    @Autowired
    private ExamTypeService examTypeService;

    @Autowired
    private PrerequisiteService prerequisiteService;

    @Autowired
    private IndicatorService indicatorService;

    @Autowired
    @Qualifier("examTypeValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @ModelAttribute("examtype")
    public ExamType createExamTypeModel() {
        return new ExamType();
    }

    /* Pensato per una pagina con una lista di prerequisiti tutti insieme,
        attualmente non viene sfruttato - prerequisiti aggiunti uno per uno
     */
    @ModelAttribute("prerequisiteForm")
    public PrerequisiteForm populatePrerequisite() {
        PrerequisiteForm prerequisiteForm = new PrerequisiteForm();
        List<Prerequisite> prerequisites = new ArrayList<>();
        prerequisites.add(new Prerequisite());
        prerequisiteForm.setPrerequisites(prerequisites);
        return prerequisiteForm;
    }

    @RequestMapping(value = "/addexamtype", method = RequestMethod.GET)
    public String addExamType() {
        return "/addexamtype";
    }

    @RequestMapping(value = "/listexamtype", method =  RequestMethod.GET)
    public String listExamType(Model model) {
        model.addAttribute("examsTypeList",	examTypeService.listExamType());
        return "examtype";
    }

    @RequestMapping(value = "/updateexamtype", method = RequestMethod.POST)
    public String updateExamType(@ModelAttribute("examtype") @Validated ExamType examType, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "addexamtype";
        this.examTypeService.insertExamType(examType);
        model.addAttribute("examsTypeList",	examTypeService.listExamType());
        return "examtype";
    }

    @RequestMapping(value = "/deleteT/{examTypeId}", method = RequestMethod.GET)
    public String deleteExamType(@PathVariable("examTypeId") Integer examTypeId, Model model) {
        this.examTypeService.deleteExamType(examTypeId);
        model.addAttribute("examsTypeList",	examTypeService.listExamType());
        return "examtype";
    }

    @RequestMapping(value = "/addprerequisite/{examTypeId}", method = RequestMethod.GET)
    public String addPrerequisite(@PathVariable("examTypeId") Integer examTypeId, Model model) {
        model.addAttribute("examTypeId", examTypeId);
        model.addAttribute("examType", this.examTypeService.findExamTypeById(examTypeId));
        return "addprerequiste";
    }

    @RequestMapping(value = "/updateprerequisites/{examTypeId}", method = RequestMethod.POST)
    public String updatePrerequisite(@ModelAttribute("prerequisiteForm") PrerequisiteForm prerequisiteForm,
            @PathVariable("examTypeId") Integer examTypeId, Model model) {
        List<Prerequisite> prerequisites = prerequisiteForm.getPrerequisites();
        this.examTypeService.updateExamTypePrerequisites(examTypeId, prerequisites);
        model.addAttribute("success","Prerequisito aggiunto!");
        model.addAttribute("examsTypeList",	examTypeService.listExamType());
        return "addprerequiste";
    }

    @RequestMapping(value = "/prerequisite/{examTypeId}", method = RequestMethod.GET)
    public String listPrerequisite(@PathVariable("examTypeId") Integer examTypeId, Model model) {
        model.addAttribute("examtype", examTypeService.findExamTypeById(examTypeId));
        model.addAttribute("prerequisteList", this.prerequisiteService.listPrerequisiteForType(examTypeId));
        return "prerequisite";
    }

    @RequestMapping(value = "/deletePre/{examTypeId}/{preId}", method = RequestMethod.GET)
    public String deletePrerequisite(@PathVariable("examTypeId") Integer examTypeId,
                                     @PathVariable("preId") Integer preId, Model model) {
        this.prerequisiteService.deletePrerequisite(preId);
        model.addAttribute("examTypeId", examTypeId);
        model.addAttribute("prerequisteList", this.prerequisiteService.listPrerequisiteForType(examTypeId));
        return "prerequisite";
    }

    @RequestMapping(value = "/addindicator/{examTypeId}", method = RequestMethod.GET)
    public String addIndicator(@PathVariable("examTypeId") Integer examTypeId, Model model) {
        model.addAttribute("examTypeId", examTypeId);
        model.addAttribute("examType", this.examTypeService.findExamTypeById(examTypeId));
        return "addindicator";
    }

    @RequestMapping(value = "/updateindicator/{examTypeId}", method = RequestMethod.POST)
    public String updateIndicator(@RequestParam("name") String name,
                                     @PathVariable("examTypeId") Integer examTypeId, Model model) {
        Indicator indicator = new Indicator();
        indicator.setName(name);
        this.examTypeService.updateExamTypeIndicator(examTypeId, indicator);
        model.addAttribute("success","Indicatore aggiunto!");
        return "addindicator";
    }

    @RequestMapping(value = "/indicator/{examTypeId}", method = RequestMethod.GET)
    public String listIndicator(@PathVariable("examTypeId") Integer examTypeId, Model model) {
        model.addAttribute("examtype", examTypeService.findExamTypeById(examTypeId));
        model.addAttribute("indicatorList", this.indicatorService.listIndicatorForType(examTypeId));
        return "indicator";
    }

    @RequestMapping(value = "/deleteInd/{examTypeId}/{indId}", method = RequestMethod.GET)
    public String deleteIndicator(@PathVariable("examTypeId") Integer examTypeId,
                                     @PathVariable("indId") Integer indId, Model model) {
        this.indicatorService.deleteIndicator(indId);
        model.addAttribute("examTypeId", examTypeId);
        model.addAttribute("indicatorList", this.indicatorService.listIndicatorForType(examTypeId));
        return "indicator";
    }
}
