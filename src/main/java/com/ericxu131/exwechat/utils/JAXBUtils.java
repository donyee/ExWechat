package com.ericxu131.exwechat.utils;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
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
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            m.marshal(object, output);
            return output.toString();
        } catch (JAXBException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
