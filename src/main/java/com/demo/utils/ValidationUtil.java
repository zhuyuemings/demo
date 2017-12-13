package com.demo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ValidationUtil {
    public static boolean isValid(Errors errors, Object object, Class<?>... classes) {
        if (classes == null || classes.length == 0 || classes[0] == null) {
            classes = new Class<?>[]{Default.class};
        }
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Object>> violationSet = validator.validate(object, classes);
        for (ConstraintViolation<Object> constraintViolation : violationSet) {
            Path path = constraintViolation.getPropertyPath();
            String propertyName = "";
            if (path != null) {
                for (Path.Node node : path) {
                    propertyName += node.getName() + ".";
                }
                propertyName = propertyName.substring(0, propertyName.length() - 1);

            }
            String constraintName = constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();
            if (errors != null) {
                if (propertyName != null || propertyName.equals("")) {
                    errors.reject(constraintName, constraintViolation.getMessage());
                } else {
                    errors.rejectValue(propertyName, constraintName, constraintViolation.getMessage());
                }
            }
        }
        return violationSet.size() == 0;
    }

    public static JSONArray getFieldErrors(BindingResult bindingResult) {
        JSONArray errors = new JSONArray();
        JSONObject error = null;
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            error = new JSONObject();
            error.put("fieldName", fieldError.getField());
            error.put("errorMsg", fieldError.getDefaultMessage());
            for (int i = 0; i < errors.size(); i++) {
                JSONObject jsonObject = errors.getJSONObject(i);
                if (jsonObject.containsValue(fieldError.getField())) {
                    error.put("errorMsg", jsonObject.get("errorMsg") + "<br/>" + fieldError.getDefaultMessage());
                    errors.remove(jsonObject);
                    break;
                }
            }
            errors.add(error);
        }
        return errors;
    }

    public static String getFieldErrorString(BindingResult bindingResult) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bindingResult == null) {
            return "";
        }
        for (Iterator<FieldError> iterator = bindingResult.getFieldErrors().iterator(); iterator.hasNext(); ) {
            FieldError fieldError = iterator.next();
            if (iterator.hasNext()) {
                stringBuffer.append(fieldError.getDefaultMessage() + "<br/>");
            } else {
                stringBuffer.append(fieldError.getDefaultMessage());
            }
        }
        return stringBuffer.toString();
    }
}
