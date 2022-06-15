package com.test.example;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.test.example.Repository.UserRepository;
import com.test.example.entity.Customers;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository repo;
 
    @Test
    public void testCreateUser() {
        Customers customers = new Customers();
        customers.setEmail("ravikumar@gmail.com");
        customers.setpwd("ravi2020");
//        customers.setFirstName("Ravi");
//        customers.setLastName("Kumar");        
        Customers savedcustomers = repo.save(customers);        
        Customers existcustomers = entityManager.find(Customers.class, savedcustomers.getId());         
        assertThat(customers.getEmail()).isEqualTo(existcustomers.getEmail());
      }

}









