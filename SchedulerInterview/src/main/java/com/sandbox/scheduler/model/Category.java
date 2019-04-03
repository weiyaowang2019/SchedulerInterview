package com.sandbox.scheduler.model;

/**
 * Created by pchurchward on 2017-07-20.
 * Note: Based on Requirement document that the Category order is :
 * Categories are: RED (highest priority), BLUE and GREEN.
 * So switch GEEN and BLUE value from GREEN (2) to GREEN(3)
 * and BLUE(3) to BLUE(2)
 * 
 * Modified by Wei Yao on 2019-04-03
 */
public enum Category {

    RED(1),
    /*Note:  Based on Requirement document that the Category order is :
        Categories are: RED (highest priority), BLUE and GREEN.
        Switch GEEN and BLUE value from GREEN (2) to GREEN(3) and BLUE(3) to BLUE(2)
        for integer based sorting
    */
    BLUE(2),
    GREEN(3);

    private int value;

    public int getValue() {
        return value;
    }

    private Category(int value) {
        this.value = value;
    }
}
