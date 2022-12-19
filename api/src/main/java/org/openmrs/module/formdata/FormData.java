/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.formdata;

import lombok.Getter;
import lombok.Setter;
import org.openmrs.BaseOpenmrsData;
import org.openmrs.Form;
import org.openmrs.Patient;
import org.openmrs.User;
import org.openmrs.api.db.ClobDatatypeStorage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formdata_form_data")
@Getter
@Setter
public class FormData extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column(name = "form_data_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;
	
	@ManyToOne
	@JoinColumn(name = "form", nullable = false)
	private Form form;
	
	@ManyToOne
	@JoinColumn(name = "patient", nullable = false)
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name = "data", nullable = false)
	private ClobDatatypeStorage data;
}
