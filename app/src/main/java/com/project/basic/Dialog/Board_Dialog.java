package com.project.basic.Dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.basic.Activity.MainActivity;
import com.project.basic.Board.BoardText;
import com.project.basic.Fragment.BoardFragment;
import com.project.basic.R;

public class Board_Dialog extends Dialog{

    private Button craeteCloseBtn;
    private View.OnClickListener mCreateCloseListener;
    private BoardText mselectItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_board);

        craeteCloseBtn = (Button) findViewById(R.id.createClose);
        craeteCloseBtn.setOnClickListener(mCreateCloseListener);
        TextView userId = (TextView)findViewById(R.id.createBoardId);
        TextView boardTime = (TextView)findViewById(R.id.createBoardTime);
        TextView boardTitle  = (TextView)findViewById(R.id.createBoardTitle);
        TextView boardContext  = (TextView)findViewById(R.id.createBoardContext);
        boardTime.setText(mselectItem.getBoardTime());
        boardTitle.setText(mselectItem.getBoardTitle());
        userId.setText(mselectItem.getUserID());
        boardContext.setText(mselectItem.getBoardContext());
    }

    public Board_Dialog(Context context, View.OnClickListener CreateCloseListener,BoardText selectItem) {
        super(context);
        this.mCreateCloseListener = CreateCloseListener;
        this.mselectItem = selectItem;
    }
}

