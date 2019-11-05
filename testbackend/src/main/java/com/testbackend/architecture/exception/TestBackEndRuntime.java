package com.testbackend.architecture.exception;

public class TestBackEndRuntime extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestBackEndRuntime(Throwable e){
        super(e);
    }

    public TestBackEndRuntime(String error){
        super(error);
    }

    public TestBackEndRuntime(EnumException enumException, Object... param){
        super(enumException.getFormatedError(param));
    }

}