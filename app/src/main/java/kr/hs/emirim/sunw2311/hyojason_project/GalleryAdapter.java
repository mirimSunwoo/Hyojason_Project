package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GalleryAdapter extends BaseAdapter{
    Context context;
    int[] posterIds = {R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,
            R.drawable.food6,R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10};
    int[] titleIds = {R.string.food1,R.string.food2,R.string.food3,R.string.food4,R.string.food5,
            R.string.food6,R.string.food7,R.string.food8,R.string.food9,R.string.food10};
    String[] infoIds = {"1. 당근을 적당한 크기로 썰어 삶는다.\n2. 식용유를 두르지 않은 프라이팬에 연어를 굽는다.\n3. 구운 연어와 당근을 먹기 좋게 자른다.",
                        "1. 간수를 뺀 두부를 5분간 데친다.\n2. 반으로 자른 단호박을 9분간 쪄낸다.\n3. 단호박 속과 두부를 함께 믹서기에 간다.\n4. 간 단호박과 두부에 물을 부어 걸쭉해질 때까지 졸인다.",
                        "1. 끓는 우유에 식초를 넣어 젓는다.\n2. 몽글몽글 뭉친 덩어리(=치즈)를 걸러낸다.\n3. 닭가슴살을 믹서기에 간다.\n4. 닭가슴살과 치즈, 달걀노른자를 섞어 반죽을 만들고 볼 형태로 떼어낸다.\n5. 볼을 15분 동안 쪄낸다.",
                        "1. 염분 제거를 위해 황태를 물에 끓여준다.\n2. 새로운 물로 중불에서 오랫동안 고와준다.\n3. 사료에 섞어 급여한다.",
                        "1. 찹쌀을 물에 3시간 이상 불려준다.\n2. 닭가슴살을 끓는 물에 삶는다.\n3. 닭가슴살을식힌 후 잘게 찢어준다.\n4. 당근과 파프리카를 잘게 썬다.\n5. 불린 찹쌀을 참기름, 당근, 파프리카와 같이 볶아준다.\n6. 닭가슴살과 육수를 부어 찹쌀이 풀어질 때까지 끓여준다",
                        "1. 소고기 등심을 핏물 제거 후\n" + "먹기 좋은 크기로 깍둑썰기\n" + "2. 브로콜리 끓는 물에 데치기\n" + "3. 파프리카, 새송이버섯, 브로콜리 잘게 썰기 \n" + "4. 소고기와 야채 같이 굽기",
                        "1. 달걀을 풀어준다\n" + "2. 브로콜리, 파프리카, 새송이버섯을\n" + "잘게 썰어준다\n" + "3. 달걀과 야채, 물을 잘 섞어 준다\n" + "4. 중불로 약 15분간 쪄준다",
                        "1. 식초를 푼 물에 닭가슴살을 깨끗이 씻어준다\n" + "2. 먹기 좋은 크기로 길게 잘라 준다\n" + "3. 식품 건조기에 넣고\n" + "60도에서 6시간 동안 건조한다",
                        "1. 고구마를 깨끗이 씻은 후 쪄준다\n" + "2. 적당한 크기로 자른다\n" + "3. 식품 건조기에 넣고\n" + "약 7시간 동안 말려준다",
                        "1. 바나나를 깨끗이 씻은 후 쪄준다\n" + "2. 적당한 크기로 자른다\n" + "3. 식품 건조기에 넣고\n" + "약 7시간 동안 말려준다"};
    ImageView imgvLarge;
    TextView infoLarge;

    public GalleryAdapter(Context context, ImageView imgvLarge, TextView infoLarge){
        this.context = context;
        this.imgvLarge = imgvLarge;
        this.infoLarge = infoLarge;
    }
    @Override
    public int getCount() {
        return posterIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imgv = new ImageView(context);
        imgv.setLayoutParams(new Gallery.LayoutParams(200,300));
        imgv.setImageResource(posterIds[position]);
//        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        TextView infov = new TextView(context);
        infov.setLayoutParams(new ViewGroup.LayoutParams(100,20));
        infov.setText(infoIds[position]);
        final int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgvLarge.setImageResource(posterIds[pos]);
                infoLarge.setText(infoIds[pos]);
                Toast toast = new Toast(context);
                View toastView = View.inflate(context,R.layout.toast1,null);
                TextView textTitle = toastView.findViewById(R.id.text_title);
                textTitle.setText(titleIds[pos]);
                toast.setView(toastView);
                toast.show();
            }
        });
        return imgv;
    }
}
