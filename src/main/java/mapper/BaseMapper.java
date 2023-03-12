package mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {
    List<T> mapToList(List<? extends Map> data);

    T mapToObject(Map data);
}
