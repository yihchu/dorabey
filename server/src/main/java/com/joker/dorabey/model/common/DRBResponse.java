package com.joker.dorabey.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DRBResponse {
    private boolean success;
    private Object data;
    private String error;

    public static DRBResponse success(Object data) {
        return new DRBResponse().setSuccess(true).setData(data);
    }

    public static DRBResponse success() {
        return new DRBResponse().setSuccess(true);
    }

    public static DRBResponse fail(String error) {
        return new DRBResponse().setSuccess(false).setError(error);
    }

    public static DRBResponse fail() {
        return new DRBResponse().setSuccess(false);
    }
}
