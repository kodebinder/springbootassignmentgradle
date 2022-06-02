package com.company.controller;

import com.company.service.BaseDbColumnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
    public Map<String, List<Object>> getCache() throws ParseException {
        return baseDbColumnService.getCache();
    }

    @GetMapping("/flattendata")
    public Map<String, Object> displayFlattenData() throws ParseException {
        return baseDbColumnService.getFlattenedJson(baseDbColumnService.getCache());
    }

    @GetMapping("/parsejsonandsavetodb")
    public Map<String, List<Object>> parseJson() {
        return baseDbColumnService.parseJson();
    }

    @GetMapping("/createbasedbcolumns")
    public void createBaseDbColumns() throws ParseException, IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        baseDbColumnService.createBaseDbColumnsFromDto();
    }

    @GetMapping("/getbasedbcolumns")
    public void getBaseDbColumns() throws ParseException, IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        baseDbColumnService.getListBaseDbColumns();
    }

    @GetMapping("/findalldto")
    public void findAllDto() throws ParseException, IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        baseDbColumnService.getAllDtoObjects();
    }
}