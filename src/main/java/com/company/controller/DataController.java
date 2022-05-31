package com.company.controller;

import com.company.service.DataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class DataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

    private final DataService dataService;

    public DataController(
            final DataService dataService
    ) {
        this.dataService = dataService;
    }

    @GetMapping("/data")
    public Map<String, List<Object>> getCache() throws ParseException {
        return dataService.getCache();
    }

    @GetMapping("/flatten-data")
    public Map<String, Object> displayFlattenData() throws ParseException {
        return dataService.getFlattenedJson(dataService.getCache());
    }

    @GetMapping("/parse-json")
    public Map<String, List<Object>> parseJson() {
        return dataService.parseJson();
    }

    @GetMapping("/createBaseDbColumns")
    public void createBaseDbColumns() throws ParseException {
        dataService.createBaseDbColumnsFromDto();
    }
}