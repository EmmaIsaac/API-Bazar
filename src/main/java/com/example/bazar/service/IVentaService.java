
package com.example.bazar.service;

import com.example.bazar.DTO.VentaMayorDTO;
import com.example.bazar.DTO.VentaTotalDTO;
import com.example.bazar.model.Producto;
import com.example.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public void saveVenta(Venta venta);
    
    public List<Venta> getVentas();
    
    public Venta getVenta(Long codigo_venta);
    
    public void deleteVenta(Long codigo_venta);
    
    public void editVenta(Venta venta);
    
    public List<Producto> getProductosDeUnaVenta(Long codigo_venta);
    
    public List<Venta> obtenerVentasPorFecha(LocalDate fecha);
    
    public VentaTotalDTO getMontoVentasPorFecha(LocalDate fecha);
    
    public VentaMayorDTO getVentaMayor();
    
}
