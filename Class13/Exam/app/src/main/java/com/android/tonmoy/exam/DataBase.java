package com.android.tonmoy.exam;

public class DataBase {
    private Object data;

    private String name;
    private String email;
    private int regNo;


    public void setData(String name, String email, String regNo) {
        this.name = name;
        this.email = email;
        this.regNo = Integer.parseInt(regNo);
    }

    public String[] getData() {
        return new String[]{this.name, this.email, String.valueOf(this.regNo)};
    }
}
