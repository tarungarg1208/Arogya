package com.example.arogyademo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter_ScrollImages extends PagerAdapter {

    private Context mcontext;
    private int[] mImageIds=new int[]{R.drawable.flashcards1,R.drawable.flashcards2,R.drawable.flashcards3,R.drawable.flashcards4,R.drawable.flashcards5,R.drawable.flashcards6,R.drawable.flashcards7};

    ImageAdapter_ScrollImages(Context context)
    {
        mcontext=context;
    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }
    //SELF OVERIDE

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //return super.instantiateItem(container, position);
        ImageView imageView=new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(mImageIds[position]);
        container.addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((ImageView)object);
    }

}
