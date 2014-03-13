package me.faeriol.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Simple, easy to initialize, logger
 * Created by Maxime "Faeriol" Paradis
 */
public enum Logger {
    INSTANCE;

    private boolean toSTDOut = false; //Let the default behavior be to not log
    private PrintStream fileOut; //Wont write to anyfile until initialized

    /**
     * Initializes the structure
     *
     * @param logFile  The logFile to be used
     * @param toSTDOut Indicates if we should also log to System output
     * @throws java.io.IOException
     */
    public void init(String logFile, boolean toSTDOut) throws IOException {
        File theLogFile = new File(logFile);
        theLogFile.createNewFile();
        this.fileOut = new PrintStream(theLogFile);
        this.toSTDOut = toSTDOut;
    }

    /**
     * Logs based on the conditions of the system
     *
     * @param level   The log level to use
     * @param message The message that we are logging
     */
    public void log(LogLevel level, String message) {
        String logMessage = null;
        if (null != fileOut) {
            logMessage = "[" + level.toString() + "]" + message;
            fileOut.println(logMessage);
        }
        if (toSTDOut) { //We dont care cause if we print to STDout, we are probably in dev mode anyway
            if (null == logMessage)
                logMessage = "[" + level.toString() + "]" + message;
            System.out.println(logMessage);
        }
    }


}
