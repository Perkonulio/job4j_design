package ru.job4j.serialize;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
@XmlRootElement(name = "contact")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Contact implements Serializable {
    @XmlAttribute
    private static final long serialVersionUID = 1L;
    private  int zipCode;
    private  String phone;

    public Contact() {
        super();
    }

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "zipCode=" + zipCode +
                ", phone='" + phone + '\'' +
                '}';
    }
}
