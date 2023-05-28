package ru.theboys.deliverypointratingdataservice.enums;

public enum MessageSource {
    BROWSER("BROWSER"),
    TG_BOT("TG_BOT"),
    IMPORT("IMPORT"),
    OTHER("OTHER");

    public final String value;

    MessageSource(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
