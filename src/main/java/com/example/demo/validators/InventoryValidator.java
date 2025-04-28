package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        return constraintMin(part, constraintValidatorContext) && constraintMax(part, constraintValidatorContext);
    }

    public boolean constraintMin(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() < part.getMinInv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory must be greater than min.").addConstraintViolation();
            return false;
        }
        return true;
    }

    public boolean constraintMax(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() > part.getMaxInv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory must be less than max.").addConstraintViolation();
            return false;
        }
        return true;
    }
}
