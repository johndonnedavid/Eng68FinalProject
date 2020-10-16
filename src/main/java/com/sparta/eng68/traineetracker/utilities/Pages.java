package com.sparta.eng68.traineetracker.utilities;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class Pages {

    //LOGIN =========================================================================================
    public static final String HOME_PAGE = "/home";
    public static final String LOGIN_PAGE = "/login/login";
    public static final String FIRST_PASSWORD_PAGE = "/trainee/firstTimeLogin";
    public static final String LOGOUT_CURRENT_USER = "/perform_logout";

    //TRAINEE =======================================================================================
    public static final String TRAINEE_HOME = "/trainee/traineeHome";

    //TRAINER =======================================================================================
    public static final String TRAINER_HOME = "/trainer/trainerHome";

    //ERROR =========================================================================================
    public static final String ACCESS_ERROR = "/errors/accessError";

    public static String accessPage(String requiredRole, String page) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        if (request.isUserInRole(requiredRole) || requiredRole.equals(Role.ANY)) {
            return page;
        } else {
            return ACCESS_ERROR;
        }
    }

}