package com.example.monstudy.provider.cache;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Component("memoryCustomCacheManager")
public class MemoryCustomCacheManager implements CustomCacheManager {

    private ConcurrentHashMap<String, CurrentMapCustomCache> cacheMap = new ConcurrentHashMap<>(16);

    @Override
    public AbstractCustomCache getCache(String name) {
        CurrentMapCustomCache cache = this.cacheMap.get(name);
        if (cache == null) {
            synchronized (this.cacheMap) {
                cache = this.cacheMap.get(name);
                if (cache == null) {
                    cache = createConcurrentMapCustomCache(name);
                    this.cacheMap.put(name, cache);
                }
            }
        }
        return cache;
    }

    @Override
    public Collection<String> getCacheStorageNames() {
        return null;
    }

    protected CurrentMapCustomCache createConcurrentMapCustomCache(String name) {
        return new CurrentMapCustomCache(name, new ConcurrentHashMap<>(256));
    }
}
