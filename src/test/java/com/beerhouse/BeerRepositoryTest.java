package com.beerhouse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.beerhouse.domain.Beer;
import com.beerhouse.repository.BeerRepository;

@DataJpaTest
class BeerRepositoryTest {

	@Autowired
	private BeerRepository beerRepository; 
	
	@Test
	void testCreateBeer() {
		Beer beerTest = new Beer();
		beerTest.setId(1);
		beerTest.setName("teste");
		
		Beer beerObjTest = beerRepository.save(beerTest);
		
		assertThat(beerObjTest.getId()).isEqualTo(1);
	}
	
	@Test
	void testFindBeer() {		
		Beer beerTest = new Beer();
		beerTest.setId(2);
		beerTest.setName("teste");
		
		Beer beerObjTest = beerRepository.save(beerTest);
		Optional<Beer> beerObjTest2 = beerRepository.findById(2);
		
		assertThat(beerObjTest2.get().getId()).isEqualTo(2);
	}
	
	@Test
	void testUpdateBeer() {		
		Beer beerTest = new Beer();
		beerTest.setId(3);
		beerTest.setName("teste");
		
		beerRepository.save(beerTest);
		Optional<Beer> beerOptTest = beerRepository.findById(3);
		
		if(beerOptTest.isPresent()) {
			beerTest.setName("outro teste");
		}
		
		beerRepository.save(beerTest);
		Optional<Beer> beerOptTest2 = beerRepository.findById(3);
		
		assertThat(beerOptTest2.get().getName()).isEqualTo("outro teste");
	}

	@Test
	void testDeleteBeer() {		
		Beer beerTest = new Beer();
		beerTest.setId(4);
		beerTest.setName("teste");
		
		Beer beerObjTest = beerRepository.save(beerTest);
		beerRepository.deleteById(4);
		
		boolean existBeer = beerRepository.findById(4).isPresent();
		
		assertThat(!existBeer);
	}

}
