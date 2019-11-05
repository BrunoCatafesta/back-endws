package com.testbackend.architecture.exception;

import java.util.Formatter;

public interface TestBackendException {

	String getErro();

	default String getFormatedError(Object... param) {
		StringBuilder sbuf = new StringBuilder();
		Formatter fmt = new Formatter(sbuf).format(this.getErro(), param);
		return sbuf.toString();
	}
}