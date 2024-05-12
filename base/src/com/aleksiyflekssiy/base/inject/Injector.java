package com.aleksiyflekssiy.base.inject;

import java.util.HashMap;
import java.util.Map;

public class Injector {
    //Содержит уникальные объекты контроллеров
    private static final Map<Class<?>, Object> instances = new HashMap<>();
    //Добавляет объект в мап
    public static <T> void bind(Class<T> clazz, T instance) {
        instances.put(clazz, instance);
    }
    //Даёт ссылку на уникальный объект контроллера
    public static <T> T getInstance(Class<T> clazz) {
        return clazz.cast(instances.get(clazz));
    }
}
