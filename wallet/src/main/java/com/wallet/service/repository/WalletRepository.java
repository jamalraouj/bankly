package com.wallet.service.repository;

import com.wallet.service.entity.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;



public interface WalletRepository extends MongoRepository<Wallet , Long> {
    public Optional<Wallet> findByRib(String rib);
//    public Optional<List<Wallet>> findAllByUser_id(Long id);
//    public List<Wallet> findAllByStatus_Banned();
//    public List
}
