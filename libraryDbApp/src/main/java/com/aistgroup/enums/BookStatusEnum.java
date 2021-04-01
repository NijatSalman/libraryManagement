package com.aistgroup.enums;

import org.springframework.stereotype.Controller;


public enum BookStatusEnum {
    AVAILABLE(1),RESERVED(2),TAKEN(3),REPAIRMENT(4);

    private int value;

    private BookStatusEnum(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
