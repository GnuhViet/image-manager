package com.example.webblog.mapper.impl;

import com.example.webblog.mapper.RowMapper;
import com.example.webblog.model.AbstractModel;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractMapper<T> implements RowMapper<T> {

    public <T> T newMappedInstance(Class<T> tClass, ResultSet rs) {
        //* get all fields
        List<Field> fields = Arrays.asList(tClass.getDeclaredFields());
        Class<? super T> parent = tClass.getSuperclass();
        while (true) {
            List<Field> supper = Arrays.asList(parent.getDeclaredFields());
            fields = Stream.concat(supper.stream(), fields.stream())
                    .collect(Collectors.toList());
            if (parent == AbstractModel.class) {
                break;
            }
            parent = parent.getSuperclass();
        }

        //* create instance and set its fields
        T tInstance = null;
        try {
            tInstance = tClass.newInstance();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    field.set(tInstance, rs.getObject(field.getName()));
                } catch (IllegalAccessException | SQLException e) {
                    e.printStackTrace();
                }
            }
            return tInstance;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}