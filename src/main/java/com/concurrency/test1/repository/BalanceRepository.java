package com.concurrency.test1.repository;

import com.concurrency.test1.entity.Balance;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    @Override
    @Cacheable(cacheManager = "customCacheManager", cacheNames = {"Balance"}, key = "#id")
    Balance getReferenceById(Long id);

    @Override
    @CachePut(cacheManager = "customCacheManager", cacheNames = {"Balance"}, key = "#result.id")
    <S extends Balance> S save(S entity);
}
