package com.kristina.dogsrestapi.pet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
    @Query("select p from Pet p where p.ownerId=:id")
    public List<Pet> getPetsByOwner(Long id);
}
