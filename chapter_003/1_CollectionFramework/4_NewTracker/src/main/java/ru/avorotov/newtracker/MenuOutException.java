package ru.avorotov.newtracker;

/**
 * Created by SSS on 29.01.2017.
 */
class MenuOutException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    MenuOutException(String message) {
        super(message);
    }
}
