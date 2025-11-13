import java.io.*;

public abstract class ResultSaver {
    public static boolean saveToFile(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            PrintStream ps = new PrintStream(fos);
            ps.println(OnewayQueue.showQueue());
            ps.close();
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isFileExist(String fileName) {
        File f = new File(fileName);
        return f.exists();
    }
}