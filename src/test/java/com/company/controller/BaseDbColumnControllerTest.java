package com.company.controller;

import com.company.entity.BaseDbColumn;
import com.company.service.BaseDbColumnService;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.*;

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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/createbasedbcolumns");
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
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/parsejsonandsavetodb");
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
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/parsejsonandsavetodb");
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
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/createbasedbcolumns");
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
        when(this.baseDbColumnService.getFlattenedJson((java.util.Map<String, List<Object>>) any()))
                .thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/flattendata");
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
        when(this.baseDbColumnService.getFlattenedJson((java.util.Map<String, List<Object>>) any()))
                .thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/flattendata");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    /**
     * Method under test: {@link BaseDbColumnController#findAllDto()}
     */
    @Test
    void testFindAllDto() throws Exception {
        when(this.baseDbColumnService.getAllExistingDtoInsidePackage()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/findalldto");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BaseDbColumnController#findAllDto()}
     */
    @Test
    void testFindAllDto2() throws Exception {
        when(this.baseDbColumnService.getAllExistingDtoInsidePackage()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/findalldto");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BaseDbColumnController#getBaseDbColumns()}
     */
    @Test
    void testGetBaseDbColumns() throws Exception {
        when(this.baseDbColumnService.getListBaseDbColumns()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/getbasedbcolumns");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link BaseDbColumnController#getBaseDbColumns()}
     */
    @Test
    void testGetBaseDbColumns2() throws Exception {
        BaseDbColumn baseDbColumn = new BaseDbColumn();
        baseDbColumn.setGroupedValues(new ArrayList<>());
        baseDbColumn.setId(123L);
        baseDbColumn.setLabel("?");
        baseDbColumn.setName("?");
        baseDbColumn.setType("?");

        ArrayList<BaseDbColumn> baseDbColumnList = new ArrayList<>();
        baseDbColumnList.add(baseDbColumn);
        when(this.baseDbColumnService.getListBaseDbColumns()).thenReturn(baseDbColumnList);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/getbasedbcolumns");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[{\"id\":123,\"name\":\"?\",\"label\":\"?\",\"type\":\"?\",\"groupedValues\":[]}]"));
    }

    /**
     * Method under test: {@link BaseDbColumnController#getBaseDbColumns()}
     */
    @Test
    void testGetBaseDbColumns3() throws Exception {
        when(this.baseDbColumnService.getListBaseDbColumns()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/getbasedbcolumns");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.baseDbColumnController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

