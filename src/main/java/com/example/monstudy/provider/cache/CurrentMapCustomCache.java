package com.example.monstudy.provider.cache;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class CurrentMapCustomCache extends AbstractCustomCache {
    private final String name;
    private final ConcurrentHashMap<String, Object> store;

    public CurrentMapCustomCache(String name, ConcurrentHashMap<String, Object> store) {
        this.name = name;
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public ConcurrentHashMap<String, Object> getNativeCache() {
        return store;
    }

    protected Optional<Object> lookup(Object key) {
        return Optional.ofNullable(this.store.get(key));
    }

    public boolean put(String key, Object value) {
        this.store.put(key, value);
        return true;
    }

    @Override
    public void evict(Object key) {

    }

    @Override
    public void clear() {

    }
}
