
package com.example.bazar.service;

import com.example.bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    public void saveCliente(Cliente cliente);
    
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Long id_cliente);
    
    public void deleteCliente(Long id_cliente);
    
    public void editCliente(Cliente cliente);
    
}
