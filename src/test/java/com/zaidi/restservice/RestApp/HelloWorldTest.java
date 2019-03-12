package com.zaidi.restservice.RestApp;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.regex.Matcher;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldTest {

    private MockMvc mockMvc;

    @InjectMocks
    private HelloWorld helloWorld;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorld).build();
    }

    @Test
    public void testHelloWorld() throws Exception

    {

        mockMvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().string("hello world"));

    }

    @Test
    public void testCar() throws  Exception{
        mockMvc.perform(get("/hello/json").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.manufecturer", Matchers.is("Honda"))).andExpect(jsonPath("$.name", Matchers.is("Civic"))).andExpect(jsonPath("$.*",Matchers.hasSize(2)));
    }
}
