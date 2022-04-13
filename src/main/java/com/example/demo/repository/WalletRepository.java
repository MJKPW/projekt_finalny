package com.example.demo.repository;

import com.example.demo.domain.WalletState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends CrudRepository<WalletState, Long> {

    @Override
    List<WalletState> findAll();

    @Override
    Optional<WalletState> findById(Long id);

    @Override
    void deleteById(Long id);
}
