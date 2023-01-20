package com.study.grpcserver;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricController {

  @PostMapping(value = "/metric", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public String getMetric(@RequestBody List<Metric> metric) {
    System.out.println("REST size: " + metric.size());
    return "success";
  }

}
