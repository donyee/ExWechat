package com.ericxu131.exwechat.utils;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author eric
 */
public class JAXBUtils {

    public static <T> T parserString(String content, Class c) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(content);
            return (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException ex) {
            throw new ParserStringException(ex);
        }
    }

    public static String objectToXml(Object object, Class c) {
        try {
            JAXBContext jc = JAXBContext.newInstance(c);
            Marshaller m = jc.createMarshaller();
            StringWriter writer = new StringWriter();
            writer.append("");
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);
            m.marshal(object, writer);
            return writer.toString();
        } catch (JAXBException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
