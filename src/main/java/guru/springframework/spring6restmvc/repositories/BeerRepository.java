package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BeerRepository extends JpaRepository<Beer, UUID>{

    List<Beer> findAllByBeerNameIsLikeIgnoreCase(String beerName);

}
