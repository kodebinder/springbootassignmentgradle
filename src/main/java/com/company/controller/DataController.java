package com.company.controller;

import com.company.data.DataUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class DataController {

    private final DataUtility dataUtility;

    @Autowired
    public DataController(
            final DataUtility dataUtility
    ) {
        this.dataUtility = dataUtility;
    }

    @GetMapping("/data")
    public Map<String, List<Object>> getCache() throws ParseException {
        return dataUtility.loadCache();
    }

    @GetMapping("/flatten-data")
    public void displayFlattenData() throws ParseException {
        dataUtility.displayFlattenedJson(dataUtility.loadCache());
    }
}