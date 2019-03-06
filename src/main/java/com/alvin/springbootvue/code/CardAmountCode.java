package com.alvin.springbootvue.code;

/**
 * @author: 尹宇
 * @mail yinyu@zving.com
 * @date:2019年3月4日
 */

public enum CardAmountCode {
	RMB_FIFTY("RMB_FIFTY", 50), RMB_ONE_HUNDRED("RMB_ONE_HUNDRED", 100), RMB_TWO_HUNDRED("RMB_TWO_HUNDRED", 200);

	private String currency;
	private Integer amount;

	private CardAmountCode(String currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public static int getAmount(String currency) {
		for (CardAmountCode code : CardAmountCode.values()) {
			if (code.getCurrency().equals(currency)) {
				return code.amount;
			}
		}
		return 0;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
