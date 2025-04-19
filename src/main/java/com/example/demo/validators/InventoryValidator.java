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
        //if(context==null) return true;
        //if(context!=null)myContext=context;
        //ProductService repo = myContext.getBean(ProductServiceImpl.class);
        if (part.getInv() > part.getMaxInv()) {
            //display error message when inventory > than max
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory Error: greater than max inventory").addConstraintViolation();
            return false;

            //Part myPart = repo.findById((int) part.getId());
            //for (Part p : myPart.getParts()) {
                //if (p.getInv()<(part.getInv()-myPart.getInv()))return false;
            //}
        }
        if (part.getInv() > part.getMinInv()) {
            //display error message when inventory > than min
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory Error: greater than min inventory").addConstraintViolation();
            return false;
        }
        return false;
    }
}
