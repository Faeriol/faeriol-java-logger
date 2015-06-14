package me.faeriol.utils;

/**
 * Define log levels
 * @author Maxime "Faeriol" Paradis
 * https://github.com/Faeriol/faeriol-java-logger
 */
public enum LogLevel {
    DEBUG("Debug"),
    WARN("Warn"),
    ERROR("Error"),
    CRIT("Critical"),
    INFO("Info");

    private String levelString;

    private LogLevel(String levelString) {
        this.levelString = levelString;
    }

    @Override
    public String toString() {
        return levelString;
    }

}
