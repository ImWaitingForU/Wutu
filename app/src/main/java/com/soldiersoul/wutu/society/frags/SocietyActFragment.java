package com.soldiersoul.wutu.society.frags;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;
import com.soldiersoul.wutu.R;
import com.soldiersoul.wutu.society.SocietyActDetailActivity;
import com.soldiersoul.wutu.society.bean.SocietyActBean;
import com.soldiersoul.wutu.society.bean.SocietyBean;
import com.soldiersoul.wutu.utils.VectorDrawableUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 社团活动界面
 */
public class SocietyActFragment extends Fragment {

    @BindView (R.id.rvTimeLine) RecyclerView recylerView;

    private List<SocietyActBean> actBeen;
    private SocietyBean society;

    public SocietyActFragment () {
    }

    public SocietyActFragment (SocietyBean society) {
        this.society = society;
    }

    private void getData () {
        actBeen = new ArrayList<> ();
        actBeen.add (new SocietyActBean ("act1", "20170101", null, null, null, null, null, true));
        actBeen.add (new SocietyActBean ("act2", "20170101", null, null, null, null, null, true));
        actBeen.add (new SocietyActBean ("act3", "20170101", null, null, null, null, null, false));
        actBeen.add (new SocietyActBean ("act4", "20170101", null, null, null, null, null, false));
        actBeen.add (new SocietyActBean ("act5", "20170101", null, null, null, null, null, false));
        actBeen.add (new SocietyActBean ("act6", "20170101", null, null, null, null, null, false));
        actBeen.add (new SocietyActBean ("act7", "20170101", null, null, null, null, null, false));
    }

    @Override
    public void onViewCreated (View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
        TimeLineAdapter adapter = new TimeLineAdapter (actBeen);
        recylerView.setAdapter (adapter);
        recylerView.setLayoutManager (new LinearLayoutManager (getActivity (), LinearLayoutManager.VERTICAL, false));
        recylerView.setHasFixedSize (true);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getData ();
        return inflater.inflate (R.layout.fragment_society_act, container, false);
    }

    public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineViewHolder> {

        private Context context;
        private List<SocietyActBean> beanList;
        private LayoutInflater inflater;

        public TimeLineAdapter (List<SocietyActBean> beanList) {
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
        public void onBindViewHolder (TimeLineViewHolder holder, int position) {
            SocietyActBean bean = beanList.get (position);

            if (bean.isActive ()) {
                holder.mTimelineView.setMarker (
                        VectorDrawableUtils.getDrawable (getActivity (), R.drawable.ic_active, R.color.colorPrimary));
            } else {
                holder.mTimelineView.setMarker (
                        VectorDrawableUtils.getDrawable (getActivity (), R.drawable.ic_inactive, R.color.colorPrimary));
            }

            holder.tvTitle.setText (bean.getActName ());
            holder.tvDate.setText (bean.getStartTime ());
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
            cardView.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick (View v) {
                    //// TODO: 2017/3/7 传递SocietyAct的值 
                    startActivity (new Intent (getActivity (), SocietyActDetailActivity.class));
                }
            });
        }

    }

}
