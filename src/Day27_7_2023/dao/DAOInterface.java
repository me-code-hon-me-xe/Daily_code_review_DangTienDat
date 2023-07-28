package Day27_7_2023.dao;

import java.util.ArrayList;

public interface DAOInterface <T>{
    int insert (T t);

    int udpate (T t);

    int delete(T t);

    ArrayList<T> selectAll();

    T selectById(T t);

    ArrayList<T> selectByCondition(String condtition);
}
