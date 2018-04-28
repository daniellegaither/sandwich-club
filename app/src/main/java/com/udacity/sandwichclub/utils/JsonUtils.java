package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonSandwich = new JSONObject(json);
            sandwich.setMainName(jsonSandwich
                    .getJSONObject("name")
                    .getString("mainName"));
            sandwich.setPlaceOfOrigin(jsonSandwich
                    .getString("placeOfOrigin"));
            sandwich.setDescription(jsonSandwich
                    .getString("description"));

            JSONArray jsonAlsoKnownAs = jsonSandwich
                    .getJSONObject("name")
                    .getJSONArray("alsoKnownAs");

            List<String> alsoKnownAs = new ArrayList<String>();

            for (int i=0; i<jsonAlsoKnownAs.length(); i++)
            {
                alsoKnownAs.add(jsonAlsoKnownAs.getString(i));
            }
            sandwich.setAlsoKnownAs(alsoKnownAs);

            JSONArray jsonIngredients = jsonSandwich
                    .getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<String>();

            for (int i=0; i<jsonIngredients.length(); i++)
            {
                ingredients.add(jsonIngredients.getString(i));
            }
            sandwich.setIngredients(ingredients);

            sandwich.setImage(jsonSandwich.getString("image"));

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return sandwich;
    }
}
