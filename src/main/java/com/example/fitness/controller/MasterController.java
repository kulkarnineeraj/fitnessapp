package com.example.fitness.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.fitness.model.Area;
import com.example.fitness.model.Enquiry;
import com.example.fitness.model.Expense;
import com.example.fitness.model.Meeting;
import com.example.fitness.model.Program;
import com.example.fitness.service.AreaService;
import com.example.fitness.service.EnquiryService;
import com.example.fitness.service.ExpenseService;
import com.example.fitness.service.MeetingService;
import com.example.fitness.service.ProgramService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MasterController {

    @Autowired
    private EnquiryService enquiryService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private ProgramService programService;

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private MeetingService meetingservice;

    // admin home controller which directs to main page
    @RequestMapping("/")
    public String allEnquiries(Model model) {
        List<Enquiry> enquiries = enquiryService.findAll();
        model.addAttribute("enquiries", enquiries);
        return "adminHome";
    }

    // add expense controller
    @RequestMapping("/addExpense")
    public ModelAndView addExpense(Model model) {
        ModelAndView mav = new ModelAndView("expense");
        mav.addObject("expense", new Expense());
        return mav;
    }

    @GetMapping("/addEnquiry")
    public String showAddEnquiryForm(Model model) {
        List<Area> areas = areaService.findAll();
        List<Program> programs = programService.findAll();
        model.addAttribute("areas", areas);
        model.addAttribute("programs", programs);
        model.addAttribute("enquiry", new Enquiry());
        return "addEnquiry";
    }

    @PostMapping("/enquiry")
    public String saveEnquiry(@ModelAttribute("enquiry") Enquiry enquiry) {
        enquiryService.save(enquiry);
        return "redirect:/";
    }

    @GetMapping("/editEnquiry/{id}")
    public String editEnquiry(@PathVariable("id") long id, Model model) {
        Enquiry enquiry = enquiryService.findById(id);
        List<Area> areas = areaService.findAll();
        List<Program> programs = programService.findAll();
        model.addAttribute("areas", areas);
        model.addAttribute("programs", programs);
        model.addAttribute("enquiry", enquiry);
        return "editEnquiry";
    }

    @PostMapping("/updateEnquiry")
    public String updateEnquiry(@ModelAttribute("enquiry") Enquiry enquiry, HttpSession session) {
        enquiryService.save(enquiry);
        session.setAttribute("mssg", "data updated");
        return "redirect:/";
    }

    @GetMapping("/deleteEnquiry/{id}")
    public String deleteEnquiry(@PathVariable("id") long id) {
        enquiryService.delete(id);
        return "redirect:/";
    }

    // @GetMapping("/addArea")
    // public String showAddAreaForm(Model model) {
    // model.addAttribute("area", new Area());
    // return "addArea"; // Template for adding an area
    // }

    // Area controllers
    @GetMapping("/addArea")
    public String showAddAreaForm(Model model) {
        List<Area> areas = areaService.findAll();
        model.addAttribute("area", new Area());
        model.addAttribute("areas", areas);
        return "addArea";
    }

    @GetMapping("/deleteArea/{idofarea}")
    public String deleteArea(@PathVariable("idofarea") Long idofarea) {
        areaService.delete(idofarea);
        return "redirect:/";
    }

    @PostMapping("/area")
    public String saveArea(@ModelAttribute("area") Area area, Model model) {
        areaService.save(area);
        List<Area> areas = areaService.findAll();
        model.addAttribute("areas", areas);
        return "addArea";
    }

    // program controllers
    @GetMapping("/addProgram")
    public String showAddProgramForm(Model model) {
        List<Program> programs = programService.findAll();
        model.addAttribute("program", new Program());
        model.addAttribute("programs", programs);
        return "addProgram";
    }

    @PostMapping("/program")
    public String saveProgram(@ModelAttribute("program") Program program, Model model) {
        programService.save(program);
        List<Program> programs = programService.findAll();
        model.addAttribute("programs", programs);
        return "addProgram";
    }

    @GetMapping("/deleteProgram/{idofprog}")
    public String deleteProgram(@PathVariable("idofprog") Long idofprog) {
        programService.delete(idofprog);
        return "redirect:/";
    }

    // eXPENSE CONTROLLER STARTS HERE

    @GetMapping("/expenseList")
    public String home(Model model) {
        List<Expense> expenses = expenseService.findAll();
        model.addAttribute("expenses", expenses);
        return "home";
    }

    @GetMapping("/expense")
    public String showAddExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "expense";
    }

    @PostMapping(value = "/expenses")
    public String save(@ModelAttribute("expense") Expense expense, Model model) {
        expenseService.save(expense);
        List<Expense> expenses = expenseService.findAll();
        model.addAttribute("expenses", expenses);
        return "home";//
    }

    @GetMapping(value = "/expense/{id}/delete")
    public String delete(@PathVariable("id") Long id, Model model) {
        expenseService.delete(id);
        List<Expense> expenses = expenseService.findAll();
        model.addAttribute("expenses", expenses);
        return "home";
    }

    @GetMapping("/expense/edit/{id}")
    public String editExpense(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findById(id);
        model.addAttribute("expense", expense);
        return "editExpense"; // Make sure this matches your editExpense.html template name

    }

    @PostMapping("/expense/update")
    public String update(@ModelAttribute("expense") Expense expense, Model model) {
        expenseService.save(expense);
        List<Expense> expenses = expenseService.findAll();
        model.addAttribute("expenses", expenses);
        return "home"; // Redirect to a home or success page after updating
    }

    @GetMapping("/adminHome")
    public String adminHome(HttpServletRequest request, Model model) {
        List<Enquiry> enquiries = enquiryService.findAll();
        model.addAttribute("enquiries", enquiries);
        return "adminHome";

    }

    // meeting controllers

    // @GetMapping("/addMeeting")
    // public String showAddMeetingForm(Model model) {
    // List<Program> programs = programService.findAll();
    // model.addAttribute("program", new Program());
    // model.addAttribute("programs", programs);
    // return "addMeeting";
    // }

    // @PostMapping("/meeting")
    // public String saveMeeting(@ModelAttribute("program") Program program, Model
    // model) {
    // programService.save(program);
    // List<Program> programs = programService.findAll();
    // model.addAttribute("programs", programs);
    // return "addmeeting";
    // }

    // @GetMapping("/deleteMeeting/{id}")
    // public String deleteMeeting(@PathVariable("id") Long id) {
    // programService.delete(id);
    // return "redirect:/";
    // }
    @GetMapping("/addMeeting")
    public String addMeeting(Model model) {
        model.addAttribute("meeting", new Meeting());
        return "addMeeting";
    }

    @PostMapping("/meeting")
    public String saveMeeting(@ModelAttribute("meeting") Meeting meeting, Model model) {
        meetingservice.save(meeting);
        List<Meeting> meetings = meetingservice.findAll();
        model.addAttribute("meetings", meetings);
        return "meetingList";
    }

    @GetMapping("/editMeeting/{id}")
    public String editMeeting(@PathVariable("id") Long id, Model model) {
        Meeting meeting = meetingservice.findById(id);
        model.addAttribute("meeting", meeting);
        return "editMeeting";
    }

    @PostMapping("/updateMeeting")
    public String updateMeeting(@PathVariable("meeting") Meeting meeting) {
        meetingservice.save(meeting);
        return "meetingList";
    }

    @GetMapping("/deleteMeeting/{id}")
    public String deleteMeeting(@PathVariable("id") Long id, Model model) {
        meetingservice.delete(id);
        List<Meeting> meetings = meetingservice.findAll();
        model.addAttribute("meetings", meetings);
        return "meetingList";
    }

    @RequestMapping("/meetingList")
    public String meetingList(Model model) {
        List<Meeting> meetings = meetingservice.findAll();
        model.addAttribute("meetings", meetings);
        return "meetingList";
    }
}
