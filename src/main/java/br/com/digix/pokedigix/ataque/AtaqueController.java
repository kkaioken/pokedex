package br.com.digix.pokedigix.ataque;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoInvalidaParaCategoriaException;
import br.com.digix.pokedigix.tipo.TipoRepository;
import br.com.digix.pokedigix.tipo.TipoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = { "api/v1/ataques" }, produces = { "application/json" })
public class AtaqueController {

	@Autowired
	private AtaqueRepository ataqueRepository;

	@Autowired
	private TipoRepository tipoRepository;

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
			ataquesRetornados.add(new AtaqueResponseDTO(ataque.getId(), 0, 0, ataque.getNome(), 0, null, nome, null));
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

	@Operation(summary = "Criar um novo ataque usando um tipo")
	@ApiResponse(responseCode = "201", description = "Ataque criado usando tipo")
	@PostMapping(consumes = { "application/json" })
	public ResponseEntity<AtaqueResponseDTO> criarAtaque(@RequestBody AtaqueRequestDTO novoAtaque) {
		Tipo tipo = tipoRepository.findById(novoAtaque.getTipoId()).get();
		Ataque ataque;
		try {
			ataque = new Ataque(
					novoAtaque.getNome(),
					novoAtaque.getPA(),
					novoAtaque.getCategoria(),
					novoAtaque.getPrecisao(),
					novoAtaque.getDescricao(),
					novoAtaque.getForca(),
					tipo);

			ataqueRepository.save(ataque);

			TipoResponseDTO tipoDTO = new TipoResponseDTO(tipo.getId(), tipo.getNome());
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(new AtaqueResponseDTO(
							ataque.getId(),
							ataque.getForca(),
							ataque.getPrecisao(),
							ataque.getNome(),
							ataque.getPA(),
							ataque.getCategoria(),
							ataque.getDescricao(),
							tipoDTO));
		} catch (PrecisaoInvalidaException | ForcaInvalidaParaCategoriaException
				| TipoInvalidaParaCategoriaException e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}