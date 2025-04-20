package org.example.core;
import org.example.annotations.*;
import java.lang.reflect.*;
import java.util.*;
public class AnnotationContext {
    private Map<Class<?>, Object> beans = new HashMap<>();
    public AnnotationContext(List<Class<?>> classes) throws Exception {
        for (Class<?> cls : classes) {
            if (cls.isAnnotationPresent(Component.class)) {
                Constructor<?> constructor = cls.getDeclaredConstructor();
                constructor.setAccessible(true);
                Object instance = constructor.newInstance();
                beans.put(cls, instance);
            }
        }
        for (Object bean : beans.values()) {
            for (Field field : bean.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    Object dependency = beans.get(field.getType());
                    field.set(bean, dependency);
                }
            }
        }
    }
    public <T> T getBean(Class<T> cls) {
        return cls.cast(beans.get(cls));
    }
}