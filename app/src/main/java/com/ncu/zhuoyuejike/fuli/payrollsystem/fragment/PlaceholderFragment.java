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
import com.ncu.zhuoyuejike.fuli.payrollsystem.ItemDetailActivity;
import com.ncu.zhuoyuejike.fuli.payrollsystem.ItemDetailFragment;
import com.ncu.zhuoyuejike.fuli.payrollsystem.R;
import com.ncu.zhuoyuejike.fuli.payrollsystem.fragment.dummy.DummyContent;

import java.util.List;

/**
 * Created by Administrator on 2016/7/9.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private OnListFragmentInteractionListener mListener;

    public PlaceholderFragment() {
    }

    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_list, container, false);
        RecyclerView placeRecyclerView = (RecyclerView) rootView;
        placeRecyclerView.setAdapter(new MyItemRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        //分割线
        placeRecyclerView.addItemDecoration(new RecyclerDivider(getContext(),RecyclerDivider.VERTICAL_LIST));
        return rootView;
    }
    //自定义接口
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyContent.DummyItem item);
    }

    public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

        private final List<DummyContent.DummyItem> mValues;
        private final OnListFragmentInteractionListener mListener;

        public MyItemRecyclerViewAdapter(List<DummyContent.DummyItem> items, OnListFragmentInteractionListener listener) {
            mValues = items;
            mListener = listener;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mContentView.setText(mValues.get(position).content);

            holder.mView.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                @Override
                public void onComplete(RippleView rippleView) {
                    //                if (null != mListener) {
                    //                    // Notify the active callbacks interface (the activity, if the
                    //                    // fragment is attached to one) that an item has been selected.
                    //                    mListener.onListFragmentInteraction(holder.mItem);
                    //                }

                        Context context = getContext();
                        Intent intent = new Intent(context, ItemDetailActivity.class);
                        intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final RippleView mView;
            public final TextView mContentView;
            public DummyContent.DummyItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = (RippleView) view.findViewById(R.id.place_rv);
                mContentView = (TextView) view.findViewById(R.id.place_content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
