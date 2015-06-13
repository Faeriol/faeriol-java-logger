package me.faeriol.utils;

/**
 * Define log levels
 * @author Maxime "Faeriol" Paradis
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
