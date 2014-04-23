package com.loopj.android.image;

import android.content.Context;

/**
 * Created by arkhipov on 23.04.14.
 */
public class CacheFactory {
    private static CacheFactory instance = new CacheFactory();
    private WebImageCache temporaryCache;
    private WebImageCache permanentCache;

    public enum CacheType {
        TEMPORARY,
        PERMANENT
    }

    public static CacheFactory getInstance() {
        return instance;
    }

    public WebImageCache getCache(Context context, CacheType cacheType) {
        switch (cacheType) {
            case TEMPORARY:
                return getTemporaryCache(context);
            case PERMANENT:
                return getPermanentCache(context);
        }
        return null;
    }

    private WebImageCache getTemporaryCache(Context context) {
        if (temporaryCache == null) {
            temporaryCache = new WebImageCache(context, context.getApplicationContext().getCacheDir().getAbsolutePath());
        }
        return temporaryCache;
    }

    private WebImageCache getPermanentCache(Context context) {
        if (permanentCache == null) {
            permanentCache = new WebImageCache(context, context.getApplicationContext().getExternalFilesDir(null).getAbsolutePath());
        }
        return permanentCache;
    }

}
