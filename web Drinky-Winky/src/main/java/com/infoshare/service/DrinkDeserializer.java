package com.infoshare.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.infoshare.parser.DrinkAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DrinkDeserializer extends JsonDeserializer<DrinkAPI> {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    public DrinkAPI deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        Map<String, String> ingredients = new HashMap<>();

        DrinkAPI drinkApi = new DrinkAPI();
        JsonNode tree = p.readValueAsTree();

        String[] errors = {"null"};

        for (int index = 1; index < 16; index++) {

            index = (char) index;

            JsonNode ingredientNode = tree.get("strIngredient" + index);

            if (ingredientNode == null) {
                break;
            }

            String trim = ingredientNode.asText().trim();

            for (String error : errors) {

                if (!trim.equals(error) && !trim.isEmpty()) {

                    ingredients.put(tree.get("strIngredient" + index).asText().trim(),
                            tree.get("strMeasure" + index).asText().trim());
                }
            }
        }

        drinkApi.setId(tree.get("idDrink").asLong());
        drinkApi.setName(tree.get("strDrink").asText());
        drinkApi.setInstruction(tree.get("strInstructions").asText());
        drinkApi.setRecipeCategory(tree.get("strCategory").asText());
        drinkApi.setDrinkType(tree.get("strAlcoholic").asText());
        drinkApi.setGlassType(tree.get("strGlass").asText());
        drinkApi.setModificationDate(tree.get("dateModified").asText());
        drinkApi.setImageUrl(tree.get("strDrinkThumb").asText());
        drinkApi.setIngredients(ingredients);
        logger.info("Deserialization data from file");
        return drinkApi;
    }
}

