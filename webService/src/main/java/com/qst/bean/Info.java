package com.qst.bean;

import java.util.HashMap;
import java.util.Map;

public class Info {
	// 显示状态信息（success : 1 / fail : 0）
	private int code;

	// 显示提示信息
	private String tips;

	// 返回信息
	private Map<String, Object> information = new HashMap<String, Object>();

	// 处理成功
	public static Info success() {
		Info info = new Info();
		info.setCode(1);
		info.setTips("success");
		return info;
	}

	// 处理失败
	public static Info fail() {
		Info info = new Info();
		info.setCode(0);
		info.setTips("fail");
		return info;
	}
	public Info add(String inf , Object val) {
		this.getInformation().put(inf, val);
		return this;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public Map<String, Object> getInformation() {
		return information;
	}

	public void setInformation(Map<String, Object> information) {
		this.information = information;
	}

}
