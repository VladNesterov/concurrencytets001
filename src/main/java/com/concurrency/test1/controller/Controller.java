package com.concurrency.test1.controller;

import com.concurrency.test1.seevice.BalanceServiceImpl;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("balance")
public class Controller {

   private final BalanceServiceImpl balanceService;


    @PutMapping()
    public Long createBalance(@RequestParam Long amount) {
        return balanceService.createBalance(amount);

    }

    @PostMapping()
    public void changeBalance(@RequestParam Long id, @RequestParam Long amount) {
        balanceService.changeBalance(id, amount);
    }

    @GetMapping("getByIds")
    public Long getBalance(@RequestParam Long id) {
       return balanceService.getBalance(id).get();
    }

}
