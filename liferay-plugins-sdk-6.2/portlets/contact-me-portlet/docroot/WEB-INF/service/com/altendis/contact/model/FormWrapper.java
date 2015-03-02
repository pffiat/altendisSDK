/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.altendis.contact.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Form}.
 * </p>
 *
 * @author pif
 * @see Form
 * @generated
 */
public class FormWrapper implements Form, ModelWrapper<Form> {
	public FormWrapper(Form form) {
		_form = form;
	}

	@Override
	public Class<?> getModelClass() {
		return Form.class;
	}

	@Override
	public String getModelClassName() {
		return Form.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formId", getFormId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("nom", getNom());
		attributes.put("prenom", getPrenom());
		attributes.put("telephone", getTelephone());
		attributes.put("email", getEmail());
		attributes.put("comment", getComment());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formId = (Long)attributes.get("formId");

		if (formId != null) {
			setFormId(formId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String nom = (String)attributes.get("nom");

		if (nom != null) {
			setNom(nom);
		}

		String prenom = (String)attributes.get("prenom");

		if (prenom != null) {
			setPrenom(prenom);
		}

		String telephone = (String)attributes.get("telephone");

		if (telephone != null) {
			setTelephone(telephone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	/**
	* Returns the primary key of this form.
	*
	* @return the primary key of this form
	*/
	@Override
	public long getPrimaryKey() {
		return _form.getPrimaryKey();
	}

	/**
	* Sets the primary key of this form.
	*
	* @param primaryKey the primary key of this form
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_form.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the form ID of this form.
	*
	* @return the form ID of this form
	*/
	@Override
	public long getFormId() {
		return _form.getFormId();
	}

	/**
	* Sets the form ID of this form.
	*
	* @param formId the form ID of this form
	*/
	@Override
	public void setFormId(long formId) {
		_form.setFormId(formId);
	}

	/**
	* Returns the group ID of this form.
	*
	* @return the group ID of this form
	*/
	@Override
	public long getGroupId() {
		return _form.getGroupId();
	}

	/**
	* Sets the group ID of this form.
	*
	* @param groupId the group ID of this form
	*/
	@Override
	public void setGroupId(long groupId) {
		_form.setGroupId(groupId);
	}

	/**
	* Returns the create date of this form.
	*
	* @return the create date of this form
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _form.getCreateDate();
	}

	/**
	* Sets the create date of this form.
	*
	* @param createDate the create date of this form
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_form.setCreateDate(createDate);
	}

	/**
	* Returns the nom of this form.
	*
	* @return the nom of this form
	*/
	@Override
	public java.lang.String getNom() {
		return _form.getNom();
	}

	/**
	* Sets the nom of this form.
	*
	* @param nom the nom of this form
	*/
	@Override
	public void setNom(java.lang.String nom) {
		_form.setNom(nom);
	}

	/**
	* Returns the prenom of this form.
	*
	* @return the prenom of this form
	*/
	@Override
	public java.lang.String getPrenom() {
		return _form.getPrenom();
	}

	/**
	* Sets the prenom of this form.
	*
	* @param prenom the prenom of this form
	*/
	@Override
	public void setPrenom(java.lang.String prenom) {
		_form.setPrenom(prenom);
	}

	/**
	* Returns the telephone of this form.
	*
	* @return the telephone of this form
	*/
	@Override
	public java.lang.String getTelephone() {
		return _form.getTelephone();
	}

	/**
	* Sets the telephone of this form.
	*
	* @param telephone the telephone of this form
	*/
	@Override
	public void setTelephone(java.lang.String telephone) {
		_form.setTelephone(telephone);
	}

	/**
	* Returns the email of this form.
	*
	* @return the email of this form
	*/
	@Override
	public java.lang.String getEmail() {
		return _form.getEmail();
	}

	/**
	* Sets the email of this form.
	*
	* @param email the email of this form
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_form.setEmail(email);
	}

	/**
	* Returns the comment of this form.
	*
	* @return the comment of this form
	*/
	@Override
	public java.lang.String getComment() {
		return _form.getComment();
	}

	/**
	* Sets the comment of this form.
	*
	* @param comment the comment of this form
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_form.setComment(comment);
	}

	@Override
	public boolean isNew() {
		return _form.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_form.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _form.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_form.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _form.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _form.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_form.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _form.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_form.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_form.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_form.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FormWrapper((Form)_form.clone());
	}

	@Override
	public int compareTo(com.altendis.contact.model.Form form) {
		return _form.compareTo(form);
	}

	@Override
	public int hashCode() {
		return _form.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.altendis.contact.model.Form> toCacheModel() {
		return _form.toCacheModel();
	}

	@Override
	public com.altendis.contact.model.Form toEscapedModel() {
		return new FormWrapper(_form.toEscapedModel());
	}

	@Override
	public com.altendis.contact.model.Form toUnescapedModel() {
		return new FormWrapper(_form.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _form.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _form.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_form.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormWrapper)) {
			return false;
		}

		FormWrapper formWrapper = (FormWrapper)obj;

		if (Validator.equals(_form, formWrapper._form)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Form getWrappedForm() {
		return _form;
	}

	@Override
	public Form getWrappedModel() {
		return _form;
	}

	@Override
	public void resetOriginalValues() {
		_form.resetOriginalValues();
	}

	private Form _form;
}