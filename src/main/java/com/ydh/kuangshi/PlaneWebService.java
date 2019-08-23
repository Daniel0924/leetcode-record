package com.ydh.kuangshi;

import com.alibaba.fastjson.JSONObject;
import com.ydh.util.PlaneUtil;

public class PlaneWebService {
    private String username;
    private String password;
    private String token;

    public PlaneWebService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Boolean isValidUser() {
        return username.equals(password);
    }

    public String validateAuth() {
        if (isValidUser()) {
            this.token = username + "," + password + Math.random();
            return token;
        } else {
            return "wrong username or password";
        }
    }

    public String addPlane(String tailNumber, String planeType) {
        System.out.println("token:" + token);

        JSONObject res = new JSONObject();
        res.put("success", true);
        res.put("data", PlaneUtil.AddPlane(tailNumber, planeType));
        return res.toJSONString();
    }

    public String getPlane() {
        return "";
    }

    public String getPlaneList() {
        return "";
    }


    public static void main(String[] args) {

        String username = "Daniel";
        String passwoord = "Daniel";

        PlaneWebService service = new PlaneWebService(username, passwoord);

        String token = service.validateAuth();

        if (service.isValidUser()) {
            System.out.println("有效用户");
        } else {
            System.out.println("无效用户");
        }

        String tailNumber = "ZZ2345";
        String planeType = "Douyin747";
        JSONObject res = (JSONObject) JSONObject.parse(service.addPlane(tailNumber, planeType));
        String aPlane = service.getPlane();
        String planeList = service.getPlaneList();
    }
}
