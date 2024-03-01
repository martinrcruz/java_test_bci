package cl.bci.javatest.util.enums;

import java.util.HashMap;

public enum ResponseCode {
    SUCCESSFUL(0),
    CREATED(1),
    UPDATED(2),
    REMOVED(3),
    NOT_DATA_FOUND(-1),
    PRECONDITION_REQUIRED(-2),
    GENERAL_ERROR(-3),
    NOT_ALLOWED(-4);

    private final Integer resCode;

    ResponseCode(Integer resCode) {
        this.resCode = resCode;
    }

    public Integer getResCode() {
        return this.resCode;
    }

    private static final HashMap<Integer, String> resDesc = new HashMap<Integer, String>() {
        {
            put(0, "successful");
            put(1, "created");
            put(2, "updated");
            put(3, "removed");
            put(-1, "not data found");
            put(-2, "precondition required");
            put(-3, "general error");
            put(-4, "not allowed");
        }
    };
    public String getResDesc(){
        return resDesc.get(this.resCode);
    }

    public static ResponseCode getByCode(int resCode) {
        for(ResponseCode e : values()) {
            if(e.resCode==resCode){
                return e;
            }
        }
        return null;
    }
}
