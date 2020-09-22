package com.dto;

public class TicketDto {
	private int ticket_id;
	UserDto user_id;
	private String from_t;
	private String to_t;

	public TicketDto() {
		super();
	}

	public TicketDto(int ticket_id, UserDto user_id, String from_t, String to_t) {
		super();
		this.ticket_id = ticket_id;
		this.user_id = user_id;
		this.from_t = from_t;
		this.to_t = to_t;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public UserDto getUser_id() {
		return user_id;
	}

	public void setUser_id(UserDto user_id) {
		this.user_id = user_id;
	}

	public String getFrom_t() {
		return from_t;
	}

	public void setFrom_t(String from_t) {
		this.from_t = from_t;
	}

	public String getTo_t() {
		return to_t;
	}

	public void setTo_t(String to_t) {
		this.to_t = to_t;
	}

	@Override
	public String toString() {
		return "Ticketdto [ticket_id=" + ticket_id + ", user_id=" + user_id + ", from_t=" + from_t + ", to_t=" + to_t
				+ "]";
	}

}
