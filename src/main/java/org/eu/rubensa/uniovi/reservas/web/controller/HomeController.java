package org.eu.rubensa.uniovi.reservas.web.controller;

import java.util.Arrays;

import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * HomeController
 */
@RestController
@Slf4j
public class HomeController {

  BuildProperties buildProperties;

  public HomeController(BuildProperties buildProperties) {
    log.debug("HomeController(BuildProperties buildProperties) - start");
    this.buildProperties = buildProperties;
    log.debug("HomeController(BuildProperties buildProperties) - end");
  }

  /**
   * @return String
   */
  @GetMapping("/")
  public String home() {
    log.debug("home() - start");
    String returnValue = String.join(" - ", Arrays.asList(buildProperties.getName(), buildProperties.getVersion()));
    log.debug("home() - end");
    return returnValue;
  }

}