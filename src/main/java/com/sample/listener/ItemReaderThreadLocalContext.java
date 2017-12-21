package com.sample.listener;

public final class ItemReaderThreadLocalContext {
	/**
	 * Default constructor.
	 * 
	 */
	private ItemReaderThreadLocalContext() {
		// Empty constructor.
	}

	/** thread context for keeping the flag if the execution is completed or not */
	private static final ThreadLocal<Boolean> THREAD_EXECUTION_CONTEXT = 
			new ThreadLocal<Boolean>() {
		protected Boolean initialValue() {
			return Boolean.FALSE;
		}
	};

	/**
	 * Getter for the flag.
	 * 
	 * @return the flag.
	 */
	public static Boolean getContextFlag() {
		return THREAD_EXECUTION_CONTEXT.get();
	}

	/**
	 * Setter for flag.
	 * 
	 * @param contextFlag the flag to set.
	 */
	public static void setContextFlag(final boolean contextFlag) {
		THREAD_EXECUTION_CONTEXT.set(Boolean.valueOf(contextFlag));
	}

	/**
	 * Remove the flag context.
	 * 
	 */
	public static void removeContextFlag() {
		THREAD_EXECUTION_CONTEXT.remove();
	}

}
