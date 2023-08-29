package com.main;
public class UserInfo {
    private String name;
    private int old;
    private String gender;

    public UserInfo() {}
    public UserInfo(String name, int old, String gender) {
        this.name = name;
        this.old = old;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getOld() {
        return old;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("������� �̸�: %s, ������� ����: %d, ������� ����: %s", name, old, gender);
    }
}
