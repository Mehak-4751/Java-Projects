package tech.codingclub.helix.entity;

public class LoginResponse {
    public Long id;
    public boolean is_verified;
    public String message;

    public LoginResponse(){
    }

    public LoginResponse(Long id,boolean is_verified,String message){
        this.id=id;
        this.is_verified=is_verified;
        this.message=message;
    }
}
