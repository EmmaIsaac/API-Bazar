
package com.example.bazar.service;

import com.example.bazar.DTO.VentaMayorDTO;
import com.example.bazar.DTO.VentaTotalDTO;
import com.example.bazar.model.Producto;
import com.example.bazar.model.Venta;
import com.example.bazar.repository.VentaRepository;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {
    
    @Autowired
    private VentaRepository ventaRepo;

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta getVenta(Long codigo_venta) {
        return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);        
    }

    @Override
    public List<Producto> getProductosDeUnaVenta(Long codigo_venta) {
        Venta ventaEncontrada = this.getVenta(codigo_venta);
        return ventaEncontrada.getListaProductos();
    }

    @Override
    public List<Venta> obtenerVentasPorFecha(LocalDate fecha) {
        return ventaRepo.findByFecha(fecha);
    }

    //Metodo que traiga un DTO con cantidad de ventas por dia y monto
    //aqui va la logica con bucles, contadores y acumuladores
    @Override
    public VentaTotalDTO getMontoVentasPorFecha(LocalDate fecha) {
        List<Venta> listaVentasPorFecha = this.obtenerVentasPorFecha(fecha);
        int cantidad = listaVentasPorFecha.size();
        Double monto = 0.0;
                
        for (Venta venta : listaVentasPorFecha) {
            monto = monto + venta.getTotal();
        }
        
        VentaTotalDTO dto = new VentaTotalDTO();
        dto.setCantidad_ventas(cantidad);
        dto.setMonto_total(monto);
        dto.setFecha_consulta(fecha);
                
        return dto;
        
    }

    @Override
    public VentaMayorDTO getVentaMayor() {
        List<Venta> listaVentas = this.getVentas();
        Venta ventaConMayorMonto = listaVentas.stream()
                                    .max(Comparator.comparingDouble(Venta::getTotal))
                                    .orElse(null);
        
        VentaMayorDTO dto = new VentaMayorDTO();
        
        if (ventaConMayorMonto != null) {
            
            dto.setCodigo_venta(ventaConMayorMonto.getCodigo_venta());
            dto.setTotal(ventaConMayorMonto.getTotal());
            dto.setCantidad_productos(ventaConMayorMonto.getListaProductos().size());
            dto.setNombre_cliente(ventaConMayorMonto.getUnCliente().getNombre());
            dto.setApellido_cliente(ventaConMayorMonto.getUnCliente().getApellido());
            
            return dto;
            
        }
        return null;
        
    }

}
