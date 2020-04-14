package com.lec.android.a003_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;


    // onCreate()
    // 액티비티(화면 객체)가 생성될때 호출되는 메소드
    // 액티비티 초기화 하는 코드 작성.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);

        tvResult = findViewById(R.id.tvResult);
        final LinearLayout ll = findViewById(R.id.ll);   // Local inner 에서 사용할수 있는 것은
                                                        // 멤버변수, effective final !!

        // 방법2 : 익명 클래스 (anonymous class) 사용.
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // 클릭되었을때 호출되는 메소드 (콜백 메소드 callback method)
                Log.d("myapp", "버튼2가 클릭 되었습니다");
                tvResult.setText("버튼2 가 클릭됨");
                tvResult.setBackgroundColor(Color.YELLOW);
            }
        });

        // 다양한 이벤트, 다양한 리스너 등록 가능
        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {  // 롱클릭 발생시 수행하는 콜백 메소드
                Log.d("myapp", "버튼2가 롱클릭 되었습니다.");
                tvResult.setText("버튼2가 롱클릭 되었습니다");
                tvResult.setBackgroundColor(Color.CYAN);
                //return false;  // false 리턴하면 이벤트가 click 까지 간다.
                return true;   // true 리턴하면 이벤트가 long click 으로 소멸 (consume) 된다.
            }
        });

        // 방법3 : lambda - expression 사용하기
        // AndroidStudio 의 세팅 필요! ppt 참조!
        btn3.setOnClickListener((v) -> {    // onClick(View v)
            Log.d("myapp", "버튼3 가 클릭 되었다");
            tvResult.setText("버튼3 클릭됨");
            ll.setBackgroundColor(Color.rgb(164, 198, 57));
        });




    } // end onCreate()

    // 방법1 : 레이아웃 xml 의 onXXX 속성으로 지정
    public void changeText(View v){
        // Log.d(tag, message)
        //  Log 창의 Debug 메세지로 출력
        Log.d("myapp", "버튼 1이 클릭되었습니다");
        tvResult.setText("버튼1 이 클릭 되었습니다.");
    }


} // end Activity













