package com.mediaiqdigital.spring.acl.jpa.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.mediaiqdigital.spring.acl.jpa.test.domain.Customer;
import com.mediaiqdigital.spring.acl.jpa.test.predicate.CustomerAclPredicate;
import com.mediaiqdigital.spring.acl.jpa.test.repo.CustomerAclDao;

public class CustomerAclDaoTest extends BaseTest {

	@Autowired
	CustomerAclDao customerDao;

	@Test
	public void addCustomers() throws Exception {
		List<String> sids = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;
			{
				add("prabhu@mediaiqdigital.com");
			}
		};
		Page<Customer> list = customerDao.findAll(new CustomerAclPredicate()
				.viewableFor(sids), new PageRequest(0, 10));
		System.out.println(list.getContent());
	}

}
