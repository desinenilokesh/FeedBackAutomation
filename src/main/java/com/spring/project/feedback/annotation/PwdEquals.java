/*package com.spring.project.feedback.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { PasswordValidator1.class })
public @interface PwdEquals {
	String message();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
*/