package com.serialize.repository;

import com.serialize.dto.PersonVo;
import com.serialize.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    @Query(value = "SELECT new com.serialize.dto.PersonVo(p.name, p.category) FROM person p", nativeQuery = true)
    List<PersonVo> getPersonListVo();
}
