package org.example.xml;
import jakarta.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
public class Property {
    @XmlAttribute
    public String name;
    @XmlAttribute
    public String ref;
}