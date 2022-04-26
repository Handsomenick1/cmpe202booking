package constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

import com.opencsv.CSVReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class CSVHandler {
    private final String ORDER =  "order";
    private final String FILEPATH = System.getProperty("user.dir") + "/" + ORDER;
    private List<String[]> list;
    private final String fileName;

    public CSVHandler(String[] header) {
        this.list = new ArrayList<>();
        this.list.add(header);
        fileName = "output.csv";
    }
    public String createFile() throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILEPATH+"/"+fileName))) {
            writer.writeAll(list);
        }
        return FILEPATH + "/" + fileName;
    }

    public void insertData(String input) throws IOException {
        String[] data = input.split(",");
        list.add(data);
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILEPATH+"/"+fileName))) {
            writer.writeAll(list);
        }
    }
    public List<String[]> readData(String filename) throws IOException, CsvValidationException {
        List<String[]> res = new ArrayList<>();
        try (
        Reader reader = Files.newBufferedReader(Paths.get(filename));
        CSVReader csvReader = new CSVReader(reader);
        )
        {
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                res.add(nextRecord);
            }
            res.remove(0);
        }
        return res;
    }
}
