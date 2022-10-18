import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        createDirectory(listOfDir(), log);
        createFile(listOfFiles(), log);
        writeLog("C://Games//temp//temp.txt", log);
    }

    public static String[] listOfDir() {
        return new String[]{
                "C://Games//scr",
                "C://Games//res",
                "C://Games//savegames",
                "C://Games//temp",
                "C://Games//scr//main",
                "C://Games//scr//test",
                "C://Games//res//drawables",
                "C://Games//res//vectors",
                "C://Games//res//icons"
        };
    }

    public static String[] listOfFiles() {
        return new String[]{
                "C://Games//scr//main//Main.java",
                "C://Games//scr//main//Utils.java",
                "C://Games//temp//temp.txt"
        };
    }

    public static void createFile(String[] listOfFiles, StringBuilder log) {
        LocalDateTime time = LocalDateTime.now();
        for (String dirFile : listOfFiles) {
            File myFile = new File(dirFile);
            try {
                if (myFile.createNewFile()) {
                    log.append("Файл " + myFile.getName() + " создан " + "в " + time);
                    log.append("\n");
                } else {
                    log.append("Файл " + myFile.getName() + " не создан, либо уже существует " + time);
                    log.append("\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void createDirectory(String[] listOfDir, StringBuilder log) {
        LocalDateTime time = LocalDateTime.now();
        for (String dirPath : listOfDir) {
            File dir = new File(dirPath);
            if (dir.mkdir()) {
                log.append("Каталог " + dir.getName() + " создан " + "в " + time);
                log.append("\n");
            } else {
                log.append("Католог " + dir.getName() + " не создан, либо уже существует " + time);
                log.append("\n");
            }

        }
    }

    public static void writeLog(String fileName, StringBuilder log) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(String.valueOf(log));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
