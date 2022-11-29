package com.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.OrderDetails;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {

}
