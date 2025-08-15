
package com.example.bazar.service;

import com.example.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public void saveProducto(Producto producto);
    
    public List<Producto> getProductos();
    
    public Producto getProducto(Long codigo_producto);
    
    public void deleteProducto(Long codigo_producto);
    
    public void editProducto(Producto producto);
    
    public List<Producto> getProductosPorCantidad(Double cantidad_disponible);
    
}
