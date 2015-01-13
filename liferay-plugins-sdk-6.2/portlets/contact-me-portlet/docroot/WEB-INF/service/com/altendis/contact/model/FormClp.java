/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import com.altendis.contact.service.ClpSerializer;
import com.altendis.contact.service.FormLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pif
 */
public class FormClp extends BaseModelImpl<Form> implements Form {
	public FormClp() {
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
	public long getPrimaryKey() {
		return _formId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formId", getFormId());
		attributes.put("groupId", getGroupId());
		attributes.put("createDate", getCreateDate());
		attributes.put("nom", getNom());
		attributes.put("entreprise", getEntreprise());
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

		String entreprise = (String)attributes.get("entreprise");

		if (entreprise != null) {
			setEntreprise(entreprise);
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

	@Override
	public long getFormId() {
		return _formId;
	}

	@Override
	public void setFormId(long formId) {
		_formId = formId;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setFormId", long.class);

				method.invoke(_formRemoteModel, formId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_formRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_formRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNom() {
		return _nom;
	}

	@Override
	public void setNom(String nom) {
		_nom = nom;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setNom", String.class);

				method.invoke(_formRemoteModel, nom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntreprise() {
		return _entreprise;
	}

	@Override
	public void setEntreprise(String entreprise) {
		_entreprise = entreprise;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setEntreprise", String.class);

				method.invoke(_formRemoteModel, entreprise);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelephone() {
		return _telephone;
	}

	@Override
	public void setTelephone(String telephone) {
		_telephone = telephone;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setTelephone", String.class);

				method.invoke(_formRemoteModel, telephone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_formRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComment() {
		return _comment;
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;

		if (_formRemoteModel != null) {
			try {
				Class<?> clazz = _formRemoteModel.getClass();

				Method method = clazz.getMethod("setComment", String.class);

				method.invoke(_formRemoteModel, comment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFormRemoteModel() {
		return _formRemoteModel;
	}

	public void setFormRemoteModel(BaseModel<?> formRemoteModel) {
		_formRemoteModel = formRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _formRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_formRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FormLocalServiceUtil.addForm(this);
		}
		else {
			FormLocalServiceUtil.updateForm(this);
		}
	}

	@Override
	public Form toEscapedModel() {
		return (Form)ProxyUtil.newProxyInstance(Form.class.getClassLoader(),
			new Class[] { Form.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FormClp clone = new FormClp();

		clone.setFormId(getFormId());
		clone.setGroupId(getGroupId());
		clone.setCreateDate(getCreateDate());
		clone.setNom(getNom());
		clone.setEntreprise(getEntreprise());
		clone.setTelephone(getTelephone());
		clone.setEmail(getEmail());
		clone.setComment(getComment());

		return clone;
	}

	@Override
	public int compareTo(Form form) {
		long primaryKey = form.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FormClp)) {
			return false;
		}

		FormClp form = (FormClp)obj;

		long primaryKey = form.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{formId=");
		sb.append(getFormId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", nom=");
		sb.append(getNom());
		sb.append(", entreprise=");
		sb.append(getEntreprise());
		sb.append(", telephone=");
		sb.append(getTelephone());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.altendis.contact.model.Form");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>formId</column-name><column-value><![CDATA[");
		sb.append(getFormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nom</column-name><column-value><![CDATA[");
		sb.append(getNom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entreprise</column-name><column-value><![CDATA[");
		sb.append(getEntreprise());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telephone</column-name><column-value><![CDATA[");
		sb.append(getTelephone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _formId;
	private long _groupId;
	private Date _createDate;
	private String _nom;
	private String _entreprise;
	private String _telephone;
	private String _email;
	private String _comment;
	private BaseModel<?> _formRemoteModel;
}