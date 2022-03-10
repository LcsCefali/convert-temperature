package com.example.converttemperature.dao;

import com.example.converttemperature.model.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryDAO {
    private final static List<History> history = new ArrayList<>();

    public void save(History newHistory) {
        history.add(newHistory);
    }

    public List<History> getList() {
        return new ArrayList<>(history);
    }
}
