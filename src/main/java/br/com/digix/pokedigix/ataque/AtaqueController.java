package br.com.digix.pokedigix.ataque;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.digix.pokedigix.tipo.TipoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = { "api/v1/ataques" }, produces = { "application/json" })
public class AtaqueController {

	@Autowired
	private AtaqueRepository ataqueRepository;

	@Operation(summary = "Buscar todos os tipos sem ordem")
	@ApiResponse(responseCode = "200", description = "Lista de tipos cadastrados")
	@GetMapping
	public ResponseEntity<Collection<AtaqueResponseDTO>> buscarTodos(
			@RequestParam(required = false, name = "termo") String nome) {
		Iterable<Ataque> ataques = ataqueRepository.findByTipoContaining(nome);
		if (nome != null) {
			ataques = ataqueRepository.findByTipoContaining(nome);
		} else {
			ataques = ataqueRepository.findAll();
		}
		Collection<AtaqueResponseDTO> ataquesRetornados = new ArrayList<>();
		for (Ataque ataque : ataques) {
			ataquesRetornados.add(new AtaqueResponseDTO(
				ataque.getId(),
				ataque.getForca(),
				ataque.getPrecisao(),
				ataque.getNome(),
				ataque.getPA(),
				ataque.getCategoria(),
				ataque.getDescricao(),
				tipoResponseDTO));
		}
		return ResponseEntity.ok(ataquesRetornados);
	}

	@Operation(summary = "Buscar um ataque pelo id")
	@ApiResponse(responseCode = "200", description = "Retorna os dados do ataque solicitado")
	@GetMapping(path = "/{id}")
	public ResponseEntity<AtaqueResponseDTO> buscarPorId(@PathVariable Long id) {
		Ataque ataque = ataqueRepository.findById(id).get();

		TipoResponseDTO tipoResponseDTO = new TipoResponseDTO(
				ataque.getTipo().getId(),
				ataque.getTipo().getNome());

		return ResponseEntity.ok(new AtaqueResponseDTO(
				ataque.getId(),
				ataque.getForca(),
				ataque.getPrecisao(),
				ataque.getNome(),
				ataque.getPA(),
				ataque.getCategoria(),
				ataque.getDescricao(),
				tipoResponseDTO));
	}
}