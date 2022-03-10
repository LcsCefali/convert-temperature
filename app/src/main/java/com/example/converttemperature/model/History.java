package com.example.converttemperature.model;

import androidx.annotation.NonNull;

public class History {
    private final String result;
    private final String inputValue;
    private final String condition;
    private final String type;

    public String getResult() {
        return result;
    }
    public String getCondition() {
        return condition;
    }
    public String getInputValue() {
        return inputValue;
    }

    public History(String result, String inputValue, String condition, String type) {
        this.result = result;
        this.inputValue = inputValue;
        this.condition = condition;
        this.type = type;
    }

    @NonNull
    @Override
    public String toString() {
        String typeConvertion = type == "celsius" ? " ºC" : " ºF";
        return condition + " = " + result + typeConvertion;
    }
}
