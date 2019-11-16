package com.gdn.oxford.auth.validation.annotation.user;

import com.gdn.oxford.auth.validation.validator.user.UserIdMustExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserIdMustExistsValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserIdMustExists {

  Class<?>[] groups() default {};

  String message() default "MustExists";

  Class<? extends Payload>[] payload() default {};
}
