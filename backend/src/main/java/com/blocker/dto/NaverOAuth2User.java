package com.blocker.dto;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;

import lombok.Getter;

@Getter
public class NaverOAuth2User implements OAuth2User {
    private String id;
    private NaverProperties properties;

    @Override
    public Map<String, Object> getAttributes() {
        Map<String, Object> attrs = new HashMap<>();
        attrs.put("id", this.id);
        //attrs.put("name", this.properties.getNickname());
        //attrs.put("image", this.properties.getProfile_image());
       
        return attrs;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new OAuth2UserAuthority(getAttributes()));
    }

    @Override
    public String getName() {
        return this.id;
    }

    @Getter
    private static class NaverProperties {
        private String nickname;
        private String profile_image;
    }
}