package com.beerhouse.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beerhouse.domain.Beer;
import com.beerhouse.service.BeerService;

@RestController
@RequestMapping(value="/beers")
public class BeerResource {
	
	@Autowired
	private BeerService beerService;
	
	@GetMapping("/")
	public List<Beer> getAll() {
		List<Beer> beersList = this.beerService.buscarTodas();
		
		return beersList;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Beer> get(@PathVariable Integer id) {
		Beer beerObj = this.beerService.buscar(id);
		
		return ResponseEntity.ok().body(beerObj);
	}
	
	@PostMapping("/")
	public ResponseEntity<Beer> post(@RequestBody Beer beer) {
		Beer beerObj = this.beerService.adicionar(beer);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(beerObj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Beer> put(@PathVariable Integer id, @RequestBody Beer beer) {
		Beer beerObj = this.beerService.alterar(id, beer);
		
		return ResponseEntity.ok().body(beerObj);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Beer> patch(@PathVariable Integer id, @RequestBody Beer beer) {
		Beer beerObj = this.beerService.alterarPatch(id, beer);
		
		return ResponseEntity.ok().body(beerObj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		this.beerService.deletar(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Sucesso");
	}
}
