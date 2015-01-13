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

package com.altendis.contact.service.persistence;

import com.altendis.contact.model.Form;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see FormPersistenceImpl
 * @see FormUtil
 * @generated
 */
public interface FormPersistence extends BasePersistence<Form> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FormUtil} to access the form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the form in the entity cache if it is enabled.
	*
	* @param form the form
	*/
	public void cacheResult(com.altendis.contact.model.Form form);

	/**
	* Caches the forms in the entity cache if it is enabled.
	*
	* @param forms the forms
	*/
	public void cacheResult(
		java.util.List<com.altendis.contact.model.Form> forms);

	/**
	* Creates a new form with the primary key. Does not add the form to the database.
	*
	* @param formId the primary key for the new form
	* @return the new form
	*/
	public com.altendis.contact.model.Form create(long formId);

	/**
	* Removes the form with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formId the primary key of the form
	* @return the form that was removed
	* @throws com.altendis.contact.NoSuchFormException if a form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.altendis.contact.model.Form remove(long formId)
		throws com.altendis.contact.NoSuchFormException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.altendis.contact.model.Form updateImpl(
		com.altendis.contact.model.Form form)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the form with the primary key or throws a {@link com.altendis.contact.NoSuchFormException} if it could not be found.
	*
	* @param formId the primary key of the form
	* @return the form
	* @throws com.altendis.contact.NoSuchFormException if a form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.altendis.contact.model.Form findByPrimaryKey(long formId)
		throws com.altendis.contact.NoSuchFormException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the form with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formId the primary key of the form
	* @return the form, or <code>null</code> if a form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.altendis.contact.model.Form fetchByPrimaryKey(long formId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the forms.
	*
	* @return the forms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.altendis.contact.model.Form> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the forms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.altendis.contact.model.impl.FormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of forms
	* @param end the upper bound of the range of forms (not inclusive)
	* @return the range of forms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.altendis.contact.model.Form> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the forms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.altendis.contact.model.impl.FormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of forms
	* @param end the upper bound of the range of forms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of forms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.altendis.contact.model.Form> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the forms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of forms.
	*
	* @return the number of forms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}