package space.influx.sharbat

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication

/**
 * Created by LNTCS on 2018-05-02.
 */

class Application : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this@Application)
    }

}
