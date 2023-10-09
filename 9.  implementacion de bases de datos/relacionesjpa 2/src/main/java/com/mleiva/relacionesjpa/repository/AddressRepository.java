package com.mleiva.relacionesjpa.repository;

import com.mleiva.relacionesjpa.entity.OneToOne.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
