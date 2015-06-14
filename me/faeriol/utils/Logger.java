package me.faeriol.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Simple, easy to initialize, logger
 * @author Maxime "Faeriol" Paradis
 * https://github.com/Faeriol/faeriol-java-logger
 */
public enum Logger {
    INSTANCE;

    private boolean toSTDOut = false; //Let the default behavior be to not log
    private PrintStream fileOut; //Wont write to any file until initialized

    /**
     * Initializes the logger
     *
     * @param logFile  The logFile to be used
     * @param toSTDOut Indicates if we should also log to System output
     * @throws java.io.IOException
     */
    public void init(String logFile, boolean toSTDOut) throws IOException {
	    if(null!=logFile){
	        File theLogFile = new File(logFile);
	        theLogFile.createNewFile();
	        this.fileOut = new PrintStream(theLogFile);
        }
        this.toSTDOut = toSTDOut;
    }
    
    /**
     * Initializes the for console output only
     * @throws IOException
     */
    public void init() throws IOException {
    	this.init(null, true);
    }

    /**
     * Logs based on the conditions of the system
     *
     * @param level   The log level to use
     * @param message The message that we are logging
     */
    public void log(LogLevel level, String message) {
        log(level.toString(), message);
    }
    
    /**
     * Log the message with the given ID
     *
     * @param level   The log level to use
     * @param message The message that we are logging
     */
    public void log(String id, String message){
    	String logMessage = null;
        if (null != fileOut) {
            logMessage = "[" + id + "]" + message;
            fileOut.println(logMessage);
        }
        if (toSTDOut) {
            if (null == logMessage)
                logMessage = "[" + id + "]" + message;
            System.out.println(logMessage);
        }
    }
    
    /**
     * Uses the instance to log
     * 
     * @param level    The log level to use
     * @param message  The message that we are logging
     */
    public static void logWLevel(LogLevel level, String message){
    	INSTANCE.log(level, message);
    }
    
    /**
     * Uses the instance to log
     * 
     * @param level    The log level to use
     * @param message  The message that we are logging
     */
    public static void logWID(String id, String message){
    	INSTANCE.log(id, message);
    }
    
    
    /**
     * Logs an info message
     * 
     * @param message  The message to log
     */
    public static void info(String message){
    	logWLevel(LogLevel.INFO, message);
    }
    
    /**
     * Logs an debug message
     * 
     * @param message  The message to log
     */
    public static void debug(String message){
    	logWLevel(LogLevel.DEBUG, message);
    }
    
    /**
     * Logs an warn message
     * 
     * @param message  The message to log
     */
    public static void warn(String message){
    	logWLevel(LogLevel.WARN, message);
    }
    
    /**
     * Logs an error message
     * 
     * @param message  The message to log
     */
    public static void error(String message){
    	logWLevel(LogLevel.ERROR, message);
    }
    
    /**
     * Logs an CRIT message
     * 
     * @param message  The message to log
     */
    public static void crit(String message){
    	logWLevel(LogLevel.CRIT, message);
    }


}
