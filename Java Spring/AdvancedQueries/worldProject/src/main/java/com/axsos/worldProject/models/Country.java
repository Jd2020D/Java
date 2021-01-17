package com.axsos.worldProject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="countries")
public class Country {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
		@PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }
		@PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
	@Size(min=1,max=3)
	private String code;
	@Size(min=1,max=52)
	private String name;
	String continent;
	@Size(max=26)
	private String region;
	private Double surface_area;
	private Short indep_year;
	private Integer population;
	private Double life_expectancy;
	private Double gnp;
	private Double gnp_old;
	private String local_name;
	private String goverment_form;
	private String head_of_state;
	private Integer capital;
	private String code2;
    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<City> cities;
    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Language> languages;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Double getSurface_area() {
		return surface_area;
	}
	public void setSurface_area(Double surface_area) {
		this.surface_area = surface_area;
	}
	public Short getIndep_year() {
		return indep_year;
	}
	public void setIndep_year(Short indep_year) {
		this.indep_year = indep_year;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Double getLife_expectancy() {
		return life_expectancy;
	}
	public void setLife_expectancy(Double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}
	public Double getGnp() {
		return gnp;
	}
	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}
	public Double getGnp_old() {
		return gnp_old;
	}
	public void setGnp_old(Double gnp_old) {
		this.gnp_old = gnp_old;
	}
	public String getLocal_name() {
		return local_name;
	}
	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}
	public String getGoverment_form() {
		return goverment_form;
	}
	public void setGoverment_form(String goverment_form) {
		this.goverment_form = goverment_form;
	}
	public String getHead_of_state() {
		return head_of_state;
	}
	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}
	public Integer getCapital() {
		return capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	
}
