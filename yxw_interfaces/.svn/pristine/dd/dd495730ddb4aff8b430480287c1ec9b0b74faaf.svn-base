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
package com.yxw.interfaces.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.CollectionUtils;

import com.yxw.framework.common.cache.impl.FixedCacheManager;
import com.yxw.framework.common.spring.ext.SpringContextHolder;
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
 * 初始化数据
 * @Package: com.yxw.interfaces.service
 * @ClassName: LoadDatas
 * @Statement: <p></p>
 * @JDK version used: 
 * @Author: 申午武
 * @Create Date: 2015年7月3日
 * @modify By:
 * @modify Date:
 * @Why&What is modify:
 * @Version: 1.0
 */
public class LoadDatas implements InitializingBean {
	protected static Logger logger = Logger.getLogger(LoadDatas.class);
	private DepartmentDao departmentDao = SpringContextHolder.getBean(DepartmentDao.class);
	private MedicalCardDao medicalCardDao = SpringContextHolder.getBean(MedicalCardDao.class);
	private RegInfoDetailDao regInfoDetailDao = SpringContextHolder.getBean(RegInfoDetailDao.class);
	private RegisterDoctorDao registerDoctorDao = SpringContextHolder.getBean(RegisterDoctorDao.class);
	private OrderRegMedicalcardDao orderRegMedicalcardDao = SpringContextHolder.getBean(OrderRegMedicalcardDao.class);
	private FriedAndDeliveryDao friedAndDeliveryDao = SpringContextHolder.getBean(FriedAndDeliveryDao.class);
	/**
	 * 每核Cpu负载的最大线程队列数
	 */
	private static final int POOL_SIZE = 2;

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("load MedicalCard data start....");
		// 根据机器配置得出默认的线程数
		int cpuNums = Runtime.getRuntime().availableProcessors();
		int threadNum = cpuNums * POOL_SIZE;
		//分页计算
		int count = medicalCardDao.count().intValue();
		int pageNum = 0;
		int lastSize = 0;
		int pageSize = 1000;
		if (count % pageSize != 0) {
			pageNum = count / pageSize + 1;
			lastSize = count % pageSize;
		} else {
			pageNum = count / pageSize;
		}
		if (pageNum > 0 && pageNum < threadNum) {
			threadNum = pageNum;
		}

		// 设置线程池的数量
		ExecutorService collectExec = Executors.newFixedThreadPool(threadNum);
		List<FutureTask<List<MedicalCard>>> taskList = new ArrayList<FutureTask<List<MedicalCard>>>();
		for (int i = 0; i < pageNum; i++) {
			//起始,结束位置计算
			int beginIndex = i * pageSize;
			int endIndex = 0;
			if (lastSize > 0 && i + 1 >= pageNum) {
				endIndex = beginIndex + lastSize;
			} else {
				endIndex = beginIndex + pageSize;
			}
			LoadMedicalcardTasker loadMedicalcardTasker = new LoadMedicalcardTasker(beginIndex, endIndex);
			// 创建每条指令的采集任务对象
			FutureTask<List<MedicalCard>> collectTask = new FutureTask<List<MedicalCard>>(loadMedicalcardTasker);
			// 添加到list,方便后面取得结果
			taskList.add(collectTask);
			// 提交给线程池 exec.submit(task);
			collectExec.submit(collectTask);
		}

		logger.info("load Department data start....");
		List<Department> departments = departmentDao.findAll();
		Map<String, Department> departmentMap = new HashMap<String, Department>();
		for (Department department : departments) {
			departmentMap.put(department.getDeptCode(), department);
		}
		FixedCacheManager.put("departments", departmentMap);
		logger.info("load Department data end....");
		logger.info("可挂号科室记录共计" + departments.size() + "条");

