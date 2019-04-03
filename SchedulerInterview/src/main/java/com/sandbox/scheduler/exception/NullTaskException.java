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
 * Exception for input Task Object is null
 *
 * @author Wei Yao
 */
public class NullTaskException extends RuntimeException {
        public NullTaskException() {
    }

    public NullTaskException(String message) {
        super(message);
    }

    public NullTaskException(Throwable cause) {
        super(cause);
    }

    public NullTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullTaskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
