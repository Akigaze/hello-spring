package demo.qf.spring.stereotype.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StereotypeService {
  @Autowired
  private StereotypeRepository repository;

  public StereotypeRepository getRepository() {
    return repository;
  }
}
