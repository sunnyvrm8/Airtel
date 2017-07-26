package com.school.sangam.students.rest;

/**
 * Created by sunny on 26/07/17.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {
    @RequestMapping("/students")
    public String welcome() {
        return "welcome students";
    }

}
