package com.example.webblog.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtil {

    public static <T> T toModel(Class<T> tClass, HttpServletRequest request) {
        T instance = null;
        try {
            instance = tClass.newInstance();
            BeanUtils.populate(instance, request.getParameterMap());
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
