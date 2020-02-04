package org.eu.rubensa.uniovi.reservas.web.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * HomeControllerTest
 */
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  BuildProperties buildProperties;

  @Test
  public void getHome_ReturnsAppInfo() throws Exception {
    BDDMockito.given(buildProperties.getName()).willReturn("reservas-server");
    BDDMockito.given(buildProperties.getVersion()).willReturn("1.0.0");

    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/")).andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    String content = result.getResponse().getContentAsString();
    Assertions.assertThat(content).contains("reservas-server");
  }
}