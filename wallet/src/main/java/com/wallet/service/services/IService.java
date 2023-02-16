package com.wallet.service.services;

import java.util.List;

public interface IService <T,Long>{
    public T save(T t);
    public boolean delete(Long l);
    public List<T> findAll();
    public T findById(Long l);


}
