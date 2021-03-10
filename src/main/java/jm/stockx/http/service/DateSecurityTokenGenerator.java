package jm.stockx.http.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DateSecurityTokenGenerator {

    public String DateTokenCoder(){
        long unixTime = System.currentTimeMillis() / 1000L;
        String time =String.valueOf(unixTime);
        String token = Base64.getEncoder().encodeToString(time.getBytes(StandardCharsets.UTF_8));
        return token;
    }



}
