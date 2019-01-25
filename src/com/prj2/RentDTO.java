package com.prj2;

public class RentDTO implements Comparable<RentDTO>{

	private String startday;
	private String endday;

	private String car, scar;
	private String cbun, cname,cmanu,cseat,cfuel,ccolor,csize, price;
	private int carnum;
	private int sprice;

	public String getCbun() {
		return cbun;
	}

	public void setCbun(String cbun) {
		this.cbun = cbun;
	}

	private String insure;

	public int getSprice() {
		return sprice;
	}

	public void setSprice(int sprice) {
		this.sprice = sprice;
	}

	private String name,birth,tel,email,license;



	public String getStartday() {
		return startday;
	}

	public void setStartday(String startday) {
		this.startday = startday;
	}

	public String getEndday() {
		return endday;
	}

	public void setEndday(String endday) {
		this.endday = endday;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getScar() {
		return scar;
	}

	public void setScar(String scar) {
		this.scar = scar;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCmanu() {
		return cmanu;
	}

	public void setCmanu(String cmanu) {
		this.cmanu = cmanu;
	}

	public String getCseat() {
		return cseat;
	}

	public void setCseat(String cseat) {
		this.cseat = cseat;
	}

	public String getCfuel() {
		return cfuel;
	}

	public void setCfuel(String cfuel) {
		this.cfuel = cfuel;
	}

	public String getCcolor() {
		return ccolor;
	}

	public void setCcolor(String ccolor) {
		this.ccolor = ccolor;
	}

	public String getCsize() {
		return csize;
	}

	public void setCsize(String csize) {
		this.csize = csize;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getInsure() {
		return insure;
	}

	public void setInsure(String insure) {
		this.insure = insure;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public int getCarnum() {
		return carnum;
	}

	public void setCarnum(int carnum) {
		this.carnum = carnum;
	}




	public String toStringClient(){

		return String.format("이름: %s\n생년월일: %s\n연락처: %s\n이메일: %s\n", name,birth,tel,email);

	}

	public String toSrtingAdmin(){

		return String.format("%7s %8s %10s %5s %4s %6s %6s %13s %14s %10s %4s %14s"
				, cbun,cmanu,cname,csize,ccolor,cseat,cfuel,startday,endday,price,name,tel);
	}

	public String toStringCar() {

		return String.format("%7s %8s %10s %5s %4s %6s %6s %10s",cbun,cmanu,cname,csize,ccolor,cseat,cfuel,price);

	}
	public String toStringSelecCar() {

		return String.format("%7s %8s %10s %5s %4s %6s %6s   %,3d",cbun,cmanu,cname,csize,ccolor,cseat,cfuel,sprice);

	}
	public String toStringRes(){

		return String.format("%7s %8s %10s %5s %4s %6s %6s %13s %14s    %,3d %4s %14s"
				, cbun,cmanu,cname,csize,ccolor,cseat,cfuel,startday,endday,sprice,name,tel);
	}
	
	

	@Override
	public int compareTo(RentDTO list) {

		return cname.compareTo(list.getCname());
	}


}
