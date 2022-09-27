package kr.ac.duksung.scheduler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
//        android.util.Log.i("lifecycle", "Memo:onCreate");

        // 이번에는 지역 변수로 선언해서 사용 (이전에는 필드 값으로 선언)
        // final 상수로 사용한다는 의미 - 한번 쓰고 말 것이라서 final 선언해도 괜찮다
        final TextView textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button2);
        final EditText editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 화면 전환해서 이전의 값을 가져오려면 getIntent()로
                // 값을 가져와야 한다
                Intent intent = getIntent();
                // tagging 값을 찾아서 가져오라는 뜻
                String appointment = intent.getStringExtra("appoint");
                // 가져온 값을 String 객체로 가져오기
                String memo = editText.getText().toString();
                // 화면에 보여주기
                textView.setText(memo + " : " + appointment);
            }
        });

    }
    /* 다음 수업 시간에 사용
    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("lifecycle", "Memo:onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("lifecycle", "Memo:onStop");
    }
     */
}

