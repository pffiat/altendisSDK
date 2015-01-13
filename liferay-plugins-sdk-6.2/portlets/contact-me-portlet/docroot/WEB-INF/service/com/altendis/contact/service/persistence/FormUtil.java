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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the form service. This utility wraps {@link FormPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see FormPersistence
 * @see FormPersistenceImpl
 * @generated
 */
public class FormUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Form form) {
		getPersistence().clearCache(form);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Form> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Form> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Form> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Form update(Form form) throws SystemException {
		return getPersistence().update(form);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Form update(Form form, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(form, serviceContext);
	}

	/**
	* Caches the form in the entity cache if it is enabled.
	*
	* @param form the form
	*/
	public static void cacheResult(com.altendis.contact.model.Form form) {
		getPersistence().cacheResult(form);
	}

	/**
	* Caches the forms in the entity cache if it is enabled.
	*
	* @param forms the forms
	*/
	public static void cacheResult(
		java.util.List<com.altendis.contact.model.Form> forms) {
		getPersistence().cacheResult(forms);
	}

	/**
	* Creates a new form with the primary key. Does not add the form to the database.
	*
	* @param formId the primary key for the new form
	* @return the new form
	*/
	public static com.altendis.contact.model.Form create(long formId) {
		return getPersistence().create(formId);
	}

	/**
	* Removes the form with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param formId the primary key of the form
	* @return the form that was removed
	* @throws com.altendis.contact.NoSuchFormException if a form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.altendis.contact.model.Form remove(long formId)
		throws com.altendis.contact.NoSuchFormException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(formId);
	}

	public static com.altendis.contact.model.Form updateImpl(
		com.altendis.contact.model.Form form)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(form);
	}

	/**
	* Returns the form with the primary key or throws a {@link com.altendis.contact.NoSuchFormException} if it could not be found.
	*
	* @param formId the primary key of the form
	* @return the form
	* @throws com.altendis.contact.NoSuchFormException if a form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.altendis.contact.model.Form findByPrimaryKey(long formId)
		throws com.altendis.contact.NoSuchFormException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(formId);
	}

	/**
	* Returns the form with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param formId the primary key of the form
	* @return the form, or <code>null</code> if a form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.altendis.contact.model.Form fetchByPrimaryKey(long formId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(formId);
	}

	/**
	* Returns all the forms.
	*
	* @return the forms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.altendis.contact.model.Form> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.altendis.contact.model.Form> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.altendis.contact.model.Form> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the forms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of forms.
	*
	* @return the number of forms
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FormPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FormPersistence)PortletBeanLocatorUtil.locate(com.altendis.contact.service.ClpSerializer.getServletContextName(),
					FormPersistence.class.getName());

			ReferenceRegistry.registerReference(FormUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FormPersistence persistence) {
	}

	private static FormPersistence _persistence;
}