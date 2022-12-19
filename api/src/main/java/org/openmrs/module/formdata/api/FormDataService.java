/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.formdata.api;

import javax.validation.constraints.NotNull;

import java.util.List;

import org.openmrs.Patient;
import org.openmrs.User;
import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.formdata.FormData;
import org.openmrs.module.formdata.FormDataConfig;
import org.springframework.transaction.annotation.Transactional;

/**
 * The main service of this module, which is exposed for other modules. See
 * moduleApplicationContext.xml on how it is wired up.
 */
public interface FormDataService extends OpenmrsService {
	
	/**
	 * Returns a form data item by uuid
	 * 
	 * @param uuid the uuid of the form data item to retrieve
	 * @return the form data object, if any
	 * @throws APIException if an exception occurs
	 */
	@Authorized(FormDataConfig.GET_FORM_DATA)
	@Transactional(readOnly = true)
	FormData getFormDataByUuid(@NotNull String uuid) throws APIException;
	
	@Authorized(FormDataConfig.GET_FORM_DATA)
	@Transactional(readOnly = true)
	List<FormData> getFormDataByCriteria(User user, Patient patient, List<FormData> formData);
	
	/**
	 * Saves a form data entry
	 * 
	 * @param formData the form data to save
	 * @return the saved {@link FormData} object
	 * @throws APIException if an exception occurs
	 */
	@Authorized(FormDataConfig.EDIT_FORM_DATA)
	@Transactional
	FormData saveFormData(@NotNull FormData formData) throws APIException;
	
	@Authorized(FormDataConfig.EDIT_FORM_DATA)
	@Transactional
	void voidFormData(FormData formData, String message) throws APIException;
	
	@Authorized(FormDataConfig.DELETE_FORM_DATA)
	@Transactional
	void purgeFormData(FormData formData, String message) throws APIException;
}
