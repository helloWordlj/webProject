package com.lujun.webtest1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	private String userName;
	private String userPass;
	private String userSex;
	private int userAge;
	private int userTel;
	private int userQq;
	private String userEmail;
	private int userIdCard;
	private String userAddress;

	public User() {
	}

	/**
	 * @param userId
	 * @param userName
	 * @param userSex
	 * @param userAge
	 * @param userTel
	 * @param userQq
	 * @param userEmail
	 * @param userIdCard
	 * @param userAddress
	 */
	public User(Long userId, String userName, String userPass, String userSex, int userAge,
			int userTel, int userQq, String userEmail, int userIdCard,String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userSex = userSex;
		this.userAge = userAge;
		this.userTel = userTel;
		this.userQq = userQq;
		this.userEmail = userEmail;
		this.userIdCard = userIdCard;
		this.userAddress = userAddress; 
	}

	/**
	 * precision=20, 表示数值总长度 scale=0,表示小数点所占位数
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	// @SequenceGenerator(name="USERID_GENERATOR",sequenceName="SEQ_USERID")
	// @GeneratedValue(generator="USERID_GENERATOR",strategy=GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME", length = 50)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_SEX", length = 10)
	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	@Column(name = "USER_TEL")
	public int getUserTel() {
		return userTel;
	}

	public void setUserTel(int userTel) {
		this.userTel = userTel;
	}

	@Column(name = "USER_QQ")
	public int getUserQq() {
		return userQq;
	}

	public void setUserQq(int userQq) {
		this.userQq = userQq;
	}

	@Column(name = "USER_EMAIL", length = 40)
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "USER_ID_CARD")
	public int getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(int userIdCard) {
		this.userIdCard = userIdCard;
	}

	@Column(name = "USER_ADDRESS")
	public String getUserAddress() {
		return userAddress;
	}
	
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Column(name = "USER_AGE")
	public int getUserAge() {
		return userAge;
	}
	
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	@Column(name = "USER_PASS")
	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	
}
