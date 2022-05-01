package constants;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionHandler {
    private final String FILEPATH;
    private final String FILENAME;
    public ExceptionHandler(String path) {
        this.FILEPATH = path;
        this.FILENAME = FILEPATH + "/" + "output.txt";
    }
    public  String getFile() {
        return FILENAME;
    }

    public String createFile() {
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

    public  boolean writeFile(String content) {
        try {
            FileWriter myWriter = new FileWriter(FILENAME, true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(content);
            bw.newLine();
            bw.close();
            System.out.println("Successfully wrote " + content + " to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
