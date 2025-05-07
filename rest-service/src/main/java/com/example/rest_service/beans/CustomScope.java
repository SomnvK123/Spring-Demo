package com.example.rest_service.beans;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class CustomScope implements Scope{
    private final Map<String, Object> scopes = new HashMap<String, Object>();
    private final Map<String, Long> creationTimes = new HashMap<String, Long>();
    private final Map<String, Runnable> destructionCallbacks = new HashMap<>();

    private static final Long MAX_LIFETIME = 5*60*1000L; // 5 minutes

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object object = scopes.get(name); // lay object tu scopes
        if (object == null) { // kiem tra object co null ko
            object = objectFactory.getObject(); // neu null thi lay object tu objectFactory
            scopes.put(name, object); // luu object vao scopes
            creationTimes.put(name, System.currentTimeMillis()); // luu thoi gian tao object
        } else {
            Long creationTime = creationTimes.get(name); // lay thoi gian tao object
            if (System.currentTimeMillis() - creationTime > MAX_LIFETIME) { // kiem tra thoi gian tao object co vuot qua MAX_LIFETIME ko
                remove(name); // neu vuot qua thi goi ham remove
                object = objectFactory.getObject(); // lay object tu objectFactory
                scopes.put(name, object); // luu object vao scopes
                creationTimes.put(name, System.currentTimeMillis()); // luu thoi gian tao object
            }
        }
        return object;
    }

    @Override
    public Object remove(String name) {
        Object object = scopes.remove(name); // lay object tu scopes
        creationTimes.remove(name); // xoa thoi gian tao object
        Runnable callback = destructionCallbacks.remove(name); // lay callback tu destructionCallbacks
        if (callback != null) { // neu callback khong null thi goi ham callback
            callback.run();
        }
        return object;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) { // register a callback
        destructionCallbacks.put(name, callback);
    }

    @Override
    public Object resolveContextualObject(String key) { // lookup the object in the scope
        return scopes.get(key);
    }

    @Override
    public String getConversationId() { //
        return "";
    }
}
