package com.serialize.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.serialize.entity.PersonEntity;
import com.serialize.wrapper.PersonWrapper;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@PersistenceContext
	private EntityManager entitymanager;
		
	public List<PersonWrapper> personList(){
		List<PersonWrapper> wrapper = new ArrayList<>();
		List<String> nameList = entitymanager.createQuery("SELECT name FROM PersonEntity", String.class)
				.getResultList();
		nameList.stream().forEach(name -> wrapper.add(new PersonWrapper(name)));
		return wrapper;
	}

	public List<PersonWrapper> personListWrapper(){
		return entitymanager.createQuery("SELECT NEW com.serialize.wrapper.PersonWrapper(p.name) FROM PersonEntity p", PersonWrapper.class)
				.getResultList();
	}

	public List<PersonEntity> personListDto(){
		return entitymanager.createQuery("SELECT p FROM PersonEntity p", PersonEntity.class)
				.getResultList();
	}

}