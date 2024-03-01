package cl.bci.javatest.exception;

import cl.bci.javatest.dto.response.ResponseMessage;
import cl.bci.javatest.util.BciResponse;
import cl.bci.javatest.util.enums.ResponseCode;

public class BciException extends Exception {
    BciResponse responseMessage;

    public BciException(String message) {
        super(message);
    }

    public BciException(ResponseMessage responseMessage) {
        super(responseMessage.getResDesc());
    }

    public BciException(BciResponse responseMessage) {
        super(responseMessage.getResDesc());
        this.responseMessage = responseMessage;
    }

    public BciException(ResponseCode responseCode, String message) {
        super(message);
        responseMessage = new BciResponse();
        responseMessage.setResCode(responseCode.getResCode());
        responseMessage.setResDesc(responseCode.getResDesc());
        responseMessage.setDto(message);
    }

//    public ResponseEntity getResponseEntity(){
//        return BciResponseEntityBuilder.buildHttpResponse(this.responseMessage);
//    }

    public Integer getResCode(){
        return this.responseMessage.getResCode();
    }
}
