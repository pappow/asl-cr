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
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 *
 * @author Administrator
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "zbusiness")
@XmlRootElement
public class Zbusiness implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "zid")
	private Integer zid;

	@Column(name = "ztime", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date ztime;
	@UpdateTimestamp
	@Column(name = "zutime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date zutime;
	@Column(name = "xshopno")
	private String xshopno;
	@Column(name = "xtaxnum")
	private String xtaxnum;
	@Column(name = "zorg")
	private String zorg;
	@Column(name = "xcity")
	private String xcity;
	@Column(name = "xstate")
	private String xstate;
	@Column(name = "xzip")
	private String xzip;
	@Column(name = "xcountry")
	private String xcountry;
	@Column(name = "xphone")
	private String xphone;
	@Column(name = "xfax")
	private String xfax;
	@Column(name = "xcontact")
	private String xcontact;
	@Column(name = "xemail")
	private String xemail;
	@Column(name = "xurl")
	private String xurl;
	@Column(name = "xdformat")
	private String xdformat;
	@Column(name = "xdsep")
	private String xdsep;
	@Column(name = "xtimage")
	private String xtimage;
	@Column(name = "xbimage")
	private String xbimage;
	@Column(name = "xcustom")
	private String xcustom;
	@Column(name = "zactive")
	private String zactive;
	@Column(name = "zemail")
	private String zemail;
	@Column(name = "xmadd")
	private String xmadd;
	@CreatedBy
	@Column(name = "zauserid")
	private String zauserid;
	@LastModifiedBy
	@Column(name = "zuuserid")
	private String zuuserid;
	@Column(name = "zaip")
	private String zaip;
	@Column(name = "zuip")
	private String zuip;
	@Column(name = "xsignatory")
	private String xsignatory;
	@Column(name = "xdesignation")
	private String xdesignation;
	@Column(name = "xpadd")
	private String xpadd;
	@Column(name = "ximage")
	private String ximage;
	@Column(name = "xvatregno")
	private String xvatregno;
	@Column(name = "xtin")
	private String xtin;
	@Column(name = "xcur")
	private String xcur;
	@Column(name = "xterminal")
	private String xterminal;
	@Column(name = "xshort")
	private String xshort;
	@Column(name = "xdiv")
	private String xdiv;
}
