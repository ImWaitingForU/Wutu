package com.soldiersoul.wutu.society.frags;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.beans.UserBean;
import com.soldiersoul.wutu.society.SocietyActDetailActivity;
import com.soldiersoul.wutu.society.bean.SocietyAct;
import com.soldiersoul.wutu.society.bean.SocietyBean;
import com.soldiersoul.wutu.utils.VectorDrawableUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;


/**
 * 社团活动界面
 */
public class SocietyActFragment extends Fragment {

    @BindView (R.id.rvTimeLine) RecyclerView recylerView;

    private TimeLineAdapter adapter;

    private List<SocietyAct> actBeen;

    public SocietyActFragment () {
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);

        BmobQuery<SocietyAct> actQuery = new BmobQuery<> ();
        SocietyBean society = new SocietyBean ();

        //        society.setObjectId (BmobUser.getCurrentUser (UserBean.class).getSociety ().getObjectId ().trim ());
        //        actQuery.addWhereEqualTo ("societyBean", society);
        // TODO: 2017/4/16  修改为通过时间分割活动
        actQuery.addWhereEqualTo ("societyBean", BmobUser.getCurrentUser (UserBean.class).getSociety ().getObjectId ().trim ());
        actQuery.findObjects (new FindListener<SocietyAct> () {
            @Override
            public void done (List<SocietyAct> list, BmobException e) {
                if (e == null) {
                    Log.d ("Bmob","SocietyAct===="+list.size ());
                    actBeen = list;
                    adapter = new TimeLineAdapter (actBeen);
                    // TODO: 2017/4/16 设置列表空布局
                    recylerView.setAdapter (adapter);
                    recylerView.setLayoutManager (new LinearLayoutManager (getActivity (), LinearLayoutManager.VERTICAL, false));
                    recylerView.setHasFixedSize (true);
                } else {
                    Log.d ("Bmob", e.getMessage ());
                }
            }
        });


    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_society_act, container, false);
    }

    public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

        private Context context;
        private List<SocietyAct> beanList;
        private LayoutInflater inflater;

        public TimeLineAdapter (List<SocietyAct> beanList) {
            this.beanList = beanList;
        }

        @Override
        public TimeLineViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
            context = parent.getContext ();
            inflater = LayoutInflater.from (context);
            View view = inflater.inflate (R.layout.item_timeline, parent, false);
            return new TimeLineViewHolder (view, viewType);
        }

        @Override
        public void onBindViewHolder (TimeLineViewHolder holder, final int position) {
            SocietyAct bean = beanList.get (position);

            if (bean.isActive ()) {
                holder.mTimelineView.setMarker (
                        VectorDrawableUtils.getDrawable (getActivity (), R.drawable.ic_active, R.color.colorPrimary));
            } else {
                holder.mTimelineView.setMarker (
                        VectorDrawableUtils.getDrawable (getActivity (), R.drawable.ic_inactive, R.color.colorPrimary));
            }

            holder.tvTitle.setText (bean.getActName ());
            holder.tvDate.setText (bean.getStartTime ());

            holder.itemView.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View v) {
                    //// TODO: 2017/3/7 传递SocietyAct的值
                    Intent intent = new Intent (getActivity (), SocietyActDetailActivity.class);
                    intent.putExtra ("societyAct",actBeen.get (position));
                    startActivity (intent);
                }
            });
        }

        @Override
        public int getItemCount () {
            return (beanList != null ? beanList.size () : 0);
        }

        @Override
        public int getItemViewType (int position) {
            return TimelineView.getTimeLineViewType (position, getItemCount ());
        }
    }

    private class TimeLineViewHolder extends RecyclerView.ViewHolder {
        public TimelineView mTimelineView;
        public TextView tvDate;
        public TextView tvTitle;

        public TimeLineViewHolder (View itemView, int viewType) {
            super (itemView);
            mTimelineView = (TimelineView) itemView.findViewById (R.id.time_marker);
            mTimelineView.initLine (viewType);
            tvDate = (TextView) itemView.findViewById (R.id.text_timeline_date);
            tvTitle = (TextView) itemView.findViewById (R.id.text_timeline_title);
            CardView cardView = (CardView) itemView.findViewById (R.id.timelineItem);

        }
    }
}
