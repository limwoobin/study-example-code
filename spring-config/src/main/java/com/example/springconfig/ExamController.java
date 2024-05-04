package com.example.springconfig;

import com.example.springconfig.config.ExamComponent;
import com.example.springconfig.config.ExamConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/v1/exam")
@RestController
public class ExamController {

  private final ExamConfiguration examConfiguration;
  private final ExamComponent examComponent;

  public ExamController(ExamConfiguration examConfiguration,
                        ExamComponent examComponent) {
    this.examConfiguration = examConfiguration;
    this.examComponent = examComponent;
  }

  @GetMapping(value = "/configuration")
  public ResponseEntity<String> exam() {
    return new ResponseEntity<>(examConfiguration.exam().toString(), HttpStatus.OK);
  }

  @GetMapping(value = "/component")
  public ResponseEntity<String> exam2() {
    return new ResponseEntity<>(examComponent.exam2().toString(), HttpStatus.OK);
  }
}
