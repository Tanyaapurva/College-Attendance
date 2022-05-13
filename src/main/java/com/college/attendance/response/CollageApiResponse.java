package com.college.attendance.response;

import lombok.Data;


@Data
public class CollageApiResponse<T> {
    private int status;
    private String message;
    private String internalErrorMsg;

    private T data;

}
