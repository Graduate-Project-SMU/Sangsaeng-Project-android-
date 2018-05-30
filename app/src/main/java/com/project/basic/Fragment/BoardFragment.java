package com.project.basic.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.basic.Board.BoardListAdapter;
import com.project.basic.Board.BoardText;
import com.project.basic.Board.makeBoardActivity;
import com.project.basic.Dialog.Board_Dialog;
import com.project.basic.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;r

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class BoardFragment extends Fragment {

    private ListView listView;
    private BoardListAdapter adapter;
    private List<BoardText> boardList;
    private ImageButton createBtn;
    private ImageButton refreshBtn;
    private ImageButton searchBtn;
    private Board_Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_board, container ,false);

        createBtn = (ImageButton)view.findViewById(R.id.createBoardBtn);
        refreshBtn = (ImageButton)view.findViewById(R.id.boardRefresh);
        searchBtn = (ImageButton)view.findViewById(R.id.boardSearch);
        listView = (ListView)view.findViewById(R.id.board);
        boardList = new ArrayList<BoardText>();

        //todo : Json으로 데이터 받아와서 리스트에 추가하기
        boardList.add(new BoardText("가","가","기","가"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("1","2","3","4"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        boardList.add(new BoardText("나","나","나","나"));
        //===========================================================================================

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://13.125.61.58:3001/board/show")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.d("TEST", "ERROR Message : " + e.getMessage());
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                String responseData = response.body().string();
                Log.d("TEST", "responseData : " + responseData);

            }
        });

        // 방법 2
//        run("http://13.125.61.58:3001/board/show");
//        String run(String url) throws IOException {
//            Request request = new Request.Builder().url(url).build();
//
//            Response response = client.newCall(request).execute();
//            return response.body().string();
//        }

        // 방법 3
//        Response responseClient = null;
//        try {
//            responseClient = client.newCall(request).execute();
//            Log.d("TEST", "responseData : " + responseClient.toString());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //=====

        adapter = new BoardListAdapter(getActivity(),boardList);
        listView.setAdapter(adapter);

        // 글 보기(다이얼로그)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BoardText selectItem = (BoardText) adapterView.getItemAtPosition(i);
                Dialog(selectItem);
            }
        });
        // 글 작성하기 버튼 클릭
        createBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent connectMakeActicity = new Intent(getActivity(), makeBoardActivity.class );
                startActivity(connectMakeActicity);
            }
        });


        // 글 새로고침 클릭

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //todo : 새로고침 구현
                Toast.makeText(getActivity(), "새로고침", Toast.LENGTH_SHORT).show();
            }
        });

        // 글 검색 클릭
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // todo : 검색 구현
                Toast.makeText(getActivity(), "검색", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }

    public void Dialog(BoardText selectItem) {
        dialog = new Board_Dialog(getActivity(), CreateCloseListener, selectItem);
        dialog.setCancelable(true);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }
    private View.OnClickListener CreateCloseListener = new View.OnClickListener() {
        public void onClick(View v) {
            dialog.dismiss();
        }
    };


}
