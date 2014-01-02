package com.ericxu131.exwechat.model.message;

import com.ericxu131.exwechat.model.event.SimpleEvent;
import static com.ericxu131.exwechat.model.message.MessageType.EVENT;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 *
 * @author eric
 */
public enum MessageType {

    @XmlEnumValue("text")
    TEXT,
    @XmlEnumValue("event")
    EVENT,
    @XmlEnumValue("voice")
    VOICE;

    public Class getMessageClass() {
        if (TEXT == this) {
            return TextMessage.class;
        }
        if (EVENT == this) {
            return SimpleEvent.class;
        }
        return null;
    }
}
