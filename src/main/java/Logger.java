import java.time.LocalDateTime;

public class Logger {
    private static Logger logger = null;
    private static int num = 1;
    private static boolean verbal = true;

    private Logger() {
    }

    public static void setVerbal(boolean verbal) {
        Logger.verbal = verbal;
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        if (verbal) {
            System.out.printf("[%-33s %3d] %s%n", LocalDateTime.now(), num++, msg);
        }
    }
}