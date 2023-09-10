package br.com.reais.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="ORIGEM_RECEITA",uniqueConstraints = @UniqueConstraint(columnNames = "DESCRICAO", name="UK$ORIGEM_RECEITA"))
public class OriginIncome implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="DESCRICAO")
	private String description;
	
	@JsonBackReference
	@OneToMany(mappedBy = "origin")
	private List<Revenue> receitas = new ArrayList<>();
	
	public OriginIncome() {
		
	}

	public OriginIncome(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String name) {
		this.description = name;
	}


	public List<Revenue> getReceitas() {
		return receitas;
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
		OriginIncome other = (OriginIncome) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
