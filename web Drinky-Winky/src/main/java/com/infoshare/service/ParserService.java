package com.infoshare.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.parser.DrinkAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@RequestScoped
public class ParserService implements Serializable {

    private static String JSON_ROOT = "drinks";
    private Logger logger = LoggerFactory.getLogger(getClass().getName());


    public <T> Object parseFile(File json) {

        T outputObject = null;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            outputObject = (T) objectMapper.readValue(jsonNode.get(JSON_ROOT).toString(), new TypeReference<List<DrinkAPI>>() {
            });
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Parse data from file");
        return outputObject;
    }
}
