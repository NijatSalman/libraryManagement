package com.aistgroup.enums;

public enum RoleEnum {
    RESERVE_BOOK(1),GIVE_BOOK(2),RECEIVE_BOOK(3),REPAIR_BOOK(4);

    private int value;

    private RoleEnum(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
