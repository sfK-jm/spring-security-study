package io.sfk.cors2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class indexController {

    @GetMapping("/users")
    public String users() {
        return "{\"name\":\"hong gil dong\"}";
    }
}
