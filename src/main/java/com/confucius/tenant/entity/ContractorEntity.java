
package com.confucius.tenant.entity;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name = "contractor")
@ToString
@NoArgsConstructor
public class ContractorEntity {

  @Id
  @Column(name = "work_order_id", nullable = false)
  private String workOrderId;

  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @Column(name = "email", nullable = true)
  private String email;

  @Column(name = "phone_number", nullable = true)
  private String phoneNumber;

  @Column(name = "created_date", nullable = false)
  private ZonedDateTime createdDate;

  @Column(name = "updated_date", nullable = false)
  private ZonedDateTime updatedDate;

}
