
package com.example.bazar.controller;

import com.example.bazar.model.Cliente;
import com.example.bazar.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService clienteServ;
    
    //Creación:  localhost:8080/clientes/crear
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente) {
        clienteServ.saveCliente(cliente);
        
        return "Cliente creado correctamenta";
    }
    
    //Lista completa de clientes: localhost:8080/clientes
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clienteServ.getClientes();
    }
    
    //Traer un cliente en particular: localhost:8080/clientes/{id_cliente}
    @GetMapping("/clientes/{id_cliente}")
    public Cliente getCliente(@PathVariable Long id_cliente) {
        return clienteServ.getCliente(id_cliente);
    }
    
    //Eliminación: localhost:8080/clientes/eliminar/{id_cliente}
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente) {
        clienteServ.deleteCliente(id_cliente);
                
        return "Cliente eliminado correctamente";
    }
    
    //Edición: localhost:8080/clientes/editar/{id_cliente}
    @PutMapping("/clientes/editar")
    public String editCliente(@RequestBody Cliente cliente) {
        clienteServ.editCliente(cliente);
                
        return "Cliente editado correctamente";
    }


}
