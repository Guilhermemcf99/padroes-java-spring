package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.dto.ClienteDTO;
import one.digitalinnovation.gof.exception.RecursoNaoEncontradoException;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado com o ID: " + id));
	}

	@Override
	public Cliente inserir(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setNome(dto.getNome());
		return salvarClienteComCep(cliente, dto.getCep());
	}

	@Override
	public Cliente atualizar(Long id, ClienteDTO dto) {
		Cliente clienteBd = buscarPorId(id);
		clienteBd.setNome(dto.getNome());
		return salvarClienteComCep(clienteBd, dto.getCep());
	}

	@Override
	public void deletar(Long id) {
		Cliente clienteBd = buscarPorId(id);
		clienteRepository.delete(clienteBd);
	}

	private Cliente salvarClienteComCep(Cliente cliente, String cepSanitizado) {
		String cepClean = cepSanitizado.replaceAll("\D", "");
		
		Endereco endereco = enderecoRepository.findById(cepClean).orElseGet(() -> {
			Endereco novoEndereco = viaCepService.consultarCep(cepClean);
			if (novoEndereco != null && novoEndereco.getCep() == null) {
				novoEndereco.setCep(cepClean);
			}
			return enderecoRepository.save(novoEndereco);
		});
		
		cliente.setEndereco(endereco);
		return clienteRepository.save(cliente);
	}
}
