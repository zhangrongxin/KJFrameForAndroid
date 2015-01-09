package org.kymjs.kjframe.demo.widget;import org.kymjs.kjframe.KJActivity;import org.kymjs.kjframe.demo.R;import org.kymjs.kjframe.ui.BindView;import org.kymjs.kjframe.widget.KJSwipeRefreshLayout;import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;/** * 加载更多建议设置为列表滑动到底部自动加载，而不是非要用户手动向上拉动才能加载，实现方法是implements * OnScrollListener,并在onScroll方法中使用如下代码判断是否到底部，如果是，则加载下一页数据 *  * <pre> * mListView.getLastVisiblePosition() == (mListView.getCount() - 1) * </pre> *  * @author kymjs */public class NewListViewDemo extends KJActivity implements OnRefreshListener {    @BindView(id = R.id.listpull)    private KJSwipeRefreshLayout mSwipeRefreshLayout;    @Override    public void setRootView() {        setContentView(R.layout.aty_new_listview);    }    @Override    public void initWidget() {        super.initWidget();        mSwipeRefreshLayout.setOnRefreshListener(this);        // 设置刷新时颜色        mSwipeRefreshLayout.setColorSchemeResources(                R.color.swiperefresh_color1, R.color.swiperefresh_color2,                R.color.swiperefresh_color3, R.color.swiperefresh_color4);    }    @Override    public void onRefresh() {        setSwipeRefreshLoadingState();        refurbish();        setSwipeRefreshLoadedState();    }    /**     * 设置顶部正在加载的状态     */    private void setSwipeRefreshLoadingState() {        if (mSwipeRefreshLayout != null) {            mSwipeRefreshLayout.setRefreshing(true);            // 防止多次重复刷新            mSwipeRefreshLayout.setEnabled(false);        }    }    /**     * 设置顶部加载完毕的状态     */    private void setSwipeRefreshLoadedState() {        if (mSwipeRefreshLayout != null) {            mSwipeRefreshLayout.setRefreshing(false);            mSwipeRefreshLayout.setEnabled(true);        }    }    private void setListCanPull() {        // 设置是否可以下拉，某些情况下        mSwipeRefreshLayout.setEnabled(true);    }    /**     * 耗时操作     */    private void refurbish() {}}