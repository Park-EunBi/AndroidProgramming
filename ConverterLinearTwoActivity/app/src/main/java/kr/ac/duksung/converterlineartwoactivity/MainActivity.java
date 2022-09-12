package kr.ac.duksung.converterlineartwoactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextView textView;
    // 두번째 화면을 연결할 버튼
    Button goSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        // 두번째 화면 연결
        goSecond = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fahrenStr = editText.getText().toString();
                fahrenStr = fahrenStr.trim();
                if (fahrenStr.equals("")) {
                    textView.setText("화씨값을 입력하세요~");
                    Toast.makeText(getApplicationContext(), "화씨값을 입력!!",
                            Toast.LENGTH_LONG).show();

                } else {
                    Double fahren = Double.parseDouble(fahrenStr);
                    Double celsius = (fahren - 32.0) / 1.8;
                    textView.setText("섭씨 " + celsius.toString());
                }
            }
        });

        // 두번째 페이지 연결 (버튼과 리스너 연결)
        goSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}