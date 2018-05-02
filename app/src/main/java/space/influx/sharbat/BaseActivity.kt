package space.influx.sharbat

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import org.jetbrains.anko.find

/**
 * Created by LNTCS on 2018-05-02.
 */

abstract class BaseActivity : AppCompatActivity() {
    var instance: BaseActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this

        setContentView(viewId)
        if (toolbarId != 0) {
            var toolbar = find<Toolbar>(toolbarId)
            setSupportActionBar(toolbar)
        }
        onCreate()
    }

    protected abstract var viewId: Int
    protected abstract var toolbarId: Int

    protected abstract fun onCreate()

    fun disableToggle() {
        this.supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    fun enableToggle() {
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun setToolbarTitle(titleStr: String) {
        this.supportActionBar?.title = titleStr
    }

    fun setToolbarTitle(titleId: Int) {
        this.supportActionBar?.title = getString(titleId)
    }

    fun setToolbarIcon(iconRes: Int) {
        this.supportActionBar?.setHomeAsUpIndicator(iconRes)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
