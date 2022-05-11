package com.csm.productmasterspringboot.Repository;

import com.csm.productmasterspringboot.Model.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {
}
