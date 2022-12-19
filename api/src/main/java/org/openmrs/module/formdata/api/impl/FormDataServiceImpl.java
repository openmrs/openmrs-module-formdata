/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.formdata.api.impl;

import java.util.List;
import java.util.Optional;

import org.openmrs.Patient;
import org.openmrs.User;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.formdata.FormData;
import org.openmrs.module.formdata.api.FormDataService;
import org.openmrs.module.formdata.api.dao.FormDataDao;

public class FormDataServiceImpl extends BaseOpenmrsService implements FormDataService {
	
	FormDataDao dao;
	
	public void setDao(FormDataDao dao) {
		this.dao = dao;
	}
	
	@Override
	public FormData getFormDataByUuid(String uuid) throws APIException {
		return dao.getFormDataByUuid(uuid);
	}
	
	@Override
	public List<FormData> getFormDataByCriteria(User user, Patient patient, List<FormData> formData) {
		return dao.getFormDataByCriteria(Optional.ofNullable(user), Optional.ofNullable(patient),
				Optional.ofNullable(formData));
	}
	
	@Override
	public FormData saveFormData(FormData formData) throws APIException {
		return dao.saveFormData(formData);
	}
	
	@Override
	public void voidFormData(FormData formData, String message) throws APIException {
		dao.saveFormData(formData);
	}
	
	@Override
	public void purgeFormData(FormData formData, String message) throws APIException {
		dao.saveFormData(formData);
	}
}
