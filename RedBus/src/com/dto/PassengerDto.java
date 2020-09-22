package com.dto;

import java.sql.Timestamp;

public class PassengerDto {
	private int id;
	UserDto user_id;
	TicketDto ticket_id;
	private String name;
	private String gender;
	private int age;
	private String category;
	private Timestamp order_date;

	public PassengerDto() {

	}

	public PassengerDto(int id, UserDto user_id, TicketDto ticket_id, String name, String gender, int age,
			String category, Timestamp order_date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.ticket_id = ticket_id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.category = category;
		this.order_date = order_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDto getUser_id() {
		return user_id;
	}

	public void setUser_id(UserDto user_id) {
		this.user_id = user_id;
	}

	public TicketDto getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(TicketDto ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Timestamp getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", user_id=" + user_id + ", ticket_id=" + ticket_id + ", name=" + name
				+ ", gender=" + gender + ", age=" + age + ", category=" + category + ", order_date=" + order_date + "]";
	}

}
