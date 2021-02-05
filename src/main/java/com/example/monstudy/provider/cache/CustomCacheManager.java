package com.example.monstudy.provider.cache;

import java.util.Collection;

public interface CustomCacheManager {
    AbstractCustomCache getCache(String name);
    Collection<String> getCacheStorageNames();
}
