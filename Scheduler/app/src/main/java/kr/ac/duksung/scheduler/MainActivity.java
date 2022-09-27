package kr.ac.duksung.scheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    RadioButton rdoDate, rdoTime;
    DatePicker datePicker;
    TimePicker timePicker;
    String date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        android.util.Log.i("lifecycle", "Main:onCreate");

        button = (Button) findViewById(R.id.button);
        rdoDate = (RadioButton) findViewById(R.id.radioButton1);
        rdoTime = (RadioButton) findViewById(R.id.radioButton2);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        // 처음에는 두 picker를 안보이게 설정
        timePicker.setVisibility(View.INVISIBLE);
        datePicker.setVisibility(View.INVISIBLE);

        rdoDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 어떤 버튼을 누르느냐에 따라 보이게 하는 것이 다르다
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 어떤 버튼을 누르느냐에 따라 보이게 하는 것이 다르다
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });
        // api 26 부터 지원 되는 메소드라 api를 26으로 올리거나 다른 걸 쓰거나 해야 한다
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                // 년 월 일 을 date에 저장함
                date = i + "/" + (i1+1) + "/" + i2;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time = timePicker.getHour() + ":" + timePicker.getMinute();
                String appointment = date + " " + time;
                Toast.makeText(getApplicationContext(), appointment, Toast.LENGTH_LONG).show();

                // Intent 객체로 화면 전환 (화면 전환 객체)
                // 화면 전환 전담 객체 생성
                Intent intent = new Intent(getApplicationContext(), MemoActivity.class);
                // 외부로 보내는 값
                // dictional 형태로 putExtra에 보내면 된다
                intent.putExtra("appoint", appointment);
                startActivity(intent);
            }
        });
    }

/*
    // 다음 시간에 사용
    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("lifecycle", "Main:onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("lifecycle", "Main:onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i("lifecycle", "Main:onRestart");
    }

 */

}
