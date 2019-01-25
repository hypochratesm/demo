package com.network;

import java.io.Serializable;


//파일 전송



public class FileInfo implements Serializable { //여기다가 파일을 담는다.
	private static final long serialVersionUID = 1L;
	/*
	 100 : 파일 전송 시작(파일명)
	 110 : 파일 내용 전송
	 200 : 파일 전송 종료(파일명도 같이 전송)
	 size : 전송크기(마샬링 할때 크기)
	 data : 전송 내용
	 */


    //데이터를 누적시켜서 파일로 전송하는 형태.
	private int code;
	private int size;
	private byte[] data = new byte[1024];




	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}







}
