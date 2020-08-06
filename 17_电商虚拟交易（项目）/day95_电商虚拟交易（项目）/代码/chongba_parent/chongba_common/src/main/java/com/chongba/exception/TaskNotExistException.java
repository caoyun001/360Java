package com.chongba.exception;

/**
 * Created by 传智播客*黑马程序员.
 */
public class TaskNotExistException extends  RuntimeException {


    private static final long serialVersionUID = 4571317516880121730L;

    public TaskNotExistException(final String errorMessage, final Object... args) {
        super(String.format(errorMessage, args));
    }

    public TaskNotExistException(final Throwable cause) {
        super(cause);
    }
    
}
