package com.smart_museum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="show_flags")
public class Flags implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private int id;  
	@Column(name="show_owner")
    private boolean owner;
	@Column(name="show_number")	
	private boolean number;
	@Column(name="show_domain")	
	private boolean domain;
	@Column(name="show_type")	
	private boolean type;
	@Column(name="show_material")	
	private boolean material;
	@Column(name="show_technique")	
	private boolean technique;
	@Column(name="show_culture")
    private boolean culture;
	@Column(name="show_period")
	private boolean period;
	@Column(name="show_value")	
	private boolean value;
	@Column(name="show_scale_of_damage")	
	private boolean scaleOfDamage;
	@Column(name="show_is_original")	
	private boolean original;
	@Column(name="show_origin_place")
    private boolean origin_place;
	@Column(name="show_storage_location")
	private boolean storageLocation;
	@Column(name="show_historic_information")	
	private boolean historicInformation;
	@Column(name="show_description")	
	private boolean description;
	@Column(name="show_restauration")	
	private boolean restauration;
	@Column(name="show_other_data")	
	private boolean otherData;
	@Column(name="show_weight")	
	private boolean weight;
	@Column(name="show_dimensions")	
	private boolean dimensions;
	@Column(name="show_author")
    private boolean author;
	@OneToOne
    @JoinColumn(name = "evidence_id")
	private Evidence evidence;
	
	public Flags() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOwner() {
		return owner;
	}

	public void setOwner(boolean owner) {
		this.owner = owner;
	}

	public boolean isNumber() {
		return number;
	}

	public void setNumber(boolean number) {
		this.number = number;
	}

	public boolean isDomain() {
		return domain;
	}

	public void setDomain(boolean domain) {
		this.domain = domain;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public boolean isMaterial() {
		return material;
	}

	public void setMaterial(boolean material) {
		this.material = material;
	}

	public boolean isTechnique() {
		return technique;
	}

	public void setTechnique(boolean technique) {
		this.technique = technique;
	}

	public boolean isCulture() {
		return culture;
	}

	public void setCulture(boolean culture) {
		this.culture = culture;
	}

	public boolean isPeriod() {
		return period;
	}

	public void setPeriod(boolean period) {
		this.period = period;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	public boolean isScaleOfDamage() {
		return scaleOfDamage;
	}

	public void setScaleOfDamage(boolean scaleOfDamage) {
		this.scaleOfDamage = scaleOfDamage;
	}

	public boolean isOriginal() {
		return original;
	}

	public void setOriginal(boolean original) {
		this.original = original;
	}

	public boolean isOrigin_place() {
		return origin_place;
	}

	public void setOrigin_place(boolean origin_place) {
		this.origin_place = origin_place;
	}

	public boolean isStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(boolean storageLocation) {
		this.storageLocation = storageLocation;
	}

	public boolean isHistoricInformation() {
		return historicInformation;
	}

	public void setHistoricInformation(boolean historicInformation) {
		this.historicInformation = historicInformation;
	}

	public boolean isDescription() {
		return description;
	}

	public void setDescription(boolean description) {
		this.description = description;
	}

	public boolean isRestauration() {
		return restauration;
	}

	public void setRestauration(boolean restauration) {
		this.restauration = restauration;
	}

	public boolean isOtherData() {
		return otherData;
	}

	public void setOtherData(boolean otherData) {
		this.otherData = otherData;
	}

	public boolean isWeight() {
		return weight;
	}

	public void setWeight(boolean weight) {
		this.weight = weight;
	}

	public boolean isDimensions() {
		return dimensions;
	}

	public void setDimensions(boolean dimensions) {
		this.dimensions = dimensions;
	}

	public boolean isAuthor() {
		return author;
	}

	public void setAuthor(boolean author) {
		this.author = author;
	}

	public Evidence getEvidence() {
		return evidence;
	}

	public void setEvidence(Evidence evidence) {
		this.evidence = evidence;
	}


	
}
