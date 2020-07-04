
package com.confucius.tenant.entity;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.confucius.tenant.constants.Problem;
import com.confucius.tenant.constants.WorkOrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "work_order")
@ToString
@NoArgsConstructor
public class WorkOrderEntity {

  @Id
  @Column(name = "work_order_id", nullable = false)
  private Long workOrderId;

  @Enumerated(EnumType.STRING)
  @Column(name = "problem", nullable = true)
  private Problem problem;

  @Column(name = "tenant_name", nullable = true)
  private String tenantName;

  @Column(name = "tenant_phone_number", nullable = true)
  private String tenantPhoneNumber;

  @Column(name = "description", nullable = true)
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = true)
  private WorkOrderStatus status;

  @ManyToOne
  @Column(name = "contractor")
  private ContractorEntity contractor;

  @Column(name = "created_date", nullable = false)
  private ZonedDateTime createdDate;

  @Column(name = "updated_date", nullable = false)
  private ZonedDateTime updatedDate;

}
