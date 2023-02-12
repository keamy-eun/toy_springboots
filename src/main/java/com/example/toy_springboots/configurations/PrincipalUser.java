package com.example.toy_springboots.configurations;


import java.util.Collection;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PrincipalUser implements UserDetails{

    private Map userInfo ;
    private String memberName ;

    public Map getUserInfo() {
        return userInfo;
    }

    public String getMemberName() {
        return memberName;
    }

    public PrincipalUser(Map userInfo){
        this.userInfo = userInfo ;
        this.memberName = (String)userInfo.get("NAME");
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collections = new ArrayList<>();
        collections.add(new SimpleGrantedAuthority((String) userInfo.get("AUTHORITY")));
        return collections;
    }

    @Override
    public String getPassword() {
        return (String)userInfo.get("PASSWORD");
    }

    @Override
    public String getUsername() {
        return (String)userInfo.get("MEMBER_ID");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
