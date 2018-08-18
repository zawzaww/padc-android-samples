package com.zawzaww.padc.mmnewskotlin.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_news_list.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.*
import kotlin.collections.ArrayList
import com.zawzaww.padc.mmnewskotlin.MMNewsApp
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.adapters.NewsAdapter
import com.zawzaww.padc.mmnewskotlin.components.SmartScrollListener
import com.zawzaww.padc.mmnewskotlin.data.models.NewsAppModel
import com.zawzaww.padc.mmnewskotlin.data.vos.NewsVO
import com.zawzaww.padc.mmnewskotlin.delegates.BeforeLoginDelegate
import com.zawzaww.padc.mmnewskotlin.delegates.NewsItemDelegate
import com.zawzaww.padc.mmnewskotlin.events.DataEvent
import com.zawzaww.padc.mmnewskotlin.events.ErrorEvent
import com.zawzaww.padc.mmnewskotlin.utils.AppConstants
import com.zawzaww.padc.mmnewskotlin.views.pods.AccountControlViewPod

class NewsListActivity : BaseActivity(), NewsItemDelegate, BeforeLoginDelegate {

    override fun onTapLogin() {
//        val intent = Intent(applicationContext, AccountControlActivity::class.java)
//        intent.putExtra(AppConstants.ACTION_TYPE, AppConstants.VALUE_LOGIN)
//        startActivity(intent)

        val intent = AccountControlActivityTwo.newIntent(applicationContext)
        startActivity(intent)
    }

    override fun onTapRegister() {
//        val intent = Intent(applicationContext, AccountControlActivity::class.java)
//        intent.putExtra(AppConstants.ACTION_TYPE, AppConstants.VALUE_REGISTER)
//        startActivity(intent)

        val intent = AccountControlActivityTwo.newIntent(applicationContext)
        startActivity(intent)
    }

    private var mNewsAdapter: NewsAdapter? = null
    private var mSmartScrollListener: SmartScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        setSupportActionBar(toolBar)

