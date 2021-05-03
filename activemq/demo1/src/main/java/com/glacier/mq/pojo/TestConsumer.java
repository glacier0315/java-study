package com.glacier.mq.pojo;

public class TestConsumer {
    public static void main(String[] args) {
        PojoComsumer comsumer = new PojoComsumer();
        comsumer.init();
        comsumer.getMessage("Jaycekon-MQ1");

    }
}