/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.formdata.api.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.Patient;
import org.openmrs.User;
import org.openmrs.module.formdata.FormData;
import org.springframework.stereotype.Repository;

@Repository("formdata.FormDataDao")
public class FormDataDao {
	
	private final SessionFactory sessionFactory;
	
	public FormDataDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public FormData getFormDataByUuid(String uuid) {
		return getSession().createQuery("select fd from FormData fd where fd.uuid = :uuid", FormData.class)
				.setParameter("uuid", uuid)
				.uniqueResult();
	}
	
	public List<FormData> getFormDataByCriteria(Optional<User> user, Optional<Patient> patient, Optional<List<FormData>> forms) {
		Session session = getSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<FormData> query = cb.createQuery(FormData.class);
		Root<FormData> root = query.from(FormData.class);
		
		user.ifPresent(value -> query.where(cb.equal(root.get("user"), value)));
		patient.ifPresent(value -> query.where(cb.equal(root.get("patient"), value)));
		forms.ifPresent(
				f -> query.where(cb.or(f.stream().map(form -> cb.equal(root.get("form"), form)).toArray(Predicate[]::new))));
		
		return session.createQuery(query).getResultList();
	}
	
	public FormData saveFormData(FormData formData) {
		getSession().saveOrUpdate(formData);
		return formData;
	}
}
