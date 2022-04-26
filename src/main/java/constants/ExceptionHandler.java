package constants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExceptionHandler {
    private static final String EXCEPTION =  "exception";
    private static final String FILEPATH = System.getProperty("user.dir") + "/" + EXCEPTION + "/";
    private static final String FILENAME = FILEPATH + "output.txt";
    public ExceptionHandler() {

    }
    public static String getFile() {
        return FILENAME;
    }

    public static String createFile() {
        try {
            File myObj = new File(FILENAME);
            if (myObj.exists() && !myObj.isDirectory()) {
                return "File created";
            }
            myObj.createNewFile();
            System.out.println("File created: " + myObj.getName());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return FILENAME;
    }

    public static boolean writeFile(String content) {
        try {
            FileWriter myWriter = new FileWriter(FILENAME, true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(content);
            bw.newLine();
            bw.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
