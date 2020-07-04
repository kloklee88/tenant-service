package com.confucius.tenant.messages;

import com.confucius.tenant.constants.Problem;
import lombok.Data;

@Data
public class SaveWorkOrderRequest {

  private String tenantName;

  private String tenantPhone;

  private Problem problem;

  private String description;

}
