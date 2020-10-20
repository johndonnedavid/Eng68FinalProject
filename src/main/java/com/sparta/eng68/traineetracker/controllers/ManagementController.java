package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.entities.CourseGroup;
import com.sparta.eng68.traineetracker.entities.Trainee;
import com.sparta.eng68.traineetracker.services.CourseGroupService;
import com.sparta.eng68.traineetracker.services.CourseService;
import com.sparta.eng68.traineetracker.services.TraineeService;
import com.sparta.eng68.traineetracker.utilities.AssignGroupForm;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagementController {

    public final TraineeService traineeService;
    public final CourseGroupService courseGroupService;
    public final CourseService courseService;

    @Autowired
    public ManagementController(TraineeService traineeService, CourseGroupService courseGroupService, CourseService courseService) {
        this.traineeService = traineeService;
        this.courseGroupService = courseGroupService;
        this.courseService = courseService;
    }

    @GetMapping("/groups")
    public String getTrainerGroupView(Model model) {
        model.addAttribute("assignGroupForm", new AssignGroupForm());
        model.addAttribute("allTrainees", traineeService.getAllTrainees());
        model.addAttribute("allGroups", courseGroupService.getAllCourseGroups());
        model.addAttribute("allCourses", courseService.getAllCourses());
        model.addAttribute("newClass", new CourseGroup());
        return Pages.accessPage(Role.TRAINER, Pages.GROUPS);
    }

    @PostMapping("/createGroup")
    public ModelAndView createGroup(@ModelAttribute CourseGroup newClass, ModelMap model) {
        courseGroupService.saveNewGroup(newClass);
        return new ModelAndView("redirect:"+Pages.accessPage(Role.TRAINER, "/groups"));
    }


    @PostMapping("/submitGroupChange")
    public ModelAndView postGroupChange(@ModelAttribute AssignGroupForm assignGroupForm, ModelMap model) {

        Trainee trainee = traineeService.changeTraineeCourseGroupByID(assignGroupForm.getTraineeId(), assignGroupForm.getGroupId());
        model.addAttribute("trainee", trainee);
        model.addAttribute("group", courseGroupService.getGroupByID(trainee.getGroupId()).get());
        return new ModelAndView(Pages.accessPage(Role.TRAINER, Pages.GROUPS_SUBMIT_CHANGE));
    }


}
