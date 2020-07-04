
package com.confucius.tenant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.confucius.tenant.entity.ContractorEntity;

@Repository
public interface ContractorRepository extends CrudRepository<ContractorEntity, Integer> {

}
