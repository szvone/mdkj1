package cn.szvone.mdkj.execptions;

public class AuthException extends RuntimeException{
    public AuthException(String message) {
        super(message);
    }
}