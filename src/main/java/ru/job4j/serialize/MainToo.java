package ru.job4j.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import javax.swing.text.MaskFormatter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class MainToo {
    public static void main(String[] args) throws IOException, JAXBException {
        final JsonClassic jsonClassic = new JsonClassic(true, 23, new Contact(34, "555"),
                new String[]{"1", "2"});

        ObjectMapper map = new ObjectMapper();

        String value = map.writeValueAsString(jsonClassic);
        JsonClassic js2 = map.readValue(value, JsonClassic.class);
        System.out.println(js2.toString());

        XMLClassic xmlClassic = new XMLClassic(true, 25, "Petr", new Contact(23, "555"),
                new String[]{"1", "2"});

        final Secuirity secuirity = new Secuirity(true, 50, new Contact(35, "555"),
                new String[]{"1st cup", "1st another cup"});

        JAXBContext jaxbContext = JAXBContext.newInstance(Secuirity.class);
        Marshaller marsh = jaxbContext.createMarshaller();
        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marsh.marshal(secuirity, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarsh = jaxbContext.createUnmarshaller();
        try (StringReader read = new StringReader(xml)) {
            Secuirity secuirity1 = (Secuirity) unmarsh.unmarshal(read);
            System.out.println(secuirity1);
        }
        System.out.println();

        JSONObject jsonObject = new JSONObject(jsonClassic);
        JSONObject jsonObject1 = new JSONObject(secuirity);
        System.out.println(jsonObject1);
        System.out.println(jsonObject);
    }
}
