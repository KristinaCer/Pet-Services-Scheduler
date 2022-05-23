package com.kristina.dogsrestapi.pet;

import com.kristina.dogsrestapi.pet.model.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
    @Query("select p from Pet p where p.ownerId=:id")
    public Set<Pet> getPetsByOwner(Long id);
}
