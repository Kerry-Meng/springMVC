package com.softtron.springmvc.domains;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TUser {
	private String username;
	private String password;
	private Date date;
	

	public long getDate() {
		//SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//return sd.format(date);
		return date.getTime();
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "TUser [username=" + username + ", password=" + password + ", date=" + date + "]";
	}
	

}
