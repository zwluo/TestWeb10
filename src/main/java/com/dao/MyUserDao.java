package com.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MyUserDao
{
    UserDetails loadUserByUsername(String userName);

}
