package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.dto.ClienteDTO;
import one.digitalinnovation.gof.model.Cliente;

public interface ClienteService {

	Iterable<Cliente> buscarTodos();

	Cliente buscarPorId(Long id);

	Cliente inserir(ClienteDTO dto);

	Cliente atualizar(Long id, ClienteDTO dto);

	void deletar(Long id);
}
