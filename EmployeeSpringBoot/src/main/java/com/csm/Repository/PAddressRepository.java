package com.csm.Repository;

import com.csm.Entity.PermanentAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PAddressRepository extends JpaRepository<PermanentAddress, Integer> {
}
