package com.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {

}
