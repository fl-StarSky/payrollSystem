package com.ncu.zhuoyuejike.fuli.payrollsystem;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.ncu.zhuoyuejike.fuli.payrollsystem.fragment.RecyclerDivider;

import java.util.ArrayList;
import java.util.List;

public class MemberActivity extends AppCompatActivity {

    private RecyclerView activityMemRecyclerView;
    private String[] str = new String[]{"员工ID", "姓名", "职务", "部门", "基本工资", "加班津贴", "年度绩效薪酬"};
    private List<String> datas;
    private MemberItemRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("添加信息");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//添加系统自带后退按钮
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Snackbar.make(toolbar, "dianjilewancheng", Snackbar.LENGTH_SHORT).show();
                onBackPressed();
                return true;
            }
        });

        datas = new ArrayList<String>();
        for (int i = 0; i < str.length; i++) {
            datas.add(str[i]);
        }


        activityMemRecyclerView = (RecyclerView) findViewById(R.id.activity_member_list);
        adapter = new MemberItemRecyclerViewAdapter(datas, getApplicationContext());
        activityMemRecyclerView.setAdapter(adapter);
        activityMemRecyclerView.addItemDecoration(new RecyclerDivider(this, RecyclerDivider.VERTICAL_LIST));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.member_setting, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //获取toolbar后退按钮的监听事件
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class MemberItemRecyclerViewAdapter extends RecyclerView.Adapter<MemberActivity.ViewHolder> {

        private List<String> titles = new ArrayList<String>();
        private Context context;


        public MemberItemRecyclerViewAdapter(List<String> titles, Context context) {
            this.titles = titles;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_member_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.title.setText(titles.get(position));
            holder.memberActivityRv.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                @Override
                public void onComplete(RippleView rippleView) {
                    View departDialog = getLayoutInflater().inflate(R.layout.dialog_fragment, (ViewGroup) findViewById(R.id.dialog_ll), false);
                    final EditText editText = (EditText) departDialog.findViewById(R.id.dialog_et);
                    String dialogTitle = "输入" + titles.get(position);
                    new AlertDialog.Builder(MemberActivity.this, R.style.AlertDialogCustom).setTitle(dialogTitle)
                            .setView(departDialog).setPositiveButton("完成", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            holder.msg.setText(editText.getText().toString());
                        }
                    }).setNegativeButton("取消", null).show();
                }
            });
        }


        @Override
        public int getItemCount() {
            return titles.size();
        }


    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView msg;
        private final RippleView memberActivityRv;

        public ViewHolder(View itemView) {
            super(itemView);
            memberActivityRv = (RippleView) itemView.findViewById(R.id.activity_member_rv);
            title = (TextView) itemView.findViewById(R.id.activity_member_item_tv);
            msg = (TextView) itemView.findViewById(R.id.activity_member_item_view);
        }
    }

}
