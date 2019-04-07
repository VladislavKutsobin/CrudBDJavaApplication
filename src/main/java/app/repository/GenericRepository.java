package app.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<T, ID> {
    void create(T t) throws SQLException, ClassNotFoundException;
    List<T> findAll() throws SQLException, ClassNotFoundException;
    void update(T t) throws SQLException, ClassNotFoundException;
    void delete(ID id) throws SQLException, ClassNotFoundException;
    T getByID(ID id) throws SQLException, ClassNotFoundException;
}
