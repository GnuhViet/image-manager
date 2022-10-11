package com.example.webblog.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String value;

    public HttpUtil(String value) {
        this.value = value;
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    /*
    public List<Long> toListId() {
        List<Long> res = new ArrayList<>();
        JsonNode jsonNode = null;
        try {
            jsonNode = new ObjectMapper().readTree(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (jsonNode.isArray()) {
            for (JsonNode objNode : jsonNode) {
                res.add(objNode.get("id").asLong());
            }
        }
        return res;
    }
     */

    public static HttpUtil of(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new HttpUtil(sb.toString());
    }
}
