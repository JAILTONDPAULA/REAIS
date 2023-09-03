package br.com.reais.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="RECEITA")
public class Revenue implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long    id;
	@Column(name="ANO")
	private Integer year;
	@Column(name="MÊS")
	private Integer month;
	@Column(name="VALOR")
	private Double  value;
	@Column(name="OBSERVACAO")
	private String  observation;
	@Column(name="DT_REGISTRO")
	private LocalDate  registrationDate;
	
	@ManyToOne
	@JoinColumn(name="ID_RECEITA")
	private OriginIncome origin;
	
	public Revenue() {
		
	}

	public Revenue(Long id, Integer year, Integer month, Double value, String observation, LocalDate registrationDate) {
		super();
		this.id = id;
		this.year = year;
		this.month = month;
		this.value = value;
		this.observation = observation;
		this.registrationDate = registrationDate;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Long getId() {
		return id;
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
		Revenue other = (Revenue) obj;
		return Objects.equals(id, other.id);
	}
	
}
