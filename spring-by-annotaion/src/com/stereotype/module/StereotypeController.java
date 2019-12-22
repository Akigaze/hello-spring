package com.stereotype.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StereotypeController {
  @Autowired
  private StereotypeService service;

  public StereotypeService getService() {
    return service;
  }
}
