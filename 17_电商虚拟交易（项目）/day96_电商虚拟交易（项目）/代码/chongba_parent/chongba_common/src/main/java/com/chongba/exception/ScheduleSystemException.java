package com.chongba.exception;

/**
 * Created by 传智播客*黑马程序员.
 */
public class ScheduleSystemException extends RuntimeException {

    private static final long serialVersionUID = -3138108380887385059L;

    public ScheduleSystemException(final String errorMessage, final Object... args) {
        super(String.format(errorMessage, args));
    }

    public ScheduleSystemException(final Throwable cause) {
        super(cause);
    }
    
    
}
