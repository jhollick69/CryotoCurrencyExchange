package org.copper.interview.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientBalanceRepository extends CrudRepository<Account,Integer>{

}
