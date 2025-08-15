
package com.example.bazar.controller;

import com.example.bazar.model.Producto;
import com.example.bazar.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productoServ;
    
    //Creación:  localhost:8080/productos/crear
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto) {
        productoServ.saveProducto(producto);
                
        return "Producto creado correctamente";
    }
    
    //Lista completa de productos: localhost:8080/productos
    @GetMapping("/productos")
    public List<Producto> getProductos() {
        return productoServ.getProductos();
    }
    
    //Traer un producto en particular: localhost:8080/productos/{codigo_producto}
    @GetMapping("/productos/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto) {
        return productoServ.getProducto(codigo_producto);
    }
        
    //Eliminación:  localhost:8080/productos/eliminar/{codigo_producto}
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto) {
        productoServ.deleteProducto(codigo_producto);
                
        return "Producto borrado corractamente";
    }
        
    //Edición:  localhost:8080/productos/editar/{codigo_producto}
    @PutMapping("/productos/editar")
    public String editProducto(@RequestBody Producto producto) {
        productoServ.editProducto(producto);
                
        return "Producto editado correctamente";
    }
    
    //Productos cuya cantidad_disponibble menor a "X": localhost:8080/productos/falta_stock
    @GetMapping("/productos/falta_stock")
    public List<Producto> getProductosPorCantidad(@RequestParam Double cantidad_disponible) {
        return productoServ.getProductosPorCantidad(cantidad_disponible);
    }



}
