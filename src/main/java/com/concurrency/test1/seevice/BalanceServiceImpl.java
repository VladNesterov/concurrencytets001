package com.concurrency.test1.seevice;

import com.concurrency.test1.entity.Balance;
import com.concurrency.test1.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.constructs.blocking.BlockingCache;
import net.sf.ehcache.hibernate.management.impl.EhcacheHibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.NotCompliantMBeanException;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;
    private final Ehcache blockingCache;

    private ConcurrentHashMap<Long, Long> aa = new ConcurrentHashMap<>();

    @Override
    public Long getBalance(Long id) {
        return balanceRepository.getReferenceById(id).getAmount();
    }

    @Override
    @Transactional
    public void changeBalance(Long id, Long amount) {
        balanceRepository.updateAmountById(id, amount);
    }

    @Override
    public Long createBalance(Long amount) {
        Balance a = new Balance();
        a.setAmount(amount);
        return balanceRepository.save(a).getId();
    }
}
