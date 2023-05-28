package com.concurrency.test1.seevice;

import com.concurrency.test1.entity.Balance;
import com.concurrency.test1.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;


    @Override
    public Optional<Long> getBalance(Long id) {
        return Optional.of(balanceRepository.getReferenceById(id).getAmount());
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
