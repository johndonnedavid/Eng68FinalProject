package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.entities.Trainee;
import com.sparta.eng68.traineetracker.entities.Trainer;
import com.sparta.eng68.traineetracker.services.TraineeService;
import com.sparta.eng68.traineetracker.services.TrainerService;
import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.Optional;

@Controller
public class TrainerHomeController {

    @GetMapping("/trainerHome")
    public String getTrainerHome(ModelMap modelMap) {
        return Pages.accessPage(Role.TRAINER, Pages.TRAINER_HOME);
    }

    @GetMapping("/newUser")
    public String newUserForm() {
        return Pages.accessPage(Role.TRAINER, Pages.TRAINER_NEW_USER_PAGE);
    }

}
