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

import com.altendis.contact.NoSuchFormException;
import com.altendis.contact.model.Form;
import com.altendis.contact.model.impl.FormImpl;
import com.altendis.contact.model.impl.FormModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pif
 * @see FormPersistence
 * @see FormUtil
 * @generated
 */
public class FormPersistenceImpl extends BasePersistenceImpl<Form>
	implements FormPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FormUtil} to access the form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FormImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FormModelImpl.ENTITY_CACHE_ENABLED,
			FormModelImpl.FINDER_CACHE_ENABLED, FormImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FormModelImpl.ENTITY_CACHE_ENABLED,
			FormModelImpl.FINDER_CACHE_ENABLED, FormImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FormModelImpl.ENTITY_CACHE_ENABLED,
			FormModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FormPersistenceImpl() {
		setModelClass(Form.class);
	}

	/**
	 * Caches the form in the entity cache if it is enabled.
	 *
	 * @param form the form
	 */
	@Override
	public void cacheResult(Form form) {
		EntityCacheUtil.putResult(FormModelImpl.ENTITY_CACHE_ENABLED,
			FormImpl.class, form.getPrimaryKey(), form);

		form.resetOriginalValues();
	}

	/**
	 * Caches the forms in the entity cache if it is enabled.
	 *
	 * @param forms the forms
	 */
	@Override
	public void cacheResult(List<Form> forms) {
		for (Form form : forms) {
			if (EntityCacheUtil.getResult(FormModelImpl.ENTITY_CACHE_ENABLED,
						FormImpl.class, form.getPrimaryKey()) == null) {
				cacheResult(form);
			}
			else {
				form.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all forms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FormImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FormImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the form.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Form form) {
		EntityCacheUtil.removeResult(FormModelImpl.ENTITY_CACHE_ENABLED,
			FormImpl.class, form.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Form> forms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Form form : forms) {
			EntityCacheUtil.removeResult(FormModelImpl.ENTITY_CACHE_ENABLED,
				FormImpl.class, form.getPrimaryKey());
		}
	}

	/**
	 * Creates a new form with the primary key. Does not add the form to the database.
	 *
	 * @param formId the primary key for the new form
	 * @return the new form
	 */
	@Override
	public Form create(long formId) {
		Form form = new FormImpl();

		form.setNew(true);
		form.setPrimaryKey(formId);

		return form;
	}

	/**
	 * Removes the form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formId the primary key of the form
	 * @return the form that was removed
	 * @throws com.altendis.contact.NoSuchFormException if a form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Form remove(long formId) throws NoSuchFormException, SystemException {
		return remove((Serializable)formId);
	}

	/**
	 * Removes the form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the form
	 * @return the form that was removed
	 * @throws com.altendis.contact.NoSuchFormException if a form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Form remove(Serializable primaryKey)
		throws NoSuchFormException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Form form = (Form)session.get(FormImpl.class, primaryKey);

			if (form == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(form);
		}
		catch (NoSuchFormException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Form removeImpl(Form form) throws SystemException {
		form = toUnwrappedModel(form);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(form)) {
				form = (Form)session.get(FormImpl.class, form.getPrimaryKeyObj());
			}

			if (form != null) {
				session.delete(form);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (form != null) {
			clearCache(form);
		}

		return form;
	}

	@Override
	public Form updateImpl(com.altendis.contact.model.Form form)
		throws SystemException {
		form = toUnwrappedModel(form);

		boolean isNew = form.isNew();

		Session session = null;

		try {
			session = openSession();

			if (form.isNew()) {
				session.save(form);

				form.setNew(false);
			}
			else {
				session.merge(form);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(FormModelImpl.ENTITY_CACHE_ENABLED,
			FormImpl.class, form.getPrimaryKey(), form);

		return form;
	}

	protected Form toUnwrappedModel(Form form) {
		if (form instanceof FormImpl) {
			return form;
		}

		FormImpl formImpl = new FormImpl();

		formImpl.setNew(form.isNew());
		formImpl.setPrimaryKey(form.getPrimaryKey());

		formImpl.setFormId(form.getFormId());
		formImpl.setGroupId(form.getGroupId());
		formImpl.setCreateDate(form.getCreateDate());
		formImpl.setNom(form.getNom());
		formImpl.setPrenom(form.getPrenom());
		formImpl.setTelephone(form.getTelephone());
		formImpl.setEmail(form.getEmail());
		formImpl.setComment(form.getComment());

		return formImpl;
	}

	/**
	 * Returns the form with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the form
	 * @return the form
	 * @throws com.altendis.contact.NoSuchFormException if a form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Form findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormException, SystemException {
		Form form = fetchByPrimaryKey(primaryKey);

		if (form == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return form;
	}

	/**
	 * Returns the form with the primary key or throws a {@link com.altendis.contact.NoSuchFormException} if it could not be found.
	 *
	 * @param formId the primary key of the form
	 * @return the form
	 * @throws com.altendis.contact.NoSuchFormException if a form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Form findByPrimaryKey(long formId)
		throws NoSuchFormException, SystemException {
		return findByPrimaryKey((Serializable)formId);
	}

	/**
	 * Returns the form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the form
	 * @return the form, or <code>null</code> if a form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Form fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Form form = (Form)EntityCacheUtil.getResult(FormModelImpl.ENTITY_CACHE_ENABLED,
				FormImpl.class, primaryKey);

		if (form == _nullForm) {
			return null;
		}

		if (form == null) {
			Session session = null;

			try {
				session = openSession();

				form = (Form)session.get(FormImpl.class, primaryKey);

				if (form != null) {
					cacheResult(form);
				}
				else {
					EntityCacheUtil.putResult(FormModelImpl.ENTITY_CACHE_ENABLED,
						FormImpl.class, primaryKey, _nullForm);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FormModelImpl.ENTITY_CACHE_ENABLED,
					FormImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return form;
	}

	/**
	 * Returns the form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formId the primary key of the form
	 * @return the form, or <code>null</code> if a form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Form fetchByPrimaryKey(long formId) throws SystemException {
		return fetchByPrimaryKey((Serializable)formId);
	}

	/**
	 * Returns all the forms.
	 *
	 * @return the forms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Form> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Form> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Form> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Form> list = (List<Form>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FORM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FORM;

				if (pagination) {
					sql = sql.concat(FormModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Form>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Form>(list);
				}
				else {
					list = (List<Form>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the forms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Form form : findAll()) {
			remove(form);
		}
	}

	/**
	 * Returns the number of forms.
	 *
	 * @return the number of forms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FORM);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the form persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.altendis.contact.model.Form")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Form>> listenersList = new ArrayList<ModelListener<Form>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Form>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(FormImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FORM = "SELECT form FROM Form form";
	private static final String _SQL_COUNT_FORM = "SELECT COUNT(form) FROM Form form";
	private static final String _ORDER_BY_ENTITY_ALIAS = "form.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Form exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FormPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment"
			});
	private static Form _nullForm = new FormImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Form> toCacheModel() {
				return _nullFormCacheModel;
			}
		};

	private static CacheModel<Form> _nullFormCacheModel = new CacheModel<Form>() {
			@Override
			public Form toEntityModel() {
				return _nullForm;
			}
		};
}