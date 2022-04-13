package com.example.demo.repository;

import com.example.demo.domain.TransactionLogger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionLoggerRepository extends CrudRepository<TransactionLogger, Long> {

    @Override
    List<TransactionLogger> findAll();

    @Override
    Optional<TransactionLogger> findById(Long id);

    @Override
    void deleteById(Long id);
}
