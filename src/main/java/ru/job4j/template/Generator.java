package ru.job4j.template;

import java.util.Map;

public interface Generator {
    String produce(String template, Map<String, String> map);
    Boolean consistOf() throws NotFoundException;
    Boolean impossibleKey() throws UnhandledKeysException;
}
