package com.sambit.productmasterspringboot.Repository;

import com.sambit.productmasterspringboot.Model.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {
}
