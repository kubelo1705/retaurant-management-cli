package filehandler;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface FileHandler<T> {
    List<T> read() throws IOException;

    void write(Collection<T> data) throws IOException;
}
