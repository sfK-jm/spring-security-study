package io.security.springsecuritystudy;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {


    @GetMapping("/")
    public Authentication index(Authentication authentication) {
        return authentication;
    }

}
