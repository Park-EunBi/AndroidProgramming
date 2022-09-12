package kr.ac.duksung.converterlineartwoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    // 메인 화면으로 돌아가는 버튼
    Button goBack;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // 메인 화면으로 돌아가기
        goBack = (Button) findViewById(R.id.button);

        // 사용자로부터 이미지 입력 받기 위해
        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setImageResource(R.drawable.eun);

        // 버튼에 리스너 연결
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}