package me.faeriol.utils;

/**
 * Created by Max "Faeriol" Paradis
 */
public enum LogLevel {
    DEBUG("Debug"),
    WARN("Warn"),
    ERROR("Error"),
    CRIT("Critical");

    private String levelString;

    private LogLevel(String levelString) {
        this.levelString = levelString;
    }

    @Override
    public String toString() {
        return levelString;
    }

}
