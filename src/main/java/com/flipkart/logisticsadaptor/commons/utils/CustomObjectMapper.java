package com.flipkart.logisticsadaptor.commons.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class CustomObjectMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public CustomObjectMapper() {
    }

    public static <T> T convertToObject(Object object, Class<T> className) {
        return objectMapper.convertValue(object, className);
    }

    public static <T> T convertToObject(Object object, TypeReference<T> typeReference) {
        return objectMapper.convertValue(object, typeReference);
    }

    public static <T> T convertStringToObject(String payload, Class<T> className) throws IOException {
        return objectMapper.readValue(payload, className);
    }

    public static <T> T convertStringToObject(String payload, TypeReference<T> typeReference) throws IOException {
        return objectMapper.readValue(payload, typeReference);
    }

    public static <T> T convertStringToObject(String content, JavaType valueType) throws IOException {
        return objectMapper.readValue(content, valueType);
    }

    public static <T> T convertStringToObject(InputStream content, JavaType valueType) throws IOException {
        return objectMapper.readValue(content, valueType);
    }

    public static <T> T convertStringToObject(InputStream content, Class<T> className) throws IOException {
        return objectMapper.readValue(content, className);
    }

    public static JsonNode convertToJsonNode(Object fromValue) {
        return objectMapper.valueToTree(fromValue);
    }

    public static String getObjectAsString(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static <T> T convertFromFile(InputStream inputStream, Class<T> type) throws IOException {
        return objectMapper.readValue(inputStream, type);
    }

    public static <T> T convertFromFile(InputStream inputStream, TypeReference<T> typeReference) throws IOException {
        return objectMapper.readValue(inputStream, typeReference);
    }

    public static <T> T convertFromString(String string, TypeReference<T> typeReference) throws IOException {
        return objectMapper.readValue(string, typeReference);
    }

    public static JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
        return objectMapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

    public static JavaType getJavaType(Class<?> classType) {
        return objectMapper.getTypeFactory().constructType(classType);
    }

    public static JavaType getJavaType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
        return objectMapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
    }

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}

