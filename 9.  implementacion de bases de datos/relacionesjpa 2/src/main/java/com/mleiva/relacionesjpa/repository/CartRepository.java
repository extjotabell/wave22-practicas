package com.mleiva.relacionesjpa.repository;

import com.mleiva.relacionesjpa.entity.OneToMany.Cart;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CartRepository extends JpaRepository<Cart,Long> {

}
