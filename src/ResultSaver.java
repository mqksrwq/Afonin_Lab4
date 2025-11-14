import java.io.*;

/**
 * Абстрактный класс для сохранения данных в файл
 */
public abstract class ResultSaver {

    /**
     * Статический метод для сохранения данных в файл
     *
     * @param fileName - название файла для сохранения
     * @return true, если данные были сохранены, false - в противном случае
     */
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

    /**
     * Статический метод, проверяющий существование файла
     *
     * @param fileName - название файла
     * @return true/false, если файл существует/отсутствует
     */
    public static boolean isFileExist(String fileName) {
        File f = new File(fileName);
        return f.exists();
    }
}
