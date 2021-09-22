package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    ImageButton btnHome;
    AutoCompleteTextView btnSearch;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    
        list = new ArrayList<String>();
        settingList();

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list));

        btnHome = findViewById(R.id.btn_search_home);
        btnHome.setOnClickListener(btnHomeListener);

        btnSearch = findViewById(R.id.autoCompleteTextView);
        btnSearch.setOnClickListener(btnSearchListener);
    }

    private void settingList() {
        //고양이
        list.add("무염황태 - cat");
        list.add("무염멸치 - cat");
        list.add("무염북어 - cat");
        list.add("락토프리우유 - cat");
        list.add("블루베리 - cat");
        list.add("복숭아 - cat");
        list.add("딸기 - cat");
        list.add("배 - cat");
        list.add("파인애플 - cat");
        list.add("코코넛 - cat");
        list.add("망고 - cat");
        list.add("사과 - cat");
        list.add("멜론 - cat");
        list.add("수박 - cat");
        list.add("바나나 - cat");
        list.add("소고기 - cat");
        list.add("소간 - cat");
        list.add("돼지고기 - cat");
        list.add("닭가슴살 - cat");
        list.add("오리고기 - cat");
        list.add("상추 - cat");
        list.add("오이 - cat");
        list.add("당근 - cat");
        list.add("토마토 - cat");
        list.add("완두콩 - cat");
        list.add("브로콜리 - cat");
        list.add("고구마 - cat");
        list.add("호박 - cat");
        list.add("단호박 - cat");
        list.add("샐러리 - cat");
        list.add("시금치 - cat");
        list.add("삶은 강냉이 - cat");
        list.add("삶은 노른자 - cat");
        list.add("귀리(오트밀) - cat");
        list.add("보리 - cat");
        list.add("밀싹 - cat");
        list.add("새밥풀 - cat");
        list.add("반찬용 멸치 - cat");
        list.add("초콜릿 - cat");
        list.add("사람우유 - cat");
        list.add("자일리톨 - cat");
        list.add("치즈 - cat");
        list.add("양파 - cat");
        list.add("파 - cat");
        list.add("마늘 - cat");
        list.add("포도 - cat");
        list.add("백합 - cat");
        list.add("날고기 - cat");
        list.add("생선뼈 - cat");
        list.add("오징어 - cat");
        list.add("날 돼지고기 - cat");
        list.add("전복내장 - cat");
        list.add("겨자 - cat");
        list.add("후추 - cat");
        list.add("애견사료 - cat");
        //앵무새
        list.add("펠렛사료 - parrot");
        list.add("알곡사료 - parrot");
        list.add("견과류 - parrot");
        list.add("짙은녹색채소 - parrot");
        list.add("노란색채소 - parrot");
        list.add("사과 - parrot");
        list.add("호박 - parrot");
        list.add("포도 - parrot");
        list.add("당근 - parrot");
        list.add("파슬리 - parrot");
        list.add("브로콜리 - parrot");
        list.add("망고 - parrot");
        list.add("고구마 - parrot");
        list.add("애호박 - parrot");
        list.add("시금치 - parrot");
        list.add("퀴노아 - parrot");
        list.add("현미 - parrot");
        list.add("빻은 밀 - parrot");
        list.add("보리 - parrot");
        list.add("삶은 달걀 - parrot");
        list.add("치즈가루 - parrot");
        list.add("우유 - parrot");
        list.add("치즈 - parrot");
        list.add("아이스크림 - parrot");
        list.add("요플레 - parrot");
        list.add("버터 - parrot");
        list.add("초콜릿 - parrot");
        list.add("초콜릿 아이스크림 - parrot");
        list.add("초콜릿 과자 - parrot");
        list.add("과일 씨 - parrot");
        list.add("커피 - parrot");
        list.add("닭고기 - parrot");
        list.add("소고기 - parrot");
        list.add("돼지고기 - parrot");
        list.add("생선 - parrot");
        list.add("아보카도 - parrot");
        list.add("소금 - parrot");
        list.add("사람음식 - parrot");
        list.add("말린과일 - parrot");
        //강아지
        list.add("북어 - dog");
        list.add("두부 - dog");
        list.add("파프리카 - dog");
        list.add("연어 - dog");
        list.add("고구마 - dog");
        list.add("양배추 - dog");
        list.add("단호박 - dog");
        list.add("블루베리 - dog");
        list.add("달걀 노른자 - dog");
        list.add("표고버섯 - dog");
        list.add("닭가슴살 - dog");
        list.add("당근 - dog");
        list.add("시금치 - dog");
        list.add("오이 - dog");
        list.add("수박 - dog");
        list.add("바나나 - dog");
        list.add("사과 - dog");
        list.add("키위 - dog");
        list.add("오렌지 - dog");
        list.add("배 - dog");
        list.add("포도 - dog");
        list.add("우유 - dog");
        list.add("초콜릿 - dog");
        list.add("어패류 - dog");
        list.add("양파 - dog");
        list.add("포도 - dog");
        list.add("아보카도 - dog");
        list.add("카페인 - dog");
        list.add("자일리톨 - dog");
        list.add("뼈 - dog");
        list.add("사과씨 - dog");
        list.add("고양이 사료 - dog");
        list.add("팝콘 - dog");
        list.add("옥수수 - dog");
        list.add("알코올 - dog");
        list.add("견과류 - dog");
        list.add("마늘 - dog");
        //햄스터
        list.add("사과 - hamster");
        list.add("바나나 - hamster");
        list.add("포도 - hamster");
        list.add("포도씨 - hamster");
        list.add("민들레 - hamster");
        list.add("멜론 - hamster");
        list.add("클로버 - hamster");
        list.add("냉이 - hamster");
        list.add("망고 - hamster");
        list.add("아몬드 - hamster");
        list.add("라즈베리 - hamster");
        list.add("딸기 - hamster");
        list.add("브로콜리 - hamster");
        list.add("당근 - hamster");
        list.add("단호박 - hamster");
        list.add("옥수수 - hamster");
        list.add("해바라기씨 - hamster");
        list.add("시금치 - hamster");
        list.add("단호박 - hamster");
        list.add("고구마 - hamster");
        list.add("파프리카 - hamster");
        list.add("쇠고기(익힌 간) - hamster");
        list.add("치즈(저지방 코티지) - hamster");
        list.add("메뚜기 - hamster");
        list.add("밀웜 - hamster");
        list.add("피스타치오 - hamster");
        list.add("우유(동물용) - hamster");
        list.add("달걀 - hamster");
        list.add("요거트(저지방 플레인) - hamster");
    }

    View.OnClickListener btnHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnSearchListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), SearchShowActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