		logger.info("load RegisterDoctor data start....");
		List<RegisterDoctor> registerDoctors = registerDoctorDao.findAll();
		Map<String, RegisterDoctor> registerDoctorMap = new HashMap<String, RegisterDoctor>();
		for (RegisterDoctor registerDoctor : registerDoctors) {
			registerDoctorMap.put(registerDoctor.getDoctorCode(), registerDoctor);
		}
		try {
			FixedCacheManager.put("registerDoctors", registerDoctorMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("load RegisterDoctor data end....");
		logger.info("可挂号医生记录共计" + registerDoctors.size() + "条");

		logger.info("load RegInfoDetail data start....");
		//分页计算
		int regInfoDetailThreadNum = cpuNums * POOL_SIZE;
		int regInfoDetailcount = regInfoDetailDao.count().intValue();
		int regInfoDetailPageNum = 0;
		int regInfoDetailLastSize = 0;
		int regInfoDetailPageSize = 1000;
		if (regInfoDetailcount % regInfoDetailPageSize != 0) {
			regInfoDetailPageNum = regInfoDetailcount / regInfoDetailPageSize + 1;
			regInfoDetailLastSize = regInfoDetailcount % regInfoDetailPageSize;
		} else {
			regInfoDetailPageNum = regInfoDetailcount / regInfoDetailPageSize;
		}
		if (regInfoDetailPageNum > 0 && regInfoDetailPageNum < regInfoDetailThreadNum) {
			regInfoDetailThreadNum = regInfoDetailPageNum;
		}

		// 设置线程池的数量
		ExecutorService regInfoDetailCollectExec = Executors.newFixedThreadPool(threadNum);
		List<FutureTask<List<RegInfoDetail>>> regInfoDetailTaskList = new ArrayList<FutureTask<List<RegInfoDetail>>>();
		for (int i = 0; i < regInfoDetailPageNum; i++) {
			//起始,结束位置计算
			int beginIndex = i * regInfoDetailPageSize;
			int endIndex = 0;
			if (regInfoDetailLastSize > 0 && i + 1 >= regInfoDetailPageNum) {
				endIndex = beginIndex + regInfoDetailLastSize;
			} else {
				endIndex = beginIndex + regInfoDetailPageSize;
			}
			LoadRegInfoDetailTasker loadRegInfoDetailTasker = new LoadRegInfoDetailTasker(beginIndex, endIndex);
			// 创建每条指令的采集任务对象
			FutureTask<List<RegInfoDetail>> collectTask = new FutureTask<List<RegInfoDetail>>(loadRegInfoDetailTasker);
			// 添加到list,方便后面取得结果
			regInfoDetailTaskList.add(collectTask);
			// 提交给线程池 exec.submit(task);
			regInfoDetailCollectExec.submit(collectTask);
		}

		logger.info("load OrderRegMedicalcard data start....");
		List<OrderRegMedicalcard> orderRegMedicalcards = orderRegMedicalcardDao.findAll();
		Map<String, OrderRegMedicalcard> orderRegMedicalcardMap = new HashMap<String, OrderRegMedicalcard>();
		for (OrderRegMedicalcard orderRegMedicalcard : orderRegMedicalcards) {
			orderRegMedicalcardMap.put(orderRegMedicalcard.getLockId(), orderRegMedicalcard);
			FixedCacheManager.put("orderRegMedicalcard_" + orderRegMedicalcard.getLockId(), orderRegMedicalcard);
		}
		FixedCacheManager.put("orderRegMedicalcards", orderRegMedicalcardMap);
		logger.info("load OrderRegMedicalcard data end....");
		logger.info("挂号诊疗信息共计" + orderRegMedicalcards.size() + "条");

		logger.info("load FriedAndDelivery data start....");
		List<FriedAndDelivery> friedAndDeliverys = friedAndDeliveryDao.findAll();
		for (FriedAndDelivery friedAndDelivery : friedAndDeliverys) {
			FixedCacheManager.put("friedAndDelivery_" + friedAndDelivery.getBranchCode() + "_" + 
					friedAndDelivery.getMzFeeId() + "_" + friedAndDelivery.getRecipeId(), friedAndDelivery);
		}
		logger.info("load FriedAndDelivery data end....");
		logger.info("代煎配送信息共计" + friedAndDeliverys.size() + "条");
		
		//等待患者信息加载完成
		List<MedicalCard> allMedicalCards = new ArrayList<MedicalCard>();
		// 阻塞主线程,等待所有子线程结束,获取所有子线程的执行结果,get方法阻塞主线程,再继续执行主线程逻辑
		try {
			for (FutureTask<List<MedicalCard>> taskF : taskList) {
				// 防止某个子线程查询时间过长 超过默认时间没有拿到抛出异常
				List<MedicalCard> cards = taskF.get(Long.MAX_VALUE, TimeUnit.DAYS);
				if (!CollectionUtils.isEmpty(cards)) {
					allMedicalCards.addAll(cards);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 处理完毕,关闭线程池,这个不能在获取子线程结果之前关闭,因为如果线程多的话,执行中的可能被打断
		regInfoDetailCollectExec.shutdown();

		if (!CollectionUtils.isEmpty(allMedicalCards)) {
			for (MedicalCard medicalCard : allMedicalCards) {
				FixedCacheManager.put("medicalCard_" + medicalCard.getPatCardNo() + "_" + medicalCard.getPatCardType(), medicalCard);
			}
		}

		logger.info("load MedicalCard data end....");
		logger.info("患者信息记录共计" + allMedicalCards.size() + "条");

		//等待号源明细信息加载完成
		List<RegInfoDetail> allRegInfoDetails = new ArrayList<RegInfoDetail>();
		// 阻塞主线程,等待所有子线程结束,获取所有子线程的执行结果,get方法阻塞主线程,再继续执行主线程逻辑
		try {
			for (FutureTask<List<RegInfoDetail>> taskF : regInfoDetailTaskList) {
				// 防止某个子线程查询时间过长 超过默认时间没有拿到抛出异常
				List<RegInfoDetail> regDetails = taskF.get(Long.MAX_VALUE, TimeUnit.DAYS);
				if (!CollectionUtils.isEmpty(regDetails)) {
					allRegInfoDetails.addAll(regDetails);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 处理完毕,关闭线程池,这个不能在获取子线程结果之前关闭,因为如果线程多的话,执行中的可能被打断
		collectExec.shutdown();

		Map<String, Map<String, RegInfoDetail>> regInfoDetailMap = new HashMap<String, Map<String, RegInfoDetail>>();
		for (RegInfoDetail regInfoDetail : allRegInfoDetails) {
			String key = "regInfoDetails_" + regInfoDetail.getRegDate() + "_" + regInfoDetail.getBranchCode() + "_" + regInfoDetail.getDeptCode();
			String childKey = regInfoDetail.getRegDate() + "_" + regInfoDetail.getDoctorCode() + "_" + regInfoDetail.getTimeFlag();
			if (regInfoDetailMap.containsKey(key)) {
				Map<String, RegInfoDetail> tempMap = regInfoDetailMap.get(key);
				tempMap.put(childKey, regInfoDetail);
				regInfoDetailMap.put(key, tempMap);
			} else {
				Map<String, RegInfoDetail> tempMap = new HashMap<String, RegInfoDetail>();
				tempMap.put(childKey, regInfoDetail);
				regInfoDetailMap.put(key, tempMap);
			}
		}

		if (regInfoDetailMap.size() > 0) {
			for (Map.Entry<String, Map<String, RegInfoDetail>> entry : regInfoDetailMap.entrySet()) {
				//更新缓存
				FixedCacheManager.put(entry.getKey(), entry.getValue());
			}
		}
		logger.info("load RegInfoDetail data end....");
		logger.info("号源信息明细记录共计" + allRegInfoDetails.size() + "条");

	}
}
