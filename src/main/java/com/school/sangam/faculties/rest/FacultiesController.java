package com.school.sangam.faculties.rest;

/**
 * Created by sunny on 26/07/17.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacultiesController {
    @RequestMapping("/faculties")
    public String welcome() {
        return "welcome faculties";
    }

}