        supportActionBar!!.setDisplayShowTitleEnabled(false)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu_white)

        fabButton.setOnClickListener { view ->

            var addResult: Int = addTheseTwo(2410, 1876)
            var todayDate: Date? = null //Date()
            var isToRestToday = isRestDay(todayDate)
            var isToRestStr: String
            if (isToRestToday) {
                isToRestStr = "rest"
            } else {
                isToRestStr = "work"
            }

            var isTappingFAB: String
            if (fabButton is FloatingActionButton)
                isTappingFAB = "tapping FAB"
            else
                isTappingFAB = "not tapping FAB"

            var degrees = listOf("M.Med (Int.Med)(Nus, S'pore)",
                    "M.Med.Sc (Int,Med)",
                    "MA cad MED (UK)",
                    "Fellowship in interventional Cardiology (Seoul, Korea)",
                    "Consultant Heart & General Physician")

            var degreesPresentable = getDegreesPresentableWithWhile(degrees)

            tryOutCollections()
        }

        var news: NewsVO = NewsVO()
        news.newsId = "PADC-12345"
        news.brief = "Handle action bar item clicks here."
        news.details = "The action bar will automatically handle clicks on the Home/Up button, " +
                "so long as you specify a parent activity in AndroidManifest.xml."
        news.postedDate = "2018-03-27"
        news.images = ArrayList<String>()

        rvNews.setEmptyView(vpEmptyNews)
        rvNews.layoutManager = LinearLayoutManager(applicationContext)

        mSmartScrollListener = SmartScrollListener(object : SmartScrollListener.OnSmartScrollListener {
            override fun onListEndReach() {
                Snackbar.make(rvNews, "Loading more data.", Snackbar.LENGTH_LONG).show()
                swipeRefreshLayout.isRefreshing = true
                NewsAppModel.getInstance().loadNews()
            }
        })
        rvNews.addOnScrollListener(mSmartScrollListener)

        mNewsAdapter = NewsAdapter(applicationContext, this)
        rvNews.adapter = mNewsAdapter

        swipeRefreshLayout.isRefreshing = true
        NewsAppModel.getInstance().loadNews()

        swipeRefreshLayout.setOnRefreshListener {
            val newsAdapterVal = mNewsAdapter
            newsAdapterVal!!.clearData()
            NewsAppModel.getInstance().forceLoadNews()
        }

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuLatestNews -> {
                    Snackbar.make(navigationView, "Tapped Latest News", Snackbar.LENGTH_LONG).show()
                }

                R.id.menuNewsJustForYou -> {
                    Snackbar.make(navigationView, "Tapped Just for You", Snackbar.LENGTH_LONG).show()
                }

                R.id.menuFavNews -> {
                    Snackbar.make(navigationView, "Tapped Favorite News", Snackbar.LENGTH_LONG)
                }
            }

            for (menuItemIndex in 0 until navigationView.menu.size()) {
                navigationView.menu.getItem(menuItemIndex).isChecked = false
            }

            it.isChecked = true
            drawerLayout.closeDrawer(GravityCompat.START)

            return@setNavigationItemSelectedListener true
        }

        val vpAccountConrol = navigationView.getHeaderView(0) as AccountControlViewPod
        vpAccountConrol.setDelegate(this)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
            return true

        }

        return when (item.itemId) {
            R.id.actionSettings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addTheseTwo(varOne: Int, varTwo: Int): Int {
        return varOne + varTwo
    }

    private fun isRestDay(date: Date?): Boolean {
        if (date == null)
            return true

        var calendar: Calendar = Calendar.getInstance()
        calendar.time = date
        var dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        if (dayOfMonth / 3 == 0 && isRestDate(date)) {
            return true
        }
        return false
    }

    private fun getDegreesPresentable(degrees: List<String>): String {
        var presentableDegrees: String = ""
        for (degree in degrees) {
            presentableDegrees = "$presentableDegrees, $degree"
        }
        return presentableDegrees
    }

    private fun getDegreesPresentableWithWhile(degrees: List<String>): String {
        var presentableDegrees: String = ""
        var index = 0
        while (index < degrees.size) {
            presentableDegrees = "$presentableDegrees, $degrees[index]"
            index++
        }
        return presentableDegrees
    }

    private fun isRestDate(dateToCheck: Date): Boolean {
        var calendar = Calendar.getInstance()
        calendar.time = dateToCheck
        when (calendar.get(Calendar.DAY_OF_WEEK)) {
            0 -> return true
            1 -> return true
            2 -> return false
            3 -> return false
            4 -> return true
            5 -> return true
            6 -> return false
            else -> return true
        }
    }

    private fun ageToFoolAround(age: Int): String {
        if (age in 19..24)
            return "Yes"
        else
            return "No"
    }

    private fun howRangeAndStepWorks() {
        for (index in 1..15 step 2)
            Log.d(MMNewsApp.TAG, "1..15 step 2 : $index")

        for (index in 30 downTo 0 step 3)
            Log.d(MMNewsApp.TAG, "30 downTo 0 step 3 : $index")
    }

    private fun tryOutCollections() {
        val degrees = listOf("M.Med (Int.Med)(Nus, S'pore)",
                "M.Med.Sc (Int,Med)",
                "MA cad MED (UK)",
                "Fellowship in interventional Cardiology (Seoul, Korea)",
                "Consultant Heart & General Physician")

        degrees
                .filter { it.startsWith("M") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { Log.d(MMNewsApp.TAG, "Having $it is pretty awesome.") }
    }

    override fun onTapComment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapSendTo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapFavorite() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapStatistics() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapNews(news: NewsVO) {
        val intent: Intent = NewsDetailsActivity.newIntent(applicationContext, news.newsId)
        startActivity(intent)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNewsLoadedEvent(newsLoadedEvent: DataEvent.NewsLoadedEvent) {
        swipeRefreshLayout.isRefreshing = false
        mNewsAdapter!!.appendNewData(newsLoadedEvent.loadedNews as MutableList<NewsVO>)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorNewsLoadedEvent(apiErrorEvent: ErrorEvent.ApiErrorEvent) {
        swipeRefreshLayout.isRefreshing = false
        Snackbar.make(rvNews, "ERROR : " + apiErrorEvent.getMsg(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEmptyNewsLoadedEvent(emptyDataLoadedEvent: DataEvent.EmptyDataLoadedEvent) {
        swipeRefreshLayout.isRefreshing = false
        Snackbar.make(rvNews, "ERROR : " + emptyDataLoadedEvent.errorMsg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

}
