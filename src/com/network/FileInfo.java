package com.network;

import java.io.Serializable;


//���� ����



public class FileInfo implements Serializable { //����ٰ� ������ ��´�.
	private static final long serialVersionUID = 1L;
	/*
	 100 : ���� ���� ����(���ϸ�)
	 110 : ���� ���� ����
	 200 : ���� ���� ����(���ϸ��� ���� ����)
	 size : ����ũ��(������ �Ҷ� ũ��)
	 data : ���� ����
	 */


    //�����͸� �������Ѽ� ���Ϸ� �����ϴ� ����.
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