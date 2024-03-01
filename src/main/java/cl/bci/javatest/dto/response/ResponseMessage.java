package cl.bci.javatest.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseMessage<T> {
    private Integer resCode;
    private String resDesc;
    private T dto;

    @JsonIgnore
    private HttpStatus httpStatus;
}
