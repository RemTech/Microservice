package com.remtech.payment.product;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Products")
public class Products {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="PRODUCT_ID")
private int pid;

@Column(name="PRODUCT_NAME")
@Nonnull
private String product_name;

@Column(name="PRODUCT_PRICE")
@Nonnull
private Double product_price;

@Column(name="PRODUCT_COLOUR")
@Nonnull
private String product_colour;

@Column(name="PRODUCT_DATE")
@Nonnull
private Date product_date;

public Products() {
	super();
}

public Products(String product_name, Double product_price, String product_colour, Date product_date) {
	super();
	this.product_name = product_name;
	this.product_price = product_price;
	this.product_colour = product_colour;
	this.product_date = product_date;
}


public Products(int pid, String product_name, Double product_price, String product_colour, Date product_date) {
	super();
	this.pid = pid;
	this.product_name = product_name;
	this.product_price = product_price;
	this.product_colour = product_colour;
	this.product_date = product_date;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getProduct_name() {
	return product_name;
}

public void setProduct_name(String product_name) {
	this.product_name = product_name;
}

public Double getProduct_price() {
	return product_price;
}

public void setProduct_price(Double product_price) {
	this.product_price = product_price;
}

public String getProduct_colour() {
	return product_colour;
}

public void setProduct_colour(String product_colour) {
	this.product_colour = product_colour;
}

public Date getProduct_date() {
	return product_date;
}

public void setProduct_date(Date product_date) {
	this.product_date = product_date;
}

@Override
public String toString() {
	return "Products [pid=" + pid + ", product_name=" + product_name + ", product_price=" + product_price
			+ ", product_colour=" + product_colour + ", product_date=" + product_date + "]";
}



}
