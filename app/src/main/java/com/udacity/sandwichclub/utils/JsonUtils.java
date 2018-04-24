package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonSandwich = new JSONObject(json);
            sandwich.setMainName(jsonSandwich.getJSONObject("name").getString("mainName"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return sandwich;
    }
}
