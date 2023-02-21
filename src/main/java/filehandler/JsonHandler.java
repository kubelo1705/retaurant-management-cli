package filehandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

/**
 * Generic class to read and write bills,food,drink to file
 */
public class JsonHandler<T> implements FileHandler<T>{
    private static final String FILE_PATH = "./src/main/resources/data/";
    private static final String FIFE_EXTENSION = ".json";
    private String name;

    public JsonHandler(Class clazz) {
        this.name = clazz.getSimpleName();
    }

    @Override
    public List<T> read() throws IOException {
        String directory = FILE_PATH + name.toLowerCase().concat(FIFE_EXTENSION);
        ObjectMapper mapper = new ObjectMapper();
        List<T> result = mapper.readValue(Paths.get(directory).toFile(), new TypeReference<List<T>>() {
            // do nothing
        });
        return result;
    }

    @Override
    public void write(Collection<T> data) throws IOException {
        String directory = FILE_PATH + name.toLowerCase().concat(FIFE_EXTENSION);
        ObjectMapper objectMapper = new ObjectMapper();
        FileWriter fileWriter = new FileWriter(directory);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileWriter, data);
        fileWriter.close();
    }

}
