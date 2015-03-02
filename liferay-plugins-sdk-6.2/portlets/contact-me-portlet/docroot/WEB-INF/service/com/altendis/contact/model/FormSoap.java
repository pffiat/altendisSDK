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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pif
 * @generated
 */
public class FormSoap implements Serializable {
	public static FormSoap toSoapModel(Form model) {
		FormSoap soapModel = new FormSoap();

		soapModel.setFormId(model.getFormId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setNom(model.getNom());
		soapModel.setPrenom(model.getPrenom());
		soapModel.setTelephone(model.getTelephone());
		soapModel.setEmail(model.getEmail());
		soapModel.setComment(model.getComment());

		return soapModel;
	}

	public static FormSoap[] toSoapModels(Form[] models) {
		FormSoap[] soapModels = new FormSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FormSoap[][] toSoapModels(Form[][] models) {
		FormSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FormSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FormSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FormSoap[] toSoapModels(List<Form> models) {
		List<FormSoap> soapModels = new ArrayList<FormSoap>(models.size());

		for (Form model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FormSoap[soapModels.size()]);
	}

	public FormSoap() {
	}

	public long getPrimaryKey() {
		return _formId;
	}

	public void setPrimaryKey(long pk) {
		setFormId(pk);
	}

	public long getFormId() {
		return _formId;
	}

	public void setFormId(long formId) {
		_formId = formId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getNom() {
		return _nom;
	}

	public void setNom(String nom) {
		_nom = nom;
	}

	public String getPrenom() {
		return _prenom;
	}

	public void setPrenom(String prenom) {
		_prenom = prenom;
	}

	public String getTelephone() {
		return _telephone;
	}

	public void setTelephone(String telephone) {
		_telephone = telephone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	private long _formId;
	private long _groupId;
	private Date _createDate;
	private String _nom;
	private String _prenom;
	private String _telephone;
	private String _email;
	private String _comment;
}