
package com.example.bazar.service;

import com.example.bazar.model.Producto;
import com.example.bazar.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private ProductoRepository productoRepo;

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto getProducto(Long codigo_producto) {
        return productoRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productoRepo.deleteById(codigo_producto);
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);        
    }

    @Override
    public List<Producto> getProductosPorCantidad(Double cantidad_disponible) {
        List<Producto> productosBajoStock = productoRepo.findProductosConStockMenorA(cantidad_disponible);
        return productosBajoStock;
    }

}
