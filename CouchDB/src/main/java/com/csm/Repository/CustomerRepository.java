package com.csm.Repository;

import com.csm.Entity.Customer;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc="customer",viewName="all")
public interface CustomerRepository extends CouchbaseRepository<Customer, Integer> {

}
