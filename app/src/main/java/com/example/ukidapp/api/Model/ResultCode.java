package com.example.ukidapp.api.Model;

import com.google.gson.annotations.Expose;

public class ResultCode {
    @Expose
    private Integer resultCode;

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Integer getResultCode() {
        return resultCode;
    }
}
