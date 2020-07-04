
package com.confucius.tenant.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.confucius.tenant.entity.WorkOrderEntity;

@Repository
public interface WorkOrderRepository extends CrudRepository<WorkOrderEntity, Integer> {

  @Query("SELECT w FROM WorkOrderEntity w WHERE status = :status")
  List<WorkOrderEntity> findByStatus(@Param("name") String status);

  @Query("SELECT w FROM WorkOrderEntity w WHERE status in :status")
  List<WorkOrderEntity> findByStatuses(@Param("names") List<String> statuses);

  @Query("SELECT w FROM WorkOrderEntity w WHERE updatedDate between :startDate and :endDate")
  List<WorkOrderEntity> findByTimeRange(@Param("names") Date startDate, Date endDate);

}
