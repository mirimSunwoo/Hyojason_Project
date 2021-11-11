package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Review_Adapter extends SimpleCursorAdapter {
    private Cursor c;
    private int layout;
    private Context context;
    private String[] from;
    private int[] to;

    public Review_Adapter(Context context, int layout, Cursor c, String[] from, int[] to) {
        super(context, layout, c, from, to);
        this.c = c;
        this.layout = layout;
        this.context = context;
        this.from = from;
        this.to = to;
    }
    public View getView(int pos, View inView, ViewGroup parent) {
        View v = inView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(layout, null);
        }
        c.moveToPosition(pos);

        String struri = c.getString(c.getColumnIndex(from[0]));
        String txt = c.getString(c.getColumnIndex(from[1]));

        TextView textView = (TextView) v.findViewById(to[1]);
        textView.setText(txt);

        return (v);
    }
}
