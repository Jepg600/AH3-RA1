package com.example.intecap.service;

import java.util.Optional;

import com.example.intecap.common.commonSvc;
import com.example.intecap.models.productosModel;

public interface productosService extends commonSvc<productosModel>{

    public Iterable<productosModel> findAll() {
        return productosRepository.findAll();
    };
    public Optional<productosModel> findById(int id);
    public productosModel save(productosModel entity);
    public void deleteById(int id);
    Iterable <productosModel> saveAll(Iterable<productosModel> entities);
    
} 