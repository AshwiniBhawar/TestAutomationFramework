package com.qa.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LoginTestData {
	private List<User> data;

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

	public static class User {
		private String email;
		private String password;
		private String title;
		
		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public User(String email, String password) {
			this.email = email;
			this.password = password;
		}

		public User(String email, String password, String title) {
			super();
			this.email = email;
			this.password = password;
			this.title = title;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "User [email=" + email + ", password=" + password + ", title=" + title + "]";
		}

	}

	@Override
	public String toString() {
		return "LoginTestData [data=" + data + "]";
	}
}
