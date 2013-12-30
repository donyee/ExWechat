package com.ericxu131.exwechat.model.message;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 *
 * @author eric
 */
public enum MessageType {

    @XmlEnumValue("text")
    TEXT;

    public Class getMessageClass() {
        if (TEXT == this) {
            return TextMessage.class;
        }
        return null;
    }
}
