package com.uzair.tableview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

public class TableViewAdapter extends AbstractTableAdapter<ColumnHeader, RowHeader, Cell> {


    class MyCellViewHolder extends AbstractViewHolder {

        final LinearLayout cell_container;
        final TextView cell_textview;

        public MyCellViewHolder(View itemView) {
            super(itemView);
            cell_container = itemView.findViewById(R.id.cell_container);
            cell_textview = itemView.findViewById(R.id.cell_data);

        }
    }

    class MyColumnHeaderViewHolder extends AbstractViewHolder {

        final LinearLayout column_header_container;
        final TextView column_header_textview;

        public MyColumnHeaderViewHolder(View itemView) {
            super(itemView);
            column_header_container = itemView.findViewById(R.id.column_header_container);
            column_header_textview = itemView.findViewById(R.id.column_header_textView);
        }
    }

    class MyRowHeaderViewHolder extends AbstractViewHolder {

        final TextView row_header_textview;

        public MyRowHeaderViewHolder(View itemView) {
            super(itemView);
            row_header_textview = itemView.findViewById(R.id.row_header_textview);
        }
    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateCellViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_layout, parent, false);
        return new MyCellViewHolder(layout);
    }

    @Override
    public void onBindCellViewHolder(@NonNull AbstractViewHolder holder, @Nullable Cell cellItemModel, int columnPosition, int rowPosition) {
        Cell cell = (Cell) cellItemModel;

        MyCellViewHolder viewHolder = (MyCellViewHolder) holder;
        viewHolder.cell_textview.setText(cell.getmData());

        viewHolder.cell_container.getLayoutParams().width = LinearLayout.LayoutParams.WRAP_CONTENT;
        viewHolder.cell_textview.requestLayout();
    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateColumnHeaderViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.column_layout, parent, false);

        // Create a ColumnHeader ViewHolder
        return new MyColumnHeaderViewHolder(layout);
    }

    @Override
    public void onBindColumnHeaderViewHolder(@NonNull AbstractViewHolder holder, @Nullable ColumnHeader columnHeaderItemModel, int columnPosition) {
        ColumnHeader columnHeader = (ColumnHeader) columnHeaderItemModel;

        MyColumnHeaderViewHolder columnHeaderViewHolder = (MyColumnHeaderViewHolder) holder;
        columnHeaderViewHolder.column_header_textview.setText(columnHeader.getmData());

        columnHeaderViewHolder.column_header_container.getLayoutParams().width = LinearLayout
                .LayoutParams.WRAP_CONTENT;
        columnHeaderViewHolder.column_header_textview.requestLayout();
    }

    @NonNull
    @Override
    public AbstractViewHolder onCreateRowHeaderViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);

        return new MyRowHeaderViewHolder(layout);
    }

    @Override
    public void onBindRowHeaderViewHolder(@NonNull AbstractViewHolder holder, @Nullable RowHeader rowHeaderItemModel, int rowPosition) {
        RowHeader rowHeader = (RowHeader) rowHeaderItemModel;

        MyRowHeaderViewHolder rowHeaderViewHolder = (MyRowHeaderViewHolder) holder;
        rowHeaderViewHolder.row_header_textview.setText(rowHeader.getmData());
    }

    @NonNull
    @Override
    public View onCreateCornerView(@NonNull ViewGroup parent) {
        return LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cornor_layout, parent, false);
    }
}
