package Utils.Logs;//specifies the package in which the Log class is defined.

import org.apache.logging.log4j.LogManager;//imports the LogManager class from the Log4j framework. LogManager is used to retrieve a Logger instance.
import org.apache.logging.log4j.Logger;//imports the Logger class from the Log4j framework. The Logger class is used to log messages.

public class Log {
    //Initialize Log4j instance
    private static final Logger log = LogManager.getLogger(Log.class);
    //The above initializes a static and final Logger instance named log using the LogManager.getLogger(Log.class) method.
    // It retrieves a logger associated with the Log class.

    //Info Level Logs
    public static void info(String message) {
        //The above defines a public static method named info that takes a String parameter called message.
        // This method is used to log messages at the info level.
        log.info(message);//This line logs the provided message at the info level using the log logger.
    }

    //Warn Level Logs
    public static void warn(String message) {
        log.warn(message);
    }
    //Error Level Logs
    public static void error (String message){
        log.error(message);
    }
    //Fatal Level Logs
    public static void fatal (String message){
        log.fatal(message);
    }
    //Debug Level Logs
    public static void debug (String message){
        log.debug(message);
    }
}
