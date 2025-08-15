
package com.example.bazar.DTO;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaTotalDTO {
    
    private int cantidad_ventas;
    private Double monto_total;
    private LocalDate fecha_consulta;

    public VentaTotalDTO() {
    }

    public VentaTotalDTO(int cantidad_ventas, Double monto_total, LocalDate fecha_consulta) {
        this.cantidad_ventas = cantidad_ventas;
        this.monto_total = monto_total;
        this.fecha_consulta = fecha_consulta;
    }
        

}
