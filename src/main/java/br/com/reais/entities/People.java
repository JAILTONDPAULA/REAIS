package br.com.reais.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.reais.enums.Kinship;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pessoa")
public class People implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long    id;
	@Column(name="nome",length=250)
	private String  name;
	private Integer kinship;
	@ManyToMany(targetEntity = Expense.class, mappedBy = "people")
	@JsonBackReference
	List<Expense> expense = new ArrayList<>();
	
	public People() {
		
	}

	public People(Long id, String name, Kinship kinship) {
		this.id = id;
		this.name = name;
		this.kinship = kinship.getCode();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKinship() {
		return Kinship.toEnum(kinship).getDescription();
	}
	
	public Integer getKinshipCode() {
		return kinship;
	}

	public void setKinship(Kinship kinship) {
		this.kinship = kinship.getCode();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return Objects.equals(id, other.id);
	}
	
}
