package com.pss.backend.service.IService;

import java.util.List;

public interface ICRUDService <C,U,R,ID>{

    R save(C dto);
    R findById(ID id);
    List<R> findAll();
    R update(U dto);
    void deleteById(ID id);
}
