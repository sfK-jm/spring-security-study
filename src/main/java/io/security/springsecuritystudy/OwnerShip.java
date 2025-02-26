package io.security.springsecuritystudy;

import org.springframework.security.access.prepost.PostAuthorize;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Retention(RUNTIME)
@Target({TYPE, METHOD})
@PostAuthorize("returnObject.owner == authentication.name")
public @interface OwnerShip {
}
