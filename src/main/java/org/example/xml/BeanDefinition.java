package org.example.xml;
import jakarta.xml.bind.annotation.*;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanDefinition {
    @XmlAttribute
    public String id;
    @XmlAttribute(name = "class")
    public String className;
    @XmlElement(name = "property")
    public List<Property> properties;
}