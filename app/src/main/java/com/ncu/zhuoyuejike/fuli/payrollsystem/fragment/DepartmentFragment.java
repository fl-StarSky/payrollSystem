package com.ncu.zhuoyuejike.fuli.payrollsystem.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.ncu.zhuoyuejike.fuli.payrollsystem.ItemListActivity;
import com.ncu.zhuoyuejike.fuli.payrollsystem.R;

import java.util.ArrayList;
import java.util.List;

/**
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public class DepartmentFragment extends Fragment {
    private EditText editText;
    private List<String> departData;
    private DepartRecyclerAdapter adapter;
    private int count;
    private View departDialog;
//    private String[] strings=new String[]{"22","ss2","2sdds2","2rg2","2gw2","2fewf2","22","22","22","22","22","2fcds2","22"};

    public static DepartmentFragment newInstance() {
        DepartmentFragment fragment = new DepartmentFragment();
        return fragment;
    }

    //创建该fragment的视图
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.depart_fragment, container, false);
        RecyclerView departRecyclerView = (RecyclerView) view.findViewById(R.id.depart_list);
        departData = new ArrayList<String>();
//        for (int i=0;i<strings.length;i++){
//            departData.add(strings[i]);
//        }
        adapter = new DepartRecyclerAdapter(getActivity(), departData);
        departRecyclerView.setAdapter(adapter);
        departRecyclerView.addItemDecoration(new RecyclerDivider(getContext(), RecyclerDivider.VERTICAL_LIST));
       RippleView departRippleView = (RippleView) view.findViewById(R.id.depart_rv);
        departRippleView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
               departDialog = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment, (ViewGroup) getActivity().findViewById(R.id.dialog_ll), false);
                editText = (EditText) departDialog.findViewById(R.id.dialog_et);
                new AlertDialog.Builder(getActivity()).setTitle("输入部门名称")
                        .setView(departDialog).setPositiveButton("完成", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.addData(editText.getText().toString(), count++);
                    }
                }).setNegativeButton("取消", null).show();
            }
        });
        //二次调用子view时，需remove子view的父view
        container.removeView(departDialog);
        return view;
    }

    private class DepartRecyclerAdapter extends RecyclerView.Adapter<DepartmentViewHolder> {


        private List<String> items = new ArrayList<String>();

        private Context context;
        private LayoutInflater mLayoutInflater;


        public DepartRecyclerAdapter(Context context) {
            this.context = context;
        }

        public DepartRecyclerAdapter(Context context, List<String> items) {
            this.context = context;
            this.items = (items != null ? items : new ArrayList<String>());
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public DepartmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.depart_item, parent, false);

            return new DepartmentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(DepartmentViewHolder holder, int position) {
            holder.tvDepart.setText(items.get(position));
            holder.rvDepart.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                @Override
                public void onComplete(RippleView rippleView) {
                    Context context = getContext();
                    Intent intent = new Intent(context, ItemListActivity.class);
                    context.startActivity(intent);
                }
            });
        }

        //添加数据
        public void addData(String data, int pos) {
            items.add(data);
            notifyItemInserted(pos);
        }

        @Override
        public int getItemCount() {
            return (this.items != null) ? this.items.size() : 0;
        }


    }

    private class DepartmentViewHolder extends RecyclerView.ViewHolder {
        private RippleView rvDepart;
        private TextView tvDepart;

        public DepartmentViewHolder(View itemView) {
            super(itemView);
            this.rvDepart = (RippleView) itemView.findViewById(R.id.depart_rv);
            this.tvDepart = (TextView) itemView.findViewById(R.id.depart_item_tv);
        }
    }
}
