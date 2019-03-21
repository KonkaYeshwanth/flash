package com.micro.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="devicekey")
	private long deviceKey;

    @Column(name="serialid")
	private String serialId;

    @Column(name="customer")
	private String customer;

	public Product(long deviceKey, String serialId, String customer) {
		super();
		this.deviceKey = deviceKey;
		this.serialId = serialId;
		this.customer = customer;
	}

	public long getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(long deviceKey) {
		this.deviceKey = deviceKey;
	}

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Product [deviceKey=" + deviceKey + ", serialId=" + serialId + ", customer=" + customer + "]";
	}

}
