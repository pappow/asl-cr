/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import lombok.Data;

/**
 *
 * @author Administrator
 */
@Data
@Entity
@Table(name = "xusers")
public class Xusers implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "zemail")
	private String zemail;

	@Column(name = "xaccess")
	private String xaccess;
	@Column(name = "xdformat")
	private String xdformat;
	@Column(name = "xdsep")
	private String xdsep;
	@Column(name = "xlastlogdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date xlastlogdate;
	@Column(name = "xname")
	private String xname;
	@Column(name = "xoldpass")
	private String xoldpass;
	@Column(name = "xpassword")
	private String xpassword;
	@Column(name = "xposition")
	private String xposition;
	@Column(name = "xpriority")
	private String xpriority;
	@Column(name = "xrole")
	private String xrole;
	@Column(name = "xsp")
	private String xsp;
	@Column(name = "xwh")
	private String xwh;
	@Column(name = "zactive")
	private String zactive;
	@Column(name = "zaip")
	private String zaip;
	@Column(name = "zauserid")
	@CreatedBy
	private String zauserid;
	@Column(name = "zid")
	private Integer zid;
	@Column(name = "ztime")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date ztime;
	@Column(name = "zuip")
	private String zuip;
	@Column(name = "zutime")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date zutime;
	@Column(name = "zuuserid")
	@LastModifiedBy
	private String zuuserid;
	@Column(name = "xshopno")
	private String xshopno;

	@javax.persistence.Transient
	private String roles;
}
