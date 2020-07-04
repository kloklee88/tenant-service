package com.confucius.tenant.service;

import java.time.ZonedDateTime;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.confucius.tenant.constants.WorkOrderStatus;
import com.confucius.tenant.entity.WorkOrderEntity;
import com.confucius.tenant.messages.GetWorkOrderRequest;
import com.confucius.tenant.messages.GetWorkOrderResponse;
import com.confucius.tenant.messages.SaveWorkOrderRequest;
import com.confucius.tenant.messages.SaveWorkOrderResponse;
import com.confucius.tenant.repository.ContractorRepository;
import com.confucius.tenant.repository.WorkOrderRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TenantService {

  @Autowired
  private WorkOrderRepository workOrderRepository;

  @Autowired
  private ContractorRepository contractorRepository;

  public SaveWorkOrderResponse saveWorkOrder(@Valid SaveWorkOrderRequest request) {
    log.debug("Saving new work order");
    SaveWorkOrderResponse response = new SaveWorkOrderResponse();

    WorkOrderEntity workOrderEntity = new WorkOrderEntity();
    workOrderEntity.setTenantName(request.getTenantName());
    workOrderEntity.setTenantPhoneNumber(request.getTenantPhone());
    workOrderEntity.setDescription(request.getDescription());
    workOrderEntity.setProblem(request.getProblem());
    workOrderEntity.setStatus(WorkOrderStatus.NEW);
    workOrderEntity.setCreatedDate(ZonedDateTime.now());
    workOrderEntity.setUpdatedDate(ZonedDateTime.now());
    workOrderRepository.save(workOrderEntity);

    response.setStatus(WorkOrderStatus.NEW);
    return response;
  }

  public GetWorkOrderResponse getWorkOrders(@Valid GetWorkOrderRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

}
