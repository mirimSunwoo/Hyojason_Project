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

public class GalleryAdapter extends BaseAdapter{
    Context context;
    int[] posterIds = {R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,
            R.drawable.food6,R.drawable.food7,R.drawable.food8,R.drawable.food9,R.drawable.food10};
    int[] titleIds = {R.string.food1,R.string.food2,R.string.food3,R.string.food4,R.string.food5,
            R.string.food6,R.string.food7,R.string.food8,R.string.food9,R.string.food10};

    ImageView imgvLarge;

    public GalleryAdapter(Context context, ImageView imgvLarge){
        this.context = context;
        this.imgvLarge = imgvLarge;
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
        imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final int pos = position;
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgvLarge.setImageResource(posterIds[pos]);
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
