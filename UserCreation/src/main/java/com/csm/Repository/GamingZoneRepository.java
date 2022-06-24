package com.csm.Repository;

import com.csm.Model.GamingZoneRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamingZoneRepository extends JpaRepository<GamingZoneRegistration, Integer> {
	GamingZoneRegistration findByRegId(Integer regId);
}
