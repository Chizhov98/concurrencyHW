package utils;

import com.google.gson.Gson;
import pogo.Laureate;
import pogo.LaureatesList;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {
    private final String filePath = "laureate.json";

    private File readFile() {
        URL resource = getClass().getClassLoader().getResource(filePath);
        if (resource == null) {
            throw new IllegalArgumentException("Not found");
        } else {
            try {
                return new File(((URL) resource).toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public LaureatesList parseToList() {
        Gson gson = new Gson();
        LaureatesList laureates = new LaureatesList();
        File file = readFile();
        try (Reader reader = new FileReader(file)) {
            laureates = gson.fromJson(reader,LaureatesList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return laureates;
    }
}
