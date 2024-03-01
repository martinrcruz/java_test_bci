package cl.bci.javatest.exception;

import cl.bci.javatest.util.BciResponse;
import cl.bci.javatest.util.enums.ResponseCode;

import java.util.HashMap;

public class UserException extends BciException {
    public UserException(String message) {
        super(message);
    }

    public UserException(UserCode userErrorCode) {
        super(userErrorCode.toString());
        responseMessage = new BciResponse();
        responseMessage.setResCode(userErrorCode.getUserCode());
        responseMessage.setResDesc(codeDescription.get(userErrorCode.getUserCode()));
    }

    public UserException(UserCode userErrorCode, String message) {
        super(message);
        responseMessage = new BciResponse();
        responseMessage.setResCode(userErrorCode.getUserCode());
        responseMessage.setResDesc(codeDescription.get(userErrorCode.getUserCode()));
        responseMessage.setDto(message);
    }

    public UserException(ResponseCode responseCode, String message) {
        super(responseCode, message);
    }

    public BciResponse getResponseMessage() {
        return responseMessage;
    }

    public enum UserCode {
        USER_OK(1000),
        USER_CREATED(1001),
        USER_GENERAL_ERROR(-1001),
        USER_BAD_EMAIL_FORMAT(-1002),
        USER_BAD_PASSWORD_FORMAT(-1003),
        USER_ALREADY_EXISTS(-1004),
        USER_DATA_NOT_FOUND(-1005),
        USER_CANNOT_BE_NULL(-1006);

        private final int userCode;

        UserCode(int userCode) {
            this.userCode = userCode;
        }

        public int getUserCode() {
            return this.userCode;
        }
    }

    private static final HashMap<Integer, String> codeDescription = new HashMap<Integer, String>() {
        {
            put(1000, "ok");
            put(1001, "user created succesfully");
            put(-1001, "general error in user");
            put(-1002, "error in user, bad email format");
            put(-1003, "error in user, bad password format");
            put(-1004, "user already exists");
            put(-1005, "user data not found");
            put(-1006, "user can not be null");

        }
    };
}
