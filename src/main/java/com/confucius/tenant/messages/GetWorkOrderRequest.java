package com.confucius.tenant.messages;

import java.util.Date;
import lombok.Data;

@Data
public class GetWorkOrderRequest {

  private String status;

  private Date startDate;

  private Date endDate;

}
