
package com.example.bazar.controller;

import com.example.bazar.DTO.VentaMayorDTO;
import com.example.bazar.DTO.VentaTotalDTO;
import com.example.bazar.model.Producto;
import com.example.bazar.model.Venta;
import com.example.bazar.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    private IVentaService ventaServ;
    
    //Creación:  localhost:8080/ventas/crear
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta) {
        ventaServ.saveVenta(venta);
                
        return "Venta realizada correctamente";
    }
    
    //Lista completa de ventas realizadas: localhost:8080/ventas
    @GetMapping("/ventas")
    public List<Venta> getVentas() {
        return ventaServ.getVentas();
    }
    
    //Traer una venta en particular: localhost:8080/ventas/{codigo_venta}
    @GetMapping("/ventas/{codigo_venta}")
    public Venta getVenta(@PathVariable Long codigo_venta) {
        return ventaServ.getVenta(codigo_venta);
    }
    
    //Eliminación: localhost:8080/clientes/eliminar/{codigo_venta}
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta) {
        ventaServ.deleteVenta(codigo_venta);
                
        return "Venta eliminada correctamente";
    }
    
    //Edición: localhost:8080/clientes/editar/{codigo_venta}    
    @PutMapping("/ventas/editar")
    public String editVenta(@RequestBody Venta venta) {
        ventaServ.editVenta(venta);        
        
        return "Venta editada correctamente";
    }
    
    //Obtener la lista de productos de una determinada venta: localhost:8080/ventas/productos/{codigo_venta}
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductosDeUnaVenta(@PathVariable Long codigo_venta) {
        return ventaServ.getProductosDeUnaVenta(codigo_venta);
    }
    
    //Obtener ventas de un dia
    @GetMapping("/ventas/productos/fecha")
    public List<Venta> obtenerVentasPorFecha(@RequestParam("fecha") 
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
                                            LocalDate fecha) {
        return ventaServ.obtenerVentasPorFecha(fecha);        
    }
    
    //Obtener la sumatoria del monto y también cantidad total de ventas de un determinado
    //localhost:8080/ventas/{fecha_venta}
    @GetMapping("/ventas/fecha")
    public VentaTotalDTO getMontoVentasPorFecha(@RequestParam LocalDate fecha) {
        return ventaServ.getMontoVentasPorFecha(fecha);
    }
    
    /*
    Obtener el codigo_venta, el total, la cantidad de productos, el nombre del cliente y el 
    apellido del cliente de la venta con el monto más alto de todas.
    localhost:8080/ventas/mayor_venta
    */
    @GetMapping("/ventas/mayor_venta")
    public VentaMayorDTO getVentaMayor() {
        return ventaServ.getVentaMayor();
    }



}
