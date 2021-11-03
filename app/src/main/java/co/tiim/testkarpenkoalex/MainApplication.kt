package co.tiim.testkarpenkoalex

import android.support.multidex.MultiDexApplication
import com.google.android.exoplayer2.database.ExoDatabaseProvider
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor
import com.google.android.exoplayer2.upstream.cache.SimpleCache
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */
@HiltAndroidApp
class MainApplication : MultiDexApplication() {

    lateinit var simpleCache: SimpleCache

    override fun onCreate() {
        super.onCreate();
        val leastRecentlyUsedCacheEvictor = LeastRecentlyUsedCacheEvictor(100 * 1024 * 1024)
        instance = this
        simpleCache = SimpleCache(cacheDir, leastRecentlyUsedCacheEvictor, ExoDatabaseProvider(this))

    }

    companion object {
        lateinit var instance: MainApplication
    }
}