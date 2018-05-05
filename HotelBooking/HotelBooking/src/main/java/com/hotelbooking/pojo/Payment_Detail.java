package com.hotelbooking.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "payment_tbl")
public class Payment_Detail {

	@Id
	@Column(name="payment_id")
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="reservation"))
	private int payment_id;
	
	@OneToOne
    @PrimaryKeyJoinColumn
	private Reseravtion reservation;
	
	@Column(name = "invoice_Number")
	private int invoice_number;
	
	@Column(name = "payment_Amount")
	private int payment_amount;
	
	@Column(name = "card_Number")
	private int card_number;
	
	public Payment_Detail() {
		super();
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getInvoice_number() {
		return invoice_number;
	}

	public void setInvoice_number(int invoice_number) {
		this.invoice_number = invoice_number;
	}

	public int getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(int payment_amount) {
		this.payment_amount = payment_amount;
	}

	public int getCard_number() {
		return card_number;
	}

	public void setCard_number(int card_number) {
		this.card_number = card_number;
	}
	
	
}
