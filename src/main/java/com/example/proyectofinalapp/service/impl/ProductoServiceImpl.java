package com.example.proyectofinalapp.service.impl;

import com.example.proyectofinalapp.entity.Producto;
import com.example.proyectofinalapp.repository.ProductoRepository;
import com.example.proyectofinalapp.service.ProductoService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> listarPorUsuario(Long usuarioId) {
        return productoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        Producto existente = obtenerPorId(id);
        existente.setTitulo(producto.getTitulo());
        existente.setDescripcion(producto.getDescripcion());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        existente.setImagenUrl(producto.getImagenUrl());
        existente.setEstado(producto.getEstado());
        return productoRepository.save(existente);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
