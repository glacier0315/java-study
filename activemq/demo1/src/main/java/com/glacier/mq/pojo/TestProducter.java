package com.glacier.mq.pojo;

public class TestProducter {

    public static void main(String[] args) throws InterruptedException {
        PojoProducter producter = new PojoProducter();
        producter.init();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(10000);
            producter.sendMessage("Jaycekon-MQ1");
        }
    }

}