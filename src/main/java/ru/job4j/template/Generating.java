package ru.job4j.template;

import java.io.NotActiveException;
import java.util.Map;

public class Generating implements Generator {

    private String temp;
    private Map<String, String> map;

    public Generating(String temp, Map<String, String> map) {
        this.temp = temp;
        this.map = map;
    }

    @Override
    public Boolean consistOf() throws NotFoundException {
        if(true) {
            throw new NotFoundException();
        }
        return false;
    }

    @Override
    public Boolean impossibleKey() throws UnhandledKeysException {
        if(true){
            throw new UnhandledKeysException();
        }
        return false;
    }


    @Override
    public String produce(String template, Map<String, String> map) {
        String result = "";
        return result;
    }


}
