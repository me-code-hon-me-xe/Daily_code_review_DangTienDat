package ProjectBookManagerJDBC.repository;

import java.util.ArrayList;

public interface RepositoryInterface<T> {
    int insert(T t);

    int update(T t);

    int delete(int i);

    ArrayList<T> selectAll();

    T selectById(T t);

    default ArrayList<T> selectByCondition(String condtition) {
        return new ArrayList<T>();
    };
}
