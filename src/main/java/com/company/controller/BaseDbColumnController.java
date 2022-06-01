package com.company.controller;

import com.company.service.BaseDbColumnService;
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
public class BaseDbColumnController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseDbColumnController.class);

    private final BaseDbColumnService baseDbColumnService;

    public BaseDbColumnController(
            final BaseDbColumnService baseDbColumnService
    ) {
        this.baseDbColumnService = baseDbColumnService;
    }

    @GetMapping("/data")
    public Map<String, List<Map<String, Object>>> getCache() throws ParseException {
        return baseDbColumnService.getCache();
    }

    @GetMapping("/flatten-data")
    public Map<String, Object> displayFlattenData() throws ParseException {
        return baseDbColumnService.getFlattenedJson(baseDbColumnService.getCache());
    }

    @GetMapping("/parse-json")
    public Map<String, List<Map<String, Object>>> parseJson() {
        return baseDbColumnService.parseJson();
    }

    @GetMapping("/createBaseDbColumns")
    public void createBaseDbColumns() throws ParseException {
        baseDbColumnService.createBaseDbColumnsFromDto();
    }
}