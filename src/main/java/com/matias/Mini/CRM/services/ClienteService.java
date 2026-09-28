package com.matias.Mini.CRM.services;

import com.matias.Mini.CRM.dto.cliente.ClienteRequestDTO;
import com.matias.Mini.CRM.dto.cliente.ClienteResponseDTO;
import com.matias.Mini.CRM.exception.EmailDuplicadoException;
import com.matias.Mini.CRM.model.Cliente;
import com.matias.Mini.CRM.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository=clienteRepository;
    }

    public List<ClienteResponseDTO> obtenerClientes(boolean mostrarTodos){
        List<Cliente> clientes;

        if (mostrarTodos){
            clientes = clienteRepository.findAll();
        }
        else {
          clientes= clienteRepository.findByActivoTrue();
        }

        return clientes.stream().map(
                cliente -> new ClienteResponseDTO(
                   cliente.getId(),
                   cliente.getNombre(),
                   cliente.getEmail(),
                   cliente.getTelefono(),
                   cliente.getEmpresa(),
                   cliente.isActivo()
                )
        ).toList();
    }

    public ClienteResponseDTO obtenerClientesId(Long id){
        Cliente clienteEncontrado = clienteRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No se ha encontrado cliente con ID "+id));
        return new ClienteResponseDTO(
                clienteEncontrado.getId(),
                clienteEncontrado.getNombre(),
                clienteEncontrado.getEmail(),
                clienteEncontrado.getTelefono(),
                clienteEncontrado.getEmpresa(),
                clienteEncontrado.isActivo()
        );
    }

    public ClienteResponseDTO crearCliente(ClienteRequestDTO clienteRequestDTO){

        if (clienteRepository.existsByEmail(clienteRequestDTO.email())){
            throw new EmailDuplicadoException("El email "+clienteRequestDTO.email()+" ya esta en uso!");
        }

        Cliente crearCliente = new Cliente(clienteRequestDTO.nombre(),clienteRequestDTO.email(),clienteRequestDTO.telefono(),clienteRequestDTO.empresa());
        Cliente guardarCliente = clienteRepository.save(crearCliente);
        return new ClienteResponseDTO(
          guardarCliente.getId(),
          guardarCliente.getNombre(),
          guardarCliente.getEmail(),
                guardarCliente.getTelefono(),
                guardarCliente.getEmpresa(),
                guardarCliente.isActivo()
        );
    }

    public ClienteResponseDTO actualizarCliente(Long id,ClienteRequestDTO clienteRequestDTO){

        if (clienteRepository.existsByEmail(clienteRequestDTO.email())){
            throw new EmailDuplicadoException("El email "+clienteRequestDTO.email()+" ya esta en uso!");
        }

        Cliente clienteEncontrado = clienteRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No se ha encontrado cliente con ID "+id));

        clienteEncontrado.setNombre(clienteRequestDTO.nombre());
        clienteEncontrado.setEmail(clienteRequestDTO.email());
        clienteEncontrado.setTelefono(clienteRequestDTO.telefono());
        clienteEncontrado.setEmpresa(clienteRequestDTO.empresa());
        Cliente guardarCliente = clienteRepository.save(clienteEncontrado);

        return new ClienteResponseDTO(
          guardarCliente.getId(),
          guardarCliente.getNombre(),
          guardarCliente.getEmail(),
          guardarCliente.getTelefono(),
          guardarCliente.getEmpresa(),
          guardarCliente.isActivo()
        );
    }

    public void borrarCliente(Long id){
        Cliente clienteEncontrado = clienteRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No se ha encontrado cliente con ID "+id));

        clienteEncontrado.setActivo(false);

        clienteRepository.save(clienteEncontrado);
    }



}
