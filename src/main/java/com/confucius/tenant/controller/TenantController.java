package com.confucius.tenant.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.confucius.tenant.constants.Problem;
import com.confucius.tenant.messages.GetWorkOrderRequest;
import com.confucius.tenant.messages.GetWorkOrderResponse;
import com.confucius.tenant.messages.SaveWorkOrderRequest;
import com.confucius.tenant.messages.SaveWorkOrderResponse;
import com.confucius.tenant.service.TenantService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/tenant")
@Slf4j
public class TenantController {

  @Autowired
  private TenantService tenantService;

  @GetMapping("/areyouthere")
  public ResponseEntity<Boolean> areYouThere() {
    log.debug("Are you there pinged");
    return new ResponseEntity<Boolean>(true, HttpStatus.OK);
  }

  @GetMapping("/throwexception")
  public ResponseEntity<Object> throwException() throws Exception {
    throw new Exception("Test Exception");
  }

  @GetMapping("/getallproblems")
  public ResponseEntity<Problem[]> getProblems() {
    log.debug("Getting all problems");
    return new ResponseEntity<Problem[]>(Problem.values(), HttpStatus.OK);
  }

  @PostMapping(path = "/saveworkorder", consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<SaveWorkOrderResponse> saveWorkOrder(
      @Valid @RequestBody SaveWorkOrderRequest request) {
    log.debug("Save Work Order request: {}", request);
    SaveWorkOrderResponse response = tenantService.saveWorkOrder(request);
    log.debug("Save Work Order response: {}", response);
    return new ResponseEntity<SaveWorkOrderResponse>(response, HttpStatus.OK);
  }

  @PostMapping(path = "/getworkorders", consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<GetWorkOrderResponse> getWorkOrders(
      @Valid @RequestBody GetWorkOrderRequest request) {
    log.debug("Get Work Order request: {}", request);
    GetWorkOrderResponse response = tenantService.getWorkOrders(request);
    log.debug("Get Work Order: {}", response);
    return new ResponseEntity<GetWorkOrderResponse>(response, HttpStatus.OK);
  }

}
