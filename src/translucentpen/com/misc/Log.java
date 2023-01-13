package translucentpen.com.misc;
// I M P O R T S
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

// C L A S S  D E F I N I T I O N
/**
 * Class Definition for Log.
 *
 * Log is a simple support class doing nothing but logging.
 * No log4j, no unwanted payload etc...
 * Just write a log file, append content nothing else
 *
 * @author Patrick Ebert
 * @version 0.01
 */
public class Log
{
    // S T A T I C  C O N S T A N T S
    /**
     * logFileName: defaultName for logfiles "translucentpen.com.log"
     *
     * @author Patrick Ebert
     * @version 0.01
     */
    public static final String logFileName = "translucentpen.com.log";

    // S T A T I C  M E T H O D E S
    /**
     * calls log(String fileName, String message) fileName is set as "translucent.com.log"
     *
     * @param message
     */
    public static void log(String message){log(Log.logFileName,message);}

    /**
     * opens a Filewriter for fileName
     * appends LocalTime.now() + ";" + message + "\r\n"
     * closes fileWriter
     * returns nothing. Catches IOException and sends ioEx localized message to STDOUT
     *
     * @param fileName Name of the logfile
     * @param message Message to write into the logfile
     *
     */
    public static void log(String fileName, String message)
    {
        try
        {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(LocalDateTime.now() + ";" + message + "\r\n");
            fw.close();
        }catch(IOException ioEx)
        {
            System.out.println(ioEx.getLocalizedMessage());
        }
    }
}
