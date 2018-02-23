package com.udacity.sandwichclub.model;

import android.text.TextUtils;
import java.util.List;

public class Sandwich {

  private static final String NOT_AVAILABLE = "not available";

  private String mainName;
  private List<String> alsoKnownAs = null;
  private String placeOfOrigin;
  private String description;
  private String image;
  private List<String> ingredients = null;

  /**
   * No args constructor for use in serialization
   */
  public Sandwich() {
  }

  public Sandwich(String mainName, List<String> alsoKnownAs, String placeOfOrigin,
      String description, String image, List<String> ingredients) {
    this.mainName = mainName;
    this.alsoKnownAs = alsoKnownAs;
    this.placeOfOrigin = placeOfOrigin;
    this.description = description;
    this.image = image;
    this.ingredients = ingredients;
  }

  public String getMainName() {
    return mainName;
  }

  public void setMainName(String mainName) {
    this.mainName = mainName;
  }

  public List<String> getAlsoKnownAs() {
    return alsoKnownAs;
  }

  public String getAlsoKnownAsString() {
    if (getAlsoKnownAs() != null) {
      return TextUtils.join(", ", getAlsoKnownAs());
    } else {
      return NOT_AVAILABLE;
    }
  }

  public void setAlsoKnownAs(List<String> alsoKnownAs) {
    this.alsoKnownAs = alsoKnownAs;
  }

  public String getPlaceOfOrigin() {
    return placeOfOrigin.isEmpty() ? NOT_AVAILABLE : placeOfOrigin;
  }

  public void setPlaceOfOrigin(String placeOfOrigin) {
    this.placeOfOrigin = placeOfOrigin;
  }

  public String getDescription() {
    return description.isEmpty() ? NOT_AVAILABLE : description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<String> getIngredients() {
    return ingredients;
  }

  public String getIngredientsString() {
    if (getIngredients() != null) {
      return TextUtils.join(", ", getIngredients());
    } else {
      return NOT_AVAILABLE;
    }
  }

  public void setIngredients(List<String> ingredients) {
    this.ingredients = ingredients;
  }
}
