package cl.bci.javatest.util;

import cl.bci.javatest.util.enums.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class BciHttpResponseBuilder {
    private static final Map<Integer, HttpStatus> httpStatusMapping = Map.ofEntries(
            Map.entry(ResponseCode.SUCCESSFUL.getResCode(), HttpStatus.OK),
            Map.entry(ResponseCode.UPDATED.getResCode(), HttpStatus.OK),
            Map.entry(ResponseCode.REMOVED.getResCode(), HttpStatus.OK),
            Map.entry(ResponseCode.CREATED.getResCode(), HttpStatus.CREATED),
            Map.entry(ResponseCode.NOT_DATA_FOUND.getResCode(), HttpStatus.NOT_FOUND),
            Map.entry(ResponseCode.PRECONDITION_REQUIRED.getResCode(), HttpStatus.PRECONDITION_REQUIRED),
            Map.entry(ResponseCode.GENERAL_ERROR.getResCode(), HttpStatus.BAD_REQUEST)
    );

    private BciHttpResponseBuilder() {
    }

    public static ResponseEntity<BciResponse> buildHttpResponse(BciResponse responseMessage) {
        HttpStatus httpStatus = httpStatusMapping.getOrDefault(responseMessage.fetchCodErrorToHttpStatus(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(responseMessage, httpStatus);
    }

}
