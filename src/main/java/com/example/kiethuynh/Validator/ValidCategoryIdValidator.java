package com.example.kiethuynh.Validator;
import com.example.kiethuynh.Validator.annotation.ValidCategoryId;
import com.example.kiethuynh.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext constraintValidatorContext ) {
        return category !=null && category.getId() !=null;
    }

}
