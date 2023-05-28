package ru.theboys.deliverypointratingdataservice.enums;

public enum MessageSource {
    TEST("test"),
    BROWSER("BROWSER"),
    TG_BOT("TG_BOT"),
    OTHER("OTHER");

    public final String value;

    MessageSource(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
