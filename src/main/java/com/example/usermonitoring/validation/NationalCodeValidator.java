package com.example.usermonitoring.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NationalCodeValidator
        implements ConstraintValidator<NationalCode, String> {

    @Override
    public boolean isValid(
            String nationalCode,
            ConstraintValidatorContext context) {

        if (nationalCode == null ||
                !nationalCode.matches("\\d{10}")) {
            return false;
        }

        // جلوگیری از کدهایی مثل 1111111111
        if (nationalCode.matches("(\\d)\\1{9}")) {
            return false;
        }

        int sum = 0;

        for (int i = 0; i < 9; i++) {

            int digit =
                    Character.getNumericValue(
                            nationalCode.charAt(i));

            sum += digit * (10 - i);
        }

        int remainder = sum % 11;

        int checkDigit =
                Character.getNumericValue(
                        nationalCode.charAt(9));

        if (remainder < 2) {
            return checkDigit == remainder;
        }

        return checkDigit == 11 - remainder;
    }
}