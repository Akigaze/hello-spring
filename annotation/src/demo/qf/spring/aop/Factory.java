package demo.qf.spring.aop;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component("myFactory")
public class Factory {
  private List<Worker> workers;
  private List product;

  List getProduct() {
    return product;
  }

  void hire(Worker... workers) {
    this.workers = Arrays.asList(workers);
  }

  void startWorking() {
    this.product = workers.stream().map(worker -> {
      try {
        return worker.work();
      } catch (Exception ignored) {
        return null;
      }
    }).collect(Collectors.toList());
    this.workers.forEach(Worker::goHome);
  }
}
