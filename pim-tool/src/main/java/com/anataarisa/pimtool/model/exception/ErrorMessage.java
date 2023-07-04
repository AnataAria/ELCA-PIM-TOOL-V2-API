package com.anataarisa.pimtool.model.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private HttpStatus status;
    private String message;
    private String errorMessage;

    public ErrorMessage(HttpStatus status, String message, String errorMessage) {
        this();
        this.status = status;
        this.message = message;
        this.errorMessage = errorMessage;
    }

    public ErrorMessage(){
        this.timestamp = Date.valueOf(LocalDate.now());
    }
}
