package com.kristina.dogsrestapi.customer;

import com.kristina.dogsrestapi.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    @Query("select customer_id from  Customer_pets where pets_id = p")
//     void findOwnerByPetId(Pet pet, long petId);
}
