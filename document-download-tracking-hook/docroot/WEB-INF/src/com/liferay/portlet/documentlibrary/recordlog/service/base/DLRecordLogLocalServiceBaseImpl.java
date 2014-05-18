/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.documentlibrary.recordlog.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.documentlibrary.recordlog.model.DLRecordLog;
import com.liferay.portlet.documentlibrary.recordlog.service.DLRecordLogLocalService;
import com.liferay.portlet.documentlibrary.recordlog.service.persistence.DLRecordLogPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the d l record log local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.documentlibrary.recordlog.service.impl.DLRecordLogLocalServiceImpl}.
 * </p>
 *
 * @author Jitendra Rajput
 * @see com.liferay.portlet.documentlibrary.recordlog.service.impl.DLRecordLogLocalServiceImpl
 * @see com.liferay.portlet.documentlibrary.recordlog.service.DLRecordLogLocalServiceUtil
 * @generated
 */
public abstract class DLRecordLogLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements DLRecordLogLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.documentlibrary.recordlog.service.DLRecordLogLocalServiceUtil} to access the d l record log local service.
	 */

	/**
	 * Adds the d l record log to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlRecordLog the d l record log
	 * @return the d l record log that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DLRecordLog addDLRecordLog(DLRecordLog dlRecordLog)
		throws SystemException {
		dlRecordLog.setNew(true);

		return dlRecordLogPersistence.update(dlRecordLog, false);
	}

	/**
	 * Creates a new d l record log with the primary key. Does not add the d l record log to the database.
	 *
	 * @param logId the primary key for the new d l record log
	 * @return the new d l record log
	 */
	public DLRecordLog createDLRecordLog(long logId) {
		return dlRecordLogPersistence.create(logId);
	}

	/**
	 * Deletes the d l record log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param logId the primary key of the d l record log
	 * @return the d l record log that was removed
	 * @throws PortalException if a d l record log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public DLRecordLog deleteDLRecordLog(long logId)
		throws PortalException, SystemException {
		return dlRecordLogPersistence.remove(logId);
	}

	/**
	 * Deletes the d l record log from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dlRecordLog the d l record log
	 * @return the d l record log that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public DLRecordLog deleteDLRecordLog(DLRecordLog dlRecordLog)
		throws SystemException {
		return dlRecordLogPersistence.remove(dlRecordLog);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(DLRecordLog.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return dlRecordLogPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return dlRecordLogPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return dlRecordLogPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return dlRecordLogPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public DLRecordLog fetchDLRecordLog(long logId) throws SystemException {
		return dlRecordLogPersistence.fetchByPrimaryKey(logId);
	}

	/**
	 * Returns the d l record log with the primary key.
	 *
	 * @param logId the primary key of the d l record log
	 * @return the d l record log
	 * @throws PortalException if a d l record log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DLRecordLog getDLRecordLog(long logId)
		throws PortalException, SystemException {
		return dlRecordLogPersistence.findByPrimaryKey(logId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return dlRecordLogPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the d l record logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of d l record logs
	 * @param end the upper bound of the range of d l record logs (not inclusive)
	 * @return the range of d l record logs
	 * @throws SystemException if a system exception occurred
	 */
	public List<DLRecordLog> getDLRecordLogs(int start, int end)
		throws SystemException {
		return dlRecordLogPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of d l record logs.
	 *
	 * @return the number of d l record logs
	 * @throws SystemException if a system exception occurred
	 */
	public int getDLRecordLogsCount() throws SystemException {
		return dlRecordLogPersistence.countAll();
	}

	/**
	 * Updates the d l record log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dlRecordLog the d l record log
	 * @return the d l record log that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DLRecordLog updateDLRecordLog(DLRecordLog dlRecordLog)
		throws SystemException {
		return updateDLRecordLog(dlRecordLog, true);
	}

	/**
	 * Updates the d l record log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dlRecordLog the d l record log
	 * @param merge whether to merge the d l record log with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the d l record log that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DLRecordLog updateDLRecordLog(DLRecordLog dlRecordLog, boolean merge)
		throws SystemException {
		dlRecordLog.setNew(false);

		return dlRecordLogPersistence.update(dlRecordLog, merge);
	}

	/**
	 * Returns the d l record log local service.
	 *
	 * @return the d l record log local service
	 */
	public DLRecordLogLocalService getDLRecordLogLocalService() {
		return dlRecordLogLocalService;
	}

	/**
	 * Sets the d l record log local service.
	 *
	 * @param dlRecordLogLocalService the d l record log local service
	 */
	public void setDLRecordLogLocalService(
		DLRecordLogLocalService dlRecordLogLocalService) {
		this.dlRecordLogLocalService = dlRecordLogLocalService;
	}

	/**
	 * Returns the d l record log persistence.
	 *
	 * @return the d l record log persistence
	 */
	public DLRecordLogPersistence getDLRecordLogPersistence() {
		return dlRecordLogPersistence;
	}

	/**
	 * Sets the d l record log persistence.
	 *
	 * @param dlRecordLogPersistence the d l record log persistence
	 */
	public void setDLRecordLogPersistence(
		DLRecordLogPersistence dlRecordLogPersistence) {
		this.dlRecordLogPersistence = dlRecordLogPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.liferay.portlet.documentlibrary.recordlog.model.DLRecordLog",
			dlRecordLogLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.portlet.documentlibrary.recordlog.model.DLRecordLog");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return DLRecordLog.class;
	}

	protected String getModelClassName() {
		return DLRecordLog.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = dlRecordLogPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DLRecordLogLocalService.class)
	protected DLRecordLogLocalService dlRecordLogLocalService;
	@BeanReference(type = DLRecordLogPersistence.class)
	protected DLRecordLogPersistence dlRecordLogPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private DLRecordLogLocalServiceClpInvoker _clpInvoker = new DLRecordLogLocalServiceClpInvoker();
}