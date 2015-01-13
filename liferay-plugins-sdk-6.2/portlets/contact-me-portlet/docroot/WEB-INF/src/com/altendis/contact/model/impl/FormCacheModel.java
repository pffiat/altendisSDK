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

package com.altendis.contact.model.impl;

import com.altendis.contact.model.Form;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Form in entity cache.
 *
 * @author pif
 * @see Form
 * @generated
 */
public class FormCacheModel implements CacheModel<Form>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{formId=");
		sb.append(formId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", nom=");
		sb.append(nom);
		sb.append(", entreprise=");
		sb.append(entreprise);
		sb.append(", telephone=");
		sb.append(telephone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Form toEntityModel() {
		FormImpl formImpl = new FormImpl();

		formImpl.setFormId(formId);
		formImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			formImpl.setCreateDate(null);
		}
		else {
			formImpl.setCreateDate(new Date(createDate));
		}

		if (nom == null) {
			formImpl.setNom(StringPool.BLANK);
		}
		else {
			formImpl.setNom(nom);
		}

		if (entreprise == null) {
			formImpl.setEntreprise(StringPool.BLANK);
		}
		else {
			formImpl.setEntreprise(entreprise);
		}

		if (telephone == null) {
			formImpl.setTelephone(StringPool.BLANK);
		}
		else {
			formImpl.setTelephone(telephone);
		}

		if (email == null) {
			formImpl.setEmail(StringPool.BLANK);
		}
		else {
			formImpl.setEmail(email);
		}

		if (comment == null) {
			formImpl.setComment(StringPool.BLANK);
		}
		else {
			formImpl.setComment(comment);
		}

		formImpl.resetOriginalValues();

		return formImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		formId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		nom = objectInput.readUTF();
		entreprise = objectInput.readUTF();
		telephone = objectInput.readUTF();
		email = objectInput.readUTF();
		comment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(formId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);

		if (nom == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nom);
		}

		if (entreprise == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entreprise);
		}

		if (telephone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telephone);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}
	}

	public long formId;
	public long groupId;
	public long createDate;
	public String nom;
	public String entreprise;
	public String telephone;
	public String email;
	public String comment;
}