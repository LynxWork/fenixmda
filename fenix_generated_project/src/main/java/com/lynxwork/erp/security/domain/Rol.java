package com.lynxwork.erp.security.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name = "Rol.findAll", query = " select o from Rol o"),
		@NamedQuery(name = "Rol.findByPropertyName", query = " select o from Rol o   where  name = :name"),
		@NamedQuery(name = "Rol.findByPropertyDescription", query = " select o from Rol o   where  description = :description"),
		@NamedQuery(name = "Rol.findByRangeName", query = "  select o from Rol o where name between :nameInitVal  and  :nameEndVal"),
		@NamedQuery(name = "Rol.findByRangeDescription", query = "  select o from Rol o where description between :descriptionInitVal  and  :descriptionEndVal"), })
@Table(name = "ROL")
public class Rol implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/********************************************************************************************* PROPERTY ENTITY DEFINITION **********************************************************************************************/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROL_ID")
	private Long rolId;
	@Column(name = "NAME", nullable = false, length = 20)
	private String name;
	@Column(name = "DESCRIPTION", nullable = true, length = 50)
	private String description;

	/********************************************************************************************* PROPERTY ACCESSORS DEFINITION *********************************************************************************************/
	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	/********************************************************************************************* PROPERTY MUTATORS DEFINITION **********************************************************************************************/
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}