package com.youquan.custom.grid;

import java.util.List;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;
import com.util.PicassoUtils;
import com.util.StringUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Toast;

public class MyGridView extends NineGridLayout {

	protected static final int MAX_W_H_RATIO = 3;

	public MyGridView(Context context) {
		super(context);
	}

	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected boolean displayOneImage(final RatioImageView imageView, String url, final int parentWidth) {
		Picasso.with(mContext).load(StringUtils.reviseEmpty(url)).into(new Target() {
			@Override
			public void onPrepareLoad(Drawable arg0) {
			}

			@Override
			public void onBitmapLoaded(Bitmap bitmap, LoadedFrom arg1) {
				if (bitmap != null) {
					int w = bitmap.getWidth();
					int h = bitmap.getHeight();

					int newW;
					int newH;
					if (h > w * MAX_W_H_RATIO) {// h:w = 5:3
						newW = parentWidth / 2;
						newH = newW * 5 / 3;
					} else if (h < w) {// h:w = 2:3
						newW = parentWidth * 2 / 3;
						newH = newW * 2 / 3;
					} else {// newH:h = newW :w
						newW = parentWidth / 2;
						newH = h * newW / w;
					}
					setOneImageLayoutParams(imageView, newW, newH);
					imageView.setImageBitmap(bitmap);
				}
			}

			@Override
			public void onBitmapFailed(Drawable arg0) {
			}
		});
		return false;
	}

	@Override
	protected void displayImage(RatioImageView imageView, String url) {
		PicassoUtils.loadUrlPic(mContext, imageView, StringUtils.reviseEmpty(url));
	}

	@Override
	protected void onClickImage(int i, String url, List<String> urlList) {
		Toast.makeText(mContext, "点击了图片" + url, Toast.LENGTH_SHORT).show();
	}
}