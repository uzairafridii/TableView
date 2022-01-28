package com.uzair.tableview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.evrencoskun.tableview.TableView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TableView tableView;
    TableViewAdapter tableViewAdapter;
    List<ColumnHeader> list = new ArrayList<>();
    List<RowHeader> rowList = new ArrayList<>();
    List<List<Cell>> cellList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tableView = findViewById(R.id.tableView);

        addColumns();
        addRow();
        addCell();

        Log.d("TAG", "onCreate: "+cellList.size());
        Log.d("TAG", "onCreate: "+rowList.size());
        Log.d("TAG", "onCreate: "+list.size());

        tableViewAdapter = new TableViewAdapter();
        tableView.setAdapter(tableViewAdapter);
        tableViewAdapter.setAllItems(list, rowList, cellList);


    }


    private void addRow() {

        for (int i = 0; i < 10; i++) {
            RowHeader header = new RowHeader("row " + i);
            rowList.add(header);
        }
    }

    private void addColumns() {
        for (int i = 0; i < 4; i++) {
            String title = "column " + i;
            int nRandom = new Random().nextInt();
            if (nRandom % 4 == 0 || nRandom % 3 == 0 || nRandom == i) {
                title = "large column " + i;
            }

            ColumnHeader header = new ColumnHeader(title);
            list.add(header);
        }


    }


    private void addCell() {
        for (int i = 0; i < 10; i++) {
            List<Cell> cList = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                String text = "cell " + j + " " + i;
                final int random = new Random().nextInt();
                // Create dummy id.
                String id = j + "-" + i;
                Cell cell = new Cell(text);
                cList.add(cell);
            }
            cellList.add(cList);
        }


    }
}