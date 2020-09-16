package zadanie;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import zadanie.DrinkList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Mapper {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Path eventPaths = Paths.get("/home/radoslaw/Desktop/jjddr1-drinky-winky/src/main/java/search.json");
    private String fileAsString;

    public List<DrinkList> saveJsonAsArray() {

        DrinkList[] events = null;
        if (Files.exists(eventPaths)) {
            try {
                fileAsString = Files.readString(eventPaths);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                events = mapper.reader().forType(DrinkList[].class).readValue(fileAsString);
            } catch (IOException e) {
                System.out.println("Ups! Coś poszło nie tak podczas otwierania pliku, lub odczytu, lub mapowania ");
            }
        }
        return Arrays.asList(events);
    }
}