package com._class;

public class Car {
	private String sManufacturer;
	private float fFuel;
	private float fSpeed;
	private int IRegistratiorNum;
	private boolean isSwitchOn;
	
	
	public Car() {}
	public Car(String sManufacturer, float fFuel) {
		this.sManufacturer = sManufacturer;
		this.fFuel = fFuel;
	}
	
	public String getsManufacturer() {
		return sManufacturer;
	}

	public void setsManufacturer(String sManufacturer) {
		this.sManufacturer = sManufacturer;
	}

	public float getfFuel() {
		return fFuel;
	}

	public void setfFuel(float fFuel) {
		this.fFuel = fFuel;
	}

	public float getfSpeed() {
		return fSpeed;
	}

	public void setfSpeed(float fSpeed) {
		this.fSpeed = fSpeed;
	}

	public int getIRegistratiorNum() {
		return IRegistratiorNum;
	}

	public void setIRegistratiorNum(int iRegistratiorNum) {
		IRegistratiorNum = iRegistratiorNum;
	}

	public boolean isSwitchOn() {
		return isSwitchOn;
	}

	public void setSwitchOn(boolean isSwitchOn) {
		this.isSwitchOn = isSwitchOn;
	}

	public void switchOn() {
		if(fFuel > 0) {
			isSwitchOn = true;
		}
	}
	
	public void switchOff() {
		isSwitchOn = false;
	}
	
	public float accerlate() {
		if(isSwitchOn && fFuel>0) {
			fSpeed ++;
			fFuel--;
			if(fSpeed > 300) {
				fSpeed = 300;
			}
			if(fFuel<0) {
				fFuel = 0;
			}
		} else if (!isSwitchOn) {
			return 0;
		}
		return fFuel;
	}
	
	public void _break() {
		if(fSpeed>0) {
			fSpeed -=5;
			if(fSpeed <0) {
				fSpeed = 0;
			}
		}
	}
	
	@Override
	public String toString() {
		return String.format("제조사: %s, 시동: %b, 현재 연료량: %f 현재 속도: %f", sManufacturer, isSwitchOn, fFuel, fSpeed);
	}
}
