package com.serialize.entity;

import com.serialize.dto.PersonVo;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Person")
@SqlResultSetMapping(name = "PersonVo",
        classes = @ConstructorResult(
                targetClass = PersonVo.class,
                columns = {@ColumnResult(name = "name"),
                        @ColumnResult(name = "category")}
        )
)
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "category", length = 200)
    private String category;

    public PersonEntity() {
    }

    public PersonEntity(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
