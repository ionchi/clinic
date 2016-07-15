package it.uniroma3.controller;

import it.uniroma3.form.ExamForm;
import it.uniroma3.service.DoctorService;
import it.uniroma3.service.ExamTypeService;
import it.uniroma3.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import it.uniroma3.model.Exam;
import it.uniroma3.service.ExamService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class ExamController extends WebMvcConfigurerAdapter{

	@Autowired
	private ExamService examService;

	@Autowired
	private ExamTypeService examTypeService;

	@Autowired
	private PatientService patientService;

	@Autowired
	private DoctorService doctorService;

	@ModelAttribute("exam")
	public Exam createExamModel() {
		return new Exam();
	}

	@RequestMapping(value = "/addexam", method = RequestMethod.GET)
	public String addExam(Model model) {
		model.addAttribute("examTypeList", examTypeService.listExamType());
		model.addAttribute("patientList", patientService.listPatient());
		model.addAttribute("doctorList", doctorService.listDoctor());
		model.addAttribute("examForm", new ExamForm());
		return "/addexam";
	}

//	@RequestMapping(value = "/exam", method =  RequestMethod.GET)
//	public String listExamPatient(Model model) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String username = authentication.getName();
//		model.addAttribute("examsList",	examService.listExamPatient(username));
//		return "exam";
//	}

	@RequestMapping(value = "/listexam", method =  RequestMethod.GET)
	public String listExam(Model model) {
		model.addAttribute("examsList",	examService.listExam());
		return "exam";
	}

	@RequestMapping(value = "/updateexam", method = RequestMethod.POST)
	public String updateExam(@RequestParam String type, @RequestParam String patient,
							 @RequestParam String doctor, @RequestParam String examDate,
							 @ModelAttribute("examForm") ExamForm examForm, Model model) {
		Exam exam = new Exam();
		exam.setPatient(patientService.findPatientById(Integer.valueOf(patient)));
		exam.setDoctor(doctorService.findDoctorById(Integer.valueOf(doctor)));
		exam.setType(examTypeService.findExamTypeById(Integer.valueOf(type)));
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Date date;
		try {
			date = df.parse(examDate);
			exam.setExamDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		examService.insertExam(exam);
		model.addAttribute("examsList",	examService.listExam());
		return "exam";
	}

	@RequestMapping(value = "/deleteE/{examId}", method = RequestMethod.GET)
	public String deleteExam(@PathVariable("examId") Integer examId, Model model) {
		this.examService.deleteExam(examId);
		model.addAttribute("examsList",	examService.listExam());
		return "exam";
	}

}
