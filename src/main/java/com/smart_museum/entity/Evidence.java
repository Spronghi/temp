package com.smart_museum.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="evidence")
public class Evidence implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private int id;  
	@Column(name="creation_date")
    private Date creationDate;
	@ManyToOne
    @JoinColumn(name="museum_id")
    private Museum museum;
	@Column(name="owner")
    private String owner;
	@Column(name="number")
    private int number;
	@Column(name="domain")
    private String domain;
	@Column(name="type")
    private String type;
	@Column(name="title")
    private String title;
	@Column(name="material")
    private String material;
	@Column(name="technique")
    private String technique;
	@Column(name="culture")
    private String culture;
	@Column(name="period")
    private String period;
	@Column(name="author")
    private String author;
	@Column(name="dimensions")
    private String dimensions;
	@Column(name="weight")
    private int weight;
	@Column(name="value")
    private String value;
	@Column(name="other_data")
    private String otherData;
	@Column(name="scale_of_damage")
    private String scaleOfDamage;
	@Column(name="is_original")
    private boolean isOriginal;
	@Column(name="origin_place")
    private String originPlace;
	@Column(name="storage_location")
    private String storageLocation;
	@Column(name="historic_information")
    private String historicInformation;
	@Column(name="description")
    private String description;
	@Column(name="restauration")
    private String restauration;
	@ManyToOne
    @JoinColumn(name="operator_id")
    private Operator operator;
	@Column(name="is_public")
    private boolean isPublic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Museum getMuseum() {
		return museum;
	}
	public void setMuseum(Museum museum) {
		this.museum = museum;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTechnique() {
		return technique;
	}
	public void setTechnique(String technique) {
		this.technique = technique;
	}
	public String getCulture() {
		return culture;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOtherData() {
		return otherData;
	}
	public void setOtherData(String otherData) {
		this.otherData = otherData;
	}
	public String getScaleOfDamage() {
		return scaleOfDamage;
	}
	public void setScaleOfDamage(String scaleOfDamage) {
		this.scaleOfDamage = scaleOfDamage;
	}
	public boolean isOriginal() {
		return isOriginal;
	}
	public void setOriginal(boolean isOriginal) {
		this.isOriginal = isOriginal;
	}
	public String getOriginPlace() {
		return originPlace;
	}
	public void setOriginPlace(String originPlace) {
		this.originPlace = originPlace;
	}
	public String getStorageLocation() {
		return storageLocation;
	}
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	public String getHistoricInformation() {
		return historicInformation;
	}
	public void setHistoricInformation(String historicInformation) {
		this.historicInformation = historicInformation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRestauration() {
		return restauration;
	}
	public void setRestauration(String restauration) {
		this.restauration = restauration;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public boolean isPublic() {
		return isPublic;
	}
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
}
