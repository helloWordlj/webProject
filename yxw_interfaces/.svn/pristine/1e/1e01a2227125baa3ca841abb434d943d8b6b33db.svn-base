/**
 * <html>
 * <body>
 *  <P>  Copyright 2014-2015 www.yx129.com Group.</p>
 *  <p>  All rights reserved.</p>
 *  <p> Created on 2015年4月28日</p>
 *  <p> Created by 申午武</p>
 *  </body>
 * </html>
 */
package com.yxw.interfaces.thread;

import java.util.List;
import java.util.Map;

import com.yxw.framework.common.spring.ext.SpringContextHolder;
import com.yxw.interfaces.constants.InterfaceConstants;
import com.yxw.interfaces.dao.DepartmentDao;
import com.yxw.interfaces.dao.FriedAndDeliveryDao;
import com.yxw.interfaces.dao.MedicalCardDao;
import com.yxw.interfaces.dao.OrderRegMedicalcardDao;
import com.yxw.interfaces.dao.RegInfoDetailDao;
import com.yxw.interfaces.dao.RegisterDoctorDao;
import com.yxw.interfaces.entity.Department;
import com.yxw.interfaces.entity.FriedAndDelivery;
import com.yxw.interfaces.entity.MedicalCard;
import com.yxw.interfaces.entity.OrderRegMedicalcard;
import com.yxw.interfaces.entity.RegInfoDetail;
import com.yxw.interfaces.entity.RegisterDoctor;

/**
 * 线程提交数据
 * @Package: com.yxw.interfaces.service.thread
 * @ClassName: InterfaceRunnable
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月9日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class InterfaceRunnable implements Runnable {

	private Object datas;
	private List<Map<String, Object>> params;
	private String methodName;

	private String type;

	private RegInfoDetailDao regInfoDetailDao = SpringContextHolder.getBean(RegInfoDetailDao.class);
	private DepartmentDao departmentDao = SpringContextHolder.getBean(DepartmentDao.class);
	private RegisterDoctorDao registerDoctorDao = SpringContextHolder.getBean(RegisterDoctorDao.class);
	private MedicalCardDao medicalCardDao = SpringContextHolder.getBean(MedicalCardDao.class);
	private OrderRegMedicalcardDao orderRegMedicalcardDao = SpringContextHolder.getBean(OrderRegMedicalcardDao.class);
	private FriedAndDeliveryDao friedAndDeliveryDao = SpringContextHolder.getBean(FriedAndDeliveryDao.class);
	
	/**
	 * @param datas
	 * @param methodName
	 * @param type
	 */
	public InterfaceRunnable(Object datas, String methodName, String type) {
		super();
		this.datas = datas;
		this.methodName = methodName;
		this.type = type;
	}

	/**
	 * @param regInfoDetails
	 * @param opType
	 */
	public InterfaceRunnable(Object datas, String methodName, String type, List<Map<String, Object>> params) {
		super();
		this.datas = datas;
		this.methodName = methodName;
		this.type = type;
		this.params = params;
	}

	@Override
	public void run() {
		if (InterfaceConstants.INTERFACE_METHOD_REGINFO.equalsIgnoreCase(methodName)) {
			synchronized (InterfaceConstants.INTERFACE_METHOD_REGINFO) {
				for (int i = 0; i < params.size(); i++) {
					Map<String, Object> map = params.get(i);
					regInfoDetailDao.deleteByParams(map);
				}

				regInfoDetailDao.batchInsert((List<RegInfoDetail>) datas);
			}
		} else if (InterfaceConstants.INTERFACE_METHOD_DEPT.equalsIgnoreCase(methodName)) {
			synchronized (InterfaceConstants.INTERFACE_METHOD_DEPT) {
				departmentDao.deleteAll();
				departmentDao.batchInsert((List<Department>) datas);
			}
		} else if (InterfaceConstants.INTERFACE_METHOD_DOCTOR.equalsIgnoreCase(methodName)) {
			synchronized (InterfaceConstants.INTERFACE_METHOD_DOCTOR) {
				registerDoctorDao.deleteAll();
				registerDoctorDao.batchInsert((List<RegisterDoctor>) datas);
			}
		} else if (InterfaceConstants.INTERFACE_METHOD_MEDICALCARD.equalsIgnoreCase(methodName)) {
			medicalCardDao.addOrUpdate((MedicalCard) datas, type);
		} else if (InterfaceConstants.INTERFACE_METHOD_ORDERREG_MEDICALCARD_ADD.equalsIgnoreCase(methodName)) {
			orderRegMedicalcardDao.add((OrderRegMedicalcard) datas);
		} else if (InterfaceConstants.INTERFACE_METHOD_ORDERREG_MEDICALCARD_DEL.equalsIgnoreCase(methodName)) {
			orderRegMedicalcardDao.deleteById((String) datas);
		} else if (InterfaceConstants.INTERFACE_METHOD_FRIED_DELIVERY.equalsIgnoreCase(methodName)) {
			friedAndDeliveryDao.addOrUpdate((FriedAndDelivery) datas, type);
		}
	}

	/**
	 * @return the datas
	 */
	public Object getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(Object datas) {
		this.datas = datas;
	}

	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @param methodName the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * @return the params
	 */
	public List<Map<String, Object>> getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(List<Map<String, Object>> params) {
		this.params = params;
	}

}
