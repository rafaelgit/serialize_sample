package com.serialize.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.serialize.dto.PersonDto;
import com.serialize.dto.PersonVo;
import com.serialize.entity.PersonEntity;
import com.serialize.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serialize.service.PersonService;
import com.serialize.wrapper.PersonWrapper;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@GetMapping(path = "/list")
	public ResponseEntity<List<PersonWrapper>> personList() {
		return ResponseEntity.ok(service.personList());

	}

	@GetMapping(path = "/list-wrapper")
	public ResponseEntity<List<PersonWrapper>> personListWrapper() {
		return ResponseEntity.ok(service.personListWrapper());
	}

	@GetMapping(path = "/list-mapper")
	public ResponseEntity<List<PersonDto>> personListMapper() {
		List<PersonEntity> personEntity = service.personListMapper();
		List<PersonDto> personDto = personEntity.stream().map((p) -> PersonMapper.INSTANCE.personToPersonDto(p)).collect(Collectors.toList());
		return  ResponseEntity.ok(personDto);
	}

	@GetMapping(path = "/list-vo")
	public ResponseEntity<List<PersonVo>> personListVo() {
		List<PersonVo> personVo = service.personListVo();
		return ResponseEntity.ok(personVo);
	}

}
