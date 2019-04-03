/*
 * Copyright  2019 Wei Yao Interview 
 * All Rights Reserved.
 * Unauthorized Use or Disclosure Prohibited.
 *
 * File: SchedulerTest.java
 * Last Check By Wei Yao On April-2019
 * Current Revision 1.0
 */
package com.sandbox.scheduler.exception;

/**
 * Exception for input Task Category Out of Range
 *
 * @author Wei Yao
 */
public class CategoryOutofRangeException extends RuntimeException {

    public CategoryOutofRangeException() {
    }

    public CategoryOutofRangeException(String message) {
        super(message);
    }

    public CategoryOutofRangeException(Throwable cause) {
        super(cause);
    }

    public CategoryOutofRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryOutofRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
