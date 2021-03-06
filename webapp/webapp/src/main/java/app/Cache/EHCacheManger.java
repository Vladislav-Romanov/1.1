package app.Cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import java.net.URL;

public class EHCacheManger {

    private static Cache newsCache ;

    private static EHCacheManger manager = new EHCacheManger();

    private EHCacheManger() {
        URL url = getClass().getResource("src/main/java/app/config/ehcache.tld");
        CacheManager manager = new CacheManager(url);
        EHCacheManger.newsCache = manager.getCache("newsCache");
    }

    public static Cache getCache() {
        return EHCacheManger.newsCache;
    }

}
