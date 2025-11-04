package com.example.proyectofinalapp.service;

import com.example.proyectofinalapp.entity.Producto;
import java.util.List;

public interface ProductoService {

    Producto crearProducto(Producto producto);

    Producto obtenerPorId(Long id);

    List<Producto> listarProductos();

    List<Producto> listarPorUsuario(Long usuarioId);

    Producto actualizarProducto(Long id, Producto producto);

    void eliminarProducto(Long id);
}
