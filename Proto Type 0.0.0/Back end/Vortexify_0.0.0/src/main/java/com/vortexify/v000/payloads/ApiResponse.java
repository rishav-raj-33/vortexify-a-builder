package com.vortexify.v000.payloads;

public class ApiResponse {
	
	private String msg;
	private boolean sucess;
	public ApiResponse(String msg, boolean sucess) {
		super();
		this.msg = msg;
		this.sucess = sucess;
	}
	public ApiResponse() {
		super();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSucess() {
		return sucess;
	}
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}

}
