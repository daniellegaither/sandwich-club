package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonSandwich = new JSONObject(json);
            sandwich.setMainName(jsonSandwich.getJSONObject("name").getString("mainName"));
            sandwich.setPlaceOfOrigin(jsonSandwich.getString("placeOfOrigin"));
            sandwich.setDescription(jsonSandwich.getString("description"));
            JSONArray alsoKnownAs = jsonSandwich.getJSONObject("name").getJSONArray("alsoKnownAs");
//            String origin = jsonSandwich.getString("placeOfOrigin");
//            Log.d("DCG", "Origin: " + origin);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return sandwich;
    }
}
