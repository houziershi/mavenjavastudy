package com.my;

import java.math.BigInteger;

public class Account {
    //账号
    private String accountNo;
    //存款余额
    private BigInteger Deposits = new BigInteger("0");

    public Account(String accountNo) {
        this.accountNo = accountNo;
    }

    //存款
    public synchronized void saveMoney(BigInteger bigInteger) {
        this.Deposits = this.Deposits.add(bigInteger);
    }

    //取款
    public synchronized boolean WithdrawMoney(BigInteger bigInteger) {
        if (this.Deposits.compareTo(bigInteger) > 0) {
            this.Deposits = this.Deposits.subtract(bigInteger);
            return true;
        } else {
            return false;
        }
    }

    //显示账号与余额
    public synchronized void printInfo() {
        System.out.println("........" + accountNo + "........." + Deposits);
    }

}
