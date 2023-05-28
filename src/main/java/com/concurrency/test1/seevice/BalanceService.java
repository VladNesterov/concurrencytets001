package com.concurrency.test1.seevice;

import javax.management.NotCompliantMBeanException;

/**
 * Интерфейс сервиса для работы с банковским счётом содержит два метода
 **/
interface BalanceService {
    /**
     * Получение баланса
     *
     * @param id идентификатор банковского счёта
     * @return сумма денег на банковском счёте
     */
    Long getBalance(Long id) throws NotCompliantMBeanException;

    /**
     *  Изменение баланса на определённое значение
     *
     *  @param id идентификатор банковского счёта
     *  @param amount сумма денег, которую нужно добавить к банковскому счёту
     */
    void changeBalance(Long id, Long amount);


    /**
     *  Создание баланса на определённое значение
     *
     *  @param amount сумма денег, которую нужно добавить к новому банковскому счёту
     */
    Long createBalance(Long amount);
}