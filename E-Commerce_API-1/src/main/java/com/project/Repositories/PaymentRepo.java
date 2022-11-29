package com.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
