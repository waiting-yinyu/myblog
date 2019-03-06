package com.alvin.springbootvue.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

import com.alvin.springbootvue.code.CardAmountCode;
import com.alvin.springbootvue.util.FileUtil;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年3月4日
*/
public class AmountCountController {
	
	/**
	 * 计算主方法
	 * @param userID 用户ID
	 * @param payAmount 商品价格
	 * @param isUseCard 是否使用赠卡
	 * @param cardAmount 赠卡价格
	 * */
	public static void amountCount(long userID,int payAmount, boolean isUseCard, String cardAmount){
		String data = getData();
		JSONArray ja = new JSONArray();
		JSONObject json = new JSONObject();
		int balance = 0;
		if(data != null) {
			try {
				json = new JSONObject(data);
				if(json.getBoolean("success")){
					ja = json.getJSONArray("userDatas");
					for(int i=0; i<ja.length(); i++){
						JSONObject jo  = ja.getJSONObject(i);
						if(jo.getLong("id") == userID){
							balance = jo.getInt("balance");
							JSONObject j = jo.getJSONArray("cardDatas").getJSONObject(0);
							if(cardAmount != null && j.getInt(cardAmount) < 1){
								System.out.println("您未拥有" + CardAmountCode.getAmount(cardAmount) + "元赠卡");
								return;
							}
							
							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(isUseCard) { // 使用赠卡
			balance = useCard(payAmount, CardAmountCode.getAmount(cardAmount),  balance);
			if(balance < 0){
				balance = 0;
			}
		} else{	// 不使用赠卡
			balance = useBalance(payAmount, 0,  balance);
			if(balance < 0){
				balance = 0;
			}
			// 更新余额
		}
		// 更新余额和赠卡数量
		updateData(userID, data, balance, cardAmount);
	}
	

	/**
	 * 使用赠卡
	 * @param payAmount 商品价格
	 * @param cardAmount 赠卡价格
	 * @param balance 用户余额
	 * */
	public static int useCard(int payAmount, int cardAmount, int balance) {
		if(payAmount > cardAmount) {	// 判断实际金额是否大于赠卡
			return useBalance(payAmount, cardAmount, balance);
		}else {
			return balance;
		}
	}
	
	/**
	 * 使用余额
	 * @param payAmount 商品价格
	 * @param cardAmount 赠卡价格
	 * @param balance 用户余额
	 * */
	public static int useBalance(int payAmount, int cardAmount, int balance) {
		if(balance <= 0){	// 判断是否存在余额
			System.out.println("您的余额不足，请使用现金支付" + (payAmount - cardAmount));
		}else {
				payAmount = payAmount - cardAmount; 	// 扣除赠卡，还需支付金额
				balance = balance - payAmount;
			if(payAmount > balance) {	//  实际余额-赠卡金额大于余额
				System.out.println("您的余额不足以支付本次交易，还需支付" + Math.abs(balance) + "元现金");
			} else{		//  实际余额-赠卡金额小于等于余额
				System.out.println("交易成功，您的余额还剩" + Math.abs(balance) + "元");
			}
		}
		return balance;
	}
	
	/**
	 * 使用现金
	 * 
	 * */
	public void useCash() {
		
	}
	
	/**
	 * 获取数据
	 * @return result 用户信息
	 * */
	public static String getData() {
		String path = ClassLoader.getSystemResource("data.json").getPath();
		path = FileUtil.normalizePath(path);
		String result = "";
		try {
			FileInputStream fin = new FileInputStream(path);
			InputStreamReader reader = new InputStreamReader(fin);
			BufferedReader buffReader = new BufferedReader(reader);
			String temp = "";
			while((temp = buffReader.readLine()) != null){
				result +=  temp;
			}
			buffReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.replace("\t", "");
	}
	
	/**
	 * 重写data.json
	 * @param 新的用户信息
	 * */
	public static void setData(String updateData) {
		String path = ClassLoader.getSystemResource("data.json").getPath();
		path = FileUtil.normalizePath(path);
		byte[] bytes = updateData.getBytes();
		try {
			FileOutputStream out = new FileOutputStream(path);
			out.write(bytes);
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新余额和赠卡数量
	 * @param cardAmount 赠卡价格
	 * @param balance 用户余额
	 * @param data 用户信息
	 * */
	public static void updateData(long userID, String data, int balance, String cardAmount) {
		JSONArray ja = new JSONArray();
		JSONObject json = new JSONObject();
		if(data != null) {
			try {
				json = new JSONObject(data);
				if(json.getBoolean("success")){
					ja = json.getJSONArray("userDatas");
					for(int i=0; i<ja.length(); i++){
						JSONObject jo = ja.getJSONObject(i);
						if(jo.getLong("id") == userID){
							jo.put("balance", balance);
							if(cardAmount != null){
								JSONObject j = jo.getJSONArray("cardDatas").getJSONObject(0);
								j.put(cardAmount, j.getInt(cardAmount) - 1);
							}
							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String updateData = json.toString();
		setData(updateData);
	}
	
	public static void main(String[] args) {
		amountCount(1001,219,true,"RMB_TWO_HUNDRED");
//		amountCount(1001,219,false,null);
	}
	 
}
