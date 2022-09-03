package com.lifeline.lifelineApp;


import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private boolean compoundDrawable = true;
    private String[] localDataSet;
    private boolean isSizeBig = false;

    public void removeWarningSign(){
        compoundDrawable = false;
    }

    public void setWarningSign(){
        compoundDrawable = true;
    }

    public void setSizeBig(){
        isSizeBig = true;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.bedAndBandNo);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public CustomAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        if(compoundDrawable){
            TextView t = view.findViewById(R.id.bedAndBandNo);
            t.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.warning_sign,0);
        }
        if(isSizeBig){
            TextView t = view.findViewById(R.id.bedAndBandNo);
            t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
            LinearLayout sensorLayout = view.findViewById(R.id.sensorLayout);
            final int childCount = sensorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                TextView v = (TextView) sensorLayout.getChildAt(i);
                v.setTextSize(TypedValue.COMPLEX_UNIT_SP ,20);
            }
        }
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(localDataSet[position]);
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
