package com.company.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.company.service.BaseDbColumnService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {BaseDbColumnController.class})
@ExtendWith(SpringExtension.class)
class BaseDbColumnControllerTest {
    @Autowired
    private BaseDbColumnController baseDbColumnController;

    @MockBean
    private BaseDbColumnService baseDbColumnService;

    /**
     * Method under test: {@link BaseDbColumnController#createBaseDbColumns()}
     */
    @Test
    void testCreateBaseDbColumns() throws Exception {
        doNothing().when(this.baseDbColumnService).createBaseDbColumnsFromDto();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/createBaseDbColumns");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BaseDbColumnController#getCache()}
     */
    @Test
    void testGetCache() throws Exception {
        when(this.baseDbColumnService.getCache()).thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/data");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    /**
     * Method under test: {@link BaseDbColumnController#getCache()}
     */
    @Test
    void testGetCache2() throws Exception {
        when(this.baseDbColumnService.getCache()).thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/data");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    /**
     * Method under test: {@link BaseDbColumnController#parseJson()}
     */
    @Test
    void testParseJson() throws Exception {
        when(this.baseDbColumnService.parseJson()).thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/parse-json");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    /**
     * Method under test: {@link BaseDbColumnController#parseJson()}
     */
    @Test
    void testParseJson2() throws Exception {
        when(this.baseDbColumnService.parseJson()).thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/parse-json");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    /**
     * Method under test: {@link BaseDbColumnController#createBaseDbColumns()}
     */
    @Test
    void testCreateBaseDbColumns2() throws Exception {
        doNothing().when(this.baseDbColumnService).createBaseDbColumnsFromDto();
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/createBaseDbColumns");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link BaseDbColumnController#displayFlattenData()}
     */
    @Test
    void testDisplayFlattenData() throws Exception {
        when(this.baseDbColumnService.getCache()).thenReturn(new HashMap<>());
        when(this.baseDbColumnService.getFlattenedJson((Map<String, List<Map<String, Object>>>) any()))
                .thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/flatten-data");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    /**
     * Method under test: {@link BaseDbColumnController#displayFlattenData()}
     */
    @Test
    void testDisplayFlattenData2() throws Exception {
        when(this.baseDbColumnService.getCache()).thenReturn(new HashMap<>());
        when(this.baseDbColumnService.getFlattenedJson((Map<String, List<Map<String, Object>>>) any()))
                .thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/flatten-data");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }
}

