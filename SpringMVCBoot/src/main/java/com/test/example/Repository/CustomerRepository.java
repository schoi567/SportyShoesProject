package com.test.example.Repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.test.example.entity.*;

@Repository
@Transactional
public class CustomerRepository {
	@Autowired
	EntityManager em; 

}



