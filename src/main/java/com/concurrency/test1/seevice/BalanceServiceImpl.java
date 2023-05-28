package com.concurrency.test1.seevice;

import com.concurrency.test1.entity.Balance;
import com.concurrency.test1.repository.BalanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;
    private final CacheManager blockingCache;

    private ConcurrentHashMap<Long, Long> aa = new ConcurrentHashMap<>();

    @Override
    public Long getBalance(Long id) {
        return balanceRepository.getReferenceById(id).getAmount();
    }

    @Override
    @Transactional
    synchronized public void changeBalance(Long id, Long amount) {
        if (balanceRepository.getReferenceById(id) == null) {
            throw new EntityNotFoundException();
        }
        Balance balance = new Balance();
        balance.setAmount(amount);
        balance.setId(id);
        balanceRepository.save(balance);
    }


    @Override
    synchronized public Long createBalance(Long amount) {
        Balance a = new Balance();
        a.setAmount(amount);
        return balanceRepository.save(a).getId();
    }
}
