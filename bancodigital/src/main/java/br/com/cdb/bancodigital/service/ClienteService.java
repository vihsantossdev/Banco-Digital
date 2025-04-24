package br.com.cdb.bancodigital.service;

import com.banco.entity.Cliente;
import com.banco.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> obterClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Outros métodos relacionados ao cliente, como atualizar informações, excluir, etc.
}
