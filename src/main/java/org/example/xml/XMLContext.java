package org.example.xml;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
public class XMLContext {
    private Map<String, Object> beans = new HashMap<>();
    public XMLContext(String xmlPath) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(BeansConfig.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        BeansConfig config = (BeansConfig) unmarshaller.unmarshal(new File(xmlPath));
        for (BeanDefinition bd : config.beans) {
            Class<?> cls = Class.forName(bd.className);
            Object instance = cls.getDeclaredConstructor().newInstance();
            beans.put(bd.id, instance);
        }
        for (BeanDefinition bd : config.beans) {
            Object bean = beans.get(bd.id);
            if (bd.properties != null) {
                for (Property prop : bd.properties) {
                    Field field = bean.getClass().getDeclaredField(prop.name);
                    field.setAccessible(true);
                    field.set(bean, beans.get(prop.ref));
                }
            }
        }
    }
    public Object getBean(String id) {
        return beans.get(id);
    }
}