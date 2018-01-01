package com.example.paras.primotech;

/**
 * Created by Paras on 12/30/2017.
 */

public class Config {

    //Address of our scripts of the CRUD
    public static final String URL_ADD="https://webintegration.000webhostapp.com/addEmp.php";
    public static final String URL_GET_ALL = "https://webintegration.000webhostapp.com/getAllEmp.php";
    public static final String URL_GET_EMP = "https://webintegration.000webhostapp.com/getEmp.php?id=";
    public static final String URL_UPDATE_EMP = "https://webintegration.000webhostapp.com/updateEmp.php";
    public static final String URL_DELETE_EMP = "https://webintegration.000webhostapp.com/deleteEmp.php?id=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_USER_PASS = "pass";
    public static final String KEY_USER_NAME = "name";
    public static final String KEY_USER_EMAIL = "email";
    public static final String KEY_USER_UNAME = "uname";
    public static final String KEY_USER_PHONE = "phone";
    public static final String KEY_USER_DOB = "dob";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_PASS = "pass";
    public static final String TAG_NAME = "name";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_UNAME = "uname";

    //employee id to pass with intent
    public static final String USER_ID = "user_id";

}
