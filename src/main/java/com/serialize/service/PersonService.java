package com.serialize.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.serialize.dto.PersonVo;
import com.serialize.entity.PersonEntity;
import com.serialize.repository.PersonRepository;
import com.serialize.wrapper.PersonWrapper;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

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

	public List<PersonEntity> personListMapper(){
		return entitymanager.createQuery("SELECT p FROM PersonEntity p", PersonEntity.class)
				.getResultList();
	}

	public List<PersonVo> personListVo(){
		return entitymanager.createNativeQuery("SELECT p.name, p.category FROM person p", "PersonVo")
				.getResultList();
	}


}