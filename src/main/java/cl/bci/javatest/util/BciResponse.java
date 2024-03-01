package cl.bci.javatest.util;

import cl.bci.javatest.util.enums.ResponseCode;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class BciResponse<T> {
    private Integer resCode;
    private String resDesc;
    private T dto;

    public static BciResponse success() {
        return new BciResponse(ResponseCode.SUCCESSFUL.getResCode(), ResponseCode.SUCCESSFUL.getResDesc());
    }

    public static BciResponse error() {
        return new BciResponse(ResponseCode.GENERAL_ERROR.getResCode(), ResponseCode.GENERAL_ERROR.getResDesc());
    }

    public BciResponse(){}

    public BciResponse(Integer resCode, String resDesc){
        this.setResCode(resCode);
        this.setResDesc(resDesc);
        this.setDto((T)resDesc);
    }

    public BciResponse(T dto, Integer resCode, String resDesc){
        this.setResCode(resCode);
        this.setResDesc(resDesc);
        this.setDto(dto);
    }

    public BciResponse(T dto, ResponseCode responseCode){
        this.setResCode(responseCode.getResCode());
        this.setResDesc(responseCode.getResDesc());
        this.setDto(dto);
    }

    public ResponseEntity<BciResponse> build() {
        BciResponse responseMessage = new BciResponse(dto, resCode, resDesc);
        HttpStatus status = HttpStatus.valueOf(responseMessage.fetchCodErrorToHttpStatus());
        return new ResponseEntity(responseMessage, status);
    }

    public Integer fetchCodErrorToHttpStatus(){
        Integer lastDigit = this.getResCode()%100;
        return lastDigit;
    }

}
