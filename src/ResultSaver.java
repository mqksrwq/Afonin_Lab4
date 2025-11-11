import java.io.*;

public abstract class ResultSaver {
    public static boolean saveToFile(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.println(OnewayQueue.showQueue());
            pw.close();
            return true;
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла:" + e.getMessage());
            return false;
        }
    }
}