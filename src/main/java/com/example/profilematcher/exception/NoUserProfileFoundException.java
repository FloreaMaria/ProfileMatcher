package com.example.profilematcher.exception;

public class NoUserProfileFoundException extends RuntimeException {
        public NoUserProfileFoundException(String message) {
        super(message);
    }
}
