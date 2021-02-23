package com.beerhouse.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beerhouse.BeerNotFoundException;
import com.beerhouse.domain.Beer;
import com.beerhouse.repository.BeerRepository;

@Service
public class BeerService {

	@Autowired
	private BeerRepository beerRepository;
	
	public List<Beer> buscarTodas(){
		List<Beer> beersList = beerRepository.findAll();
		
		return beersList;
	}
	
	public Beer buscar(Integer id) {
		Optional<Beer> beerObj = beerRepository.findById(id);
		
		return beerObj.orElse(null);
	}
	
	public Beer adicionar(Beer beer) {
		Beer beerObj = beerRepository.save(beer);
		
		return beerObj;
	}
	
	public Beer alterar(Integer id, Beer beer) {
		Optional<Beer> beerObj = beerRepository.findById(id);
		
		if(beerObj.isPresent()) {
			Beer beerUpdate = beerObj.get();
			beerUpdate.setName(beer.getName());
			beerUpdate.setIngredients(beer.getIngredients());
			beerUpdate.setAlcoholContent(beer.getAlcoholContent());
			beerUpdate.setPrice(beer.getPrice());
			beerUpdate.setCategory(beer.getCategory());
			beerRepository.save(beerUpdate);
			return beerUpdate;
		}
		else {
			throw new BeerNotFoundException();
		}
	}
	
	public Beer alterarPatch(Integer id, Beer beer) {
		Optional<Beer> beerObj = beerRepository.findById(id);
		
		if(beerObj.isPresent()) {
			Beer beerUpdate = beerObj.get();
			
			if(beer.getName() != null)	
				beerUpdate.setName(beer.getName());
				
			if(beer.getIngredients() != null)
				beerUpdate.setIngredients(beer.getIngredients());
			
			if(beer.getAlcoholContent() != null)
				beerUpdate.setAlcoholContent(beer.getAlcoholContent());
			
			if(beer.getPrice() != null)
				beerUpdate.setPrice(beer.getPrice());
			
			if(beer.getCategory() != null)
				beerUpdate.setCategory(beer.getCategory());
			
			beerRepository.save(beerUpdate);
			
			return beerUpdate;
		}
		else {
			throw new BeerNotFoundException();
		}
	}
	
	public void deletar(Integer id) {
		Optional<Beer> beerObj = beerRepository.findById(id);	
		
		if(beerObj.isPresent()) {
			beerRepository.delete(beerObj.get());
		}
		else {
			throw new BeerNotFoundException();
		}
	}
}

