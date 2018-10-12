import java.io.*;
import java.util.Calendar;

public class FirstLogger {
    public static final String FILENAME = "LOGFILE";
    public static void main(String[] args) throws IOException {
        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(FILENAME))); )
        {
            String line = null;
            int index = 0;
            do {
                line = reader.readLine();
                if (line != null) {
                    writer.println("[" + index + "] " + line);
                    index++;
                }
            } while (line != null && !line.isEmpty());
            Calendar rightNow = Calendar.getInstance();
            System.out.println(
                    "Zugriff aufgezeichnet am " +
                            rightNow.get(Calendar.DAY_OF_MONTH) + "." + rightNow.get(Calendar.MONTH) + "." +
                            rightNow.get(Calendar.YEAR) + ", " +
                            rightNow.get(Calendar.HOUR_OF_DAY) + ":" + rightNow.get(Calendar.MINUTE));
        } catch (Exception e) {
            throw e;
        }
    }
}
