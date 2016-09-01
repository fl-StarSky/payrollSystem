package com.ncu.zhuoyuejike.fuli.payrollsystem.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.ncu.zhuoyuejike.fuli.payrollsystem.ItemListActivity;
import com.ncu.zhuoyuejike.fuli.payrollsystem.MemberActivity;
import com.ncu.zhuoyuejike.fuli.payrollsystem.R;

import java.util.ArrayList;
import java.util.List;

public class MemberFragment extends Fragment {
    
    private List<String> memberData;
    private memberRecyclerAdapter adapter;
    private RecyclerView memberRecyclerView;
    private RippleView memberRippleView;
    private View view;


    public MemberFragment() {
        // Required empty public constructor
    }

    public static MemberFragment newInstance() {
        MemberFragment fragment = new MemberFragment();
        return fragment;
    }

    //创建该fragment的视图
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.member_fragment, container, false);
        memberRecyclerView = (RecyclerView) view.findViewById(R.id.member_list);
        memberData = new ArrayList<String>();
        String[] memberStr=new String[]{"张三","李四","王五","赵六"};
        for(int i=0;i<memberStr.length;i++){
            memberData.add(memberStr[i]);
        }
        adapter = new memberRecyclerAdapter(getActivity(), memberData);
        memberRecyclerView.setAdapter(adapter);
        memberRecyclerView.addItemDecoration(new RecyclerDivider(getContext(), RecyclerDivider.VERTICAL_LIST));
        memberRippleView = (RippleView) view.findViewById(R.id.member_rv);
        memberRippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Context context = getContext();
                Intent intent = new Intent(context, MemberActivity.class);
                context.startActivity(intent);
            }
        });
    
        return view;
    }

    private class memberRecyclerAdapter extends RecyclerView.Adapter<memberViewHolder> {


        private List<String> items = new ArrayList<String>();

        private Context context;
        private LayoutInflater mLayoutInflater;

        public memberRecyclerAdapter(Context context) {
            this.context = context;
        }

        public memberRecyclerAdapter(Context context, List<String> items) {
            this.context = context;
            this.items = (items != null ? items : new ArrayList<String>());
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public memberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.member_item, parent, false);

            return new memberViewHolder(view);
        }

        @Override
        public void onBindViewHolder(memberViewHolder holder, int position) {
            holder.tvMember.setText(items.get(position));
            holder.rvMember.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                @Override
                public void onComplete(RippleView rippleView) {
                    Context context = getContext();
                    Intent intent = new Intent(context, ItemListActivity.class);
                    context.startActivity(intent);
                }
            });
        }

        //添加数据
        public  void addData(String data, int pos) {
            items.add(data);
            notifyItemInserted(pos);
        }

        @Override
        public int getItemCount() {
            return (this.items != null) ? this.items.size() : 0;
        }
    }

    private class memberViewHolder extends RecyclerView.ViewHolder {
        private RippleView rvMember;
        private TextView tvMember;

        public memberViewHolder(View itemView) {
            super(itemView);
            this.rvMember = (RippleView) itemView.findViewById(R.id.member_rv);
            this.tvMember = (TextView) itemView.findViewById(R.id.member_item_tv);
        }
    }
}
