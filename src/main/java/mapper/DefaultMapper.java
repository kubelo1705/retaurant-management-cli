package mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultMapper<T> implements BaseMapper<T> {
    private ObjectMapper mapper;
    private Class clazz;

    public DefaultMapper(Class clazz) {
        this.mapper = new ObjectMapper();
        this.clazz = clazz;
    }

    @Override
    public List<T> mapToList(List<? extends Map> data) {
        List<T> result = new ArrayList<>();
        data.forEach(line -> result.add(this.mapToObject(line)));
        return result;
    }

    @Override
    public T mapToObject(Map data) {
        return (T) mapper.convertValue(data, clazz);
    }
}
