package com.example.rest_service.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

@Component
@Scope("singleton")
public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean created");
    }
}

