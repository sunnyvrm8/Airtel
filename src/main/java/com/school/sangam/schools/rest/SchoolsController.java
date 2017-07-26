package com.school.sangam.schools.rest;

/**
 * Created by sunny on 26/07/17.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolsController {
    @RequestMapping("/schools")
    public String welcome() {
        return "welcome schools";
    }

}
