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

import org.springframework.stereotype.Component;

/**
 * Contains module's config.
 */
@Component("formdata.FormDataConfig")
public class FormDataConfig {
	
	public final static String GET_FORM_DATA = "Get Form Data";
	
	public final static String EDIT_FORM_DATA = "Edit Form Data";
	
	public static final String DELETE_FORM_DATA = "Delete Form Data";
}
