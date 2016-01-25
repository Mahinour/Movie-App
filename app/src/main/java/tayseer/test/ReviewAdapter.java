package tayseer.test;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ReviewAdapter extends ArrayAdapter<Review> {

    private Context mContext;
    private ArrayList<Review> mReview = new ArrayList<Review>();
    private  int layoutResourceId;

    public ReviewAdapter(Context mContext, int layoutResourceId, ArrayList<Review> mReview) {
        super(mContext, layoutResourceId, mReview);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mReview = mReview;
    }
    public void setListData(ArrayList<Review> mReview){
        this.mReview=mReview;
        notifyDataSetChanged();

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();

            holder.author = (TextView) row.findViewById(R.id.author);
            holder.content = (TextView) row.findViewById(R.id.content);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        Review item = mReview.get(position);
        holder.author.setText(item.getAuthor());

        holder.content.setText(item.getContent());
        return row;
    }

    static class ViewHolder {

        TextView author;
        TextView content;
    }
}
