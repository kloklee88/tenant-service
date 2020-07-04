package com.confucius.tenant.messages;

import com.confucius.tenant.constants.WorkOrderStatus;
import lombok.Data;

@Data
public class SaveWorkOrderResponse {

  private WorkOrderStatus status;

}
