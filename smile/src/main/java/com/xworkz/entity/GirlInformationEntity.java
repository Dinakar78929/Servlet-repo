package com.xworkz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "girl_information")
@Data
@NoArgsConstructor

@NamedQueries({ @NamedQuery(name = "findAll", query = "select girl from GirlInformationEntity as girl"),
		@NamedQuery(name = "findByName", query = "select gf from GirlInformationEntity as gf where gf.name=:byName"),
		@NamedQuery(name = "findByLocation", query = "select loc from GirlInformationEntity as loc where loc.location=:byLocation") })

public class GirlInformationEntity {
	@Id
	@Column(name = "g_id")
	private int id;
	@Column(name = "g_name")
	private String name;
	@Column(name = "g_native")
	private String location;
	@Column(name = "g_age")
	private int age;
	@Column(name = "g_height")
	private int height;
	@Column(name = "g_weight")
	private int weight;
	@Column(name = "g_education")
	private String education;

}
