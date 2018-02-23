package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils {

  public static Sandwich parseSandwichJson(String json) {
    final String NAME = "name";
    final String MAIN_NAME = "mainName";
    final String ALTERNATIVE_NAMES = "alsoKnownAs";
    final String ORIGIN = "placeOfOrigin";
    final String DESCRIPTION = "description";
    final String IMAGE = "image";
    final String INGREDIENTS = "ingredients";

    String mainName;
    List<String> alsoKnownAs = null;
    String placeOfOrigin;
    String description;
    String image;
    List<String> ingredients = null;

    try {
      JSONObject sandwichJson = new JSONObject(json);

      JSONObject sandwichNameJson = sandwichJson.getJSONObject(NAME);
      mainName = sandwichNameJson.getString(MAIN_NAME);
      JSONArray alsoKnownAsArray = sandwichNameJson.getJSONArray(ALTERNATIVE_NAMES);
      if (alsoKnownAsArray.length() > 0) {
        alsoKnownAs = new ArrayList<>();
        for (int i = 0; i < alsoKnownAsArray.length(); i++) {
          alsoKnownAs.add(alsoKnownAsArray.getString(i));
        }
      }
      placeOfOrigin = sandwichJson.getString(ORIGIN);
      description = sandwichJson.getString(DESCRIPTION);
      image = sandwichJson.getString(IMAGE);
      JSONArray ingredientsArray = sandwichJson.getJSONArray(INGREDIENTS);
      if (ingredientsArray.length() > 0) {
        ingredients = new ArrayList<>();
        for (int i = 0; i < ingredientsArray.length(); i++) {
          ingredients.add(ingredientsArray.getString(i));
        }
      }
      return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
