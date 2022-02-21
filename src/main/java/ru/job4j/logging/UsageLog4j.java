package ru.job4j.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug");
        LOG.info("info");
        LOG.warn("warning");
        LOG.error("error");
        String name = "Fred";
        int age = 35;
        float money = 21;
        double dept = 25.999;
        LOG.debug("User info : {} name, age : {}, money : {}, dept : {}", name, age, money, dept);
    }

}
