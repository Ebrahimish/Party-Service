package com.example.usermonitoring.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NationalCodeValidator.class)
public @interface NationalCode {

    String message() default "کد ملی معتبر نیست";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}