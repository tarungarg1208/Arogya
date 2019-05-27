package com.example.arogyademo;

public class Data_DonorAndDonee {
    String userId,request_type,aid_type,add_info;

    public Data_DonorAndDonee(String userId, String request_type, String aid_type, String add_info) {
        this.userId = userId;
        this.request_type = request_type;
        this.aid_type = aid_type;
        this.add_info = add_info;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setRequest_type(String request_type) {
        this.request_type = request_type;
    }

    public void setAid_type(String aid_type) {
        this.aid_type = aid_type;
    }

    public void setAdd_info(String add_info) {
        this.add_info = add_info;
    }

    public String getUserId() {
        return userId;
    }

    public String getRequest_type() {
        return request_type;
    }

    public String getAid_type() {
        return aid_type;
    }

    public String getAdd_info() {
        return add_info;
    }
}
