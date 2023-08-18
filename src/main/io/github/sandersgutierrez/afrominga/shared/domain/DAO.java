package io.github.sandersgutierrez.afrominga.shared.domain;

public interface DAO<T> {
    void save(T entity);
    void update(T entity);
    T search(String id);
    void delete(T entity);
}
