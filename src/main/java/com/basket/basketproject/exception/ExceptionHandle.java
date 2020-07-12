package com.basket.basketproject.exception;

import com.basket.basketproject.result.GlobalResult;
import com.basket.basketproject.result.VaildateFieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description 对dto注解形式的校验进行处理
 * @Author shaoyonggong
 * @Date 2020/7/11
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GlobalResult exceptionHandler(MethodArgumentNotValidException e) {
        GlobalResult result = new GlobalResult();
        result.setMessage("校验不通过！");
        List<VaildateFieldError> errorList = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(m -> {
            VaildateFieldError error = new VaildateFieldError();
            String fieldName = "";
            Optional<String> firstOptional = Arrays.asList(m.getCodes()).stream().filter(p -> p.contains(m.getObjectName())).findFirst();
            if (firstOptional.isPresent()) {
                fieldName = firstOptional.get().substring(firstOptional.get().lastIndexOf(".") + 1);
            }
            error.setFieldName(fieldName);
            if (m.getDefaultMessage().contains("需要匹配正则表达式")) {
                error.setErrorMessage(fieldName + "格式不正确！");
            } else {
                error.setErrorMessage(m.getDefaultMessage());
            }
            errorList.add(error);
        });
        result.setValidationErrors(errorList);
        result.markRefused();
        return result;
    }

}
