package com.sergiecode.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sergiecode.apirest.apirest.Entities.Producto;

public interface ProductoRespository extends JpaRepository<Producto, Long>{

}
