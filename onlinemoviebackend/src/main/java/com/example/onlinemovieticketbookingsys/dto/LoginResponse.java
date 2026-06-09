package com.example.onlinemovieticketbookingsys.dto;

public class LoginResponse {
	 private String token;
	    private String role;
	    private int userId;
	    private String name;

	    public LoginResponse(String token, String role,int userId,String name) {
	        this.token = token;
	        this.role = role;
	        this.userId=userId;
	        this.name=name;
	    }

	    public String getToken() {
	        return token;
	    }

	    public String getRole() {
	        return role;
	    }

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	    
	    
}
