package org.openmrs.module.formdata.web.resource;

import org.openmrs.api.context.Context;
import org.openmrs.module.formdata.FormData;
import org.openmrs.module.formdata.api.FormDataService;
import org.openmrs.module.formdata.web.FormDataWebConstants;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ResponseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + "/" + FormDataWebConstants.FORM_DATA_NAMESPACE)
public class FormDataResource extends DataDelegatingCrudResource<FormData> {
	
	@Override
	public FormData getByUniqueId(String uuid) {
		return getFormDataService().getFormDataByUuid(uuid);
	}
	
	@Override
	protected void delete(FormData formData, String uuid, RequestContext requestContext) throws ResponseException {
	
	}
	
	@Override
	public FormData newDelegate() {
		return null;
	}
	
	@Override
	public FormData save(FormData formData) {
		return null;
	}
	
	@Override
	public void purge(FormData formData, RequestContext requestContext) throws ResponseException {
	
	}
	
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation representation) {
		return null;
	}
	
	private FormDataService getFormDataService() {
		return Context.getService(FormDataService.class);
	}
}
