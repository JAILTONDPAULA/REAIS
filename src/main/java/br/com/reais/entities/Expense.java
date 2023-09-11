package br.com.reais.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="despesa")
public class Expense implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long      id;
	@Column(name="descricao",length=250)
	private String    description;
	@Column(name="marca",length=250)
	private String    marca;
	@Column(name="tipo",length=250)
	private String    type;
	@Column(name="quantidade")
	private Double    quantity;
	@Column(name="tipo_quantidade")
	private Integer   qunatityType;
	@Column(name="unidade")
	private Integer   unit;
	@Column(name="ano")
	private Integer   year;
	@Column(name="mes")
	private Integer   month;
	@Column(name="data")
	private LocalDate registrationDate;
	@Column(name="observacao")
	private String    observation;
	@Column(name="mensal")
	private char      monthly;
	
	List<People> people = new ArrayList<>();
	
	public Expense() {
		
	}

	public Expense(Long id, String description, String marca, String type, Double quantity, Integer qunatityType,
			Integer unit, Integer year, Integer month, LocalDate registrationDate, String observation, char monthly) {
		this.id = id;
		this.description = description;
		this.marca = marca;
		this.type = type;
		this.quantity = quantity;
		this.qunatityType = qunatityType;
		this.unit = unit;
		this.year = year;
		this.month = month;
		this.registrationDate = registrationDate;
		this.observation = observation;
		this.monthly = monthly;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Integer getQunatityType() {
		return qunatityType;
	}

	public void setQunatityType(Integer qunatityType) {
		this.qunatityType = qunatityType;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
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

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public char getMonthly() {
		return monthly;
	}

	public void setMonthly(char monthly) {
		this.monthly = monthly;
	}

	public List<People> getPeople() {
		return people;
	}

	public void setPeople(List<People> people) {
		this.people = people;
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
		Expense other = (Expense) obj;
		return Objects.equals(id, other.id);
	}
	
}
