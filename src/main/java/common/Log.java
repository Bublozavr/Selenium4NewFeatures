package common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static Logger log = LogManager.getLogger(Log.class);

    public static void info(String message){
        log.info(message);
    }

    public static void warning(String message){ log.warn(message); }

    public static void fail(String message){
        log.error(message);
    }

}
