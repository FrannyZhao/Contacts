package com.microsoft.contacts.UI.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.microsoft.contacts.R;

/**
 * Created by zhaofengyi on 2018/12/8.
 */

public class AvatarView extends android.support.v7.widget.AppCompatImageView {
    private static final String TAG = AvatarView.class.getSimpleName();
    int mBorderWidth = 0;
    int mBorderColor = 0;
    private boolean isSelected = false;

    private Path mPath = new Path();
    private Paint paint = new Paint();

    public AvatarView(Context context) {
        super(context);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.avatarRoundImageView, defStyle, 0);
        mBorderWidth = a.getDimensionPixelSize(R.styleable.avatarRoundImageView_border_width, 0);
        mBorderColor = a.getColor(R.styleable.avatarRoundImageView_border_color, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float cx = getMeasuredWidth() / 2L;
        float cy = getMeasuredHeight() / 2L;
        float cr = cx < cy ? cx : cy;
        canvas.scale(1.0f, 1.0f, cx, cy);
        mPath.reset();
        mPath.addCircle(cx, cy, cr, Path.Direction.CCW);
        canvas.clipPath(mPath);
        super.onDraw(canvas);
        if (isSelected && mBorderWidth != 0 && mBorderColor != 0) {
            drawRoundBorder(canvas, cx, cy, cr);
        }
    }

    /**
     * 画圆角ImageView的边框
     *
     * @param canvas 画布
     */
    private void drawRoundBorder(Canvas canvas, float width, float height, float min) {
        mPath.reset();
        paint.setStrokeWidth(mBorderWidth);
        paint.setColor(mBorderColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        float radius = min - mBorderWidth / 2;
        mPath.addCircle(width, height, radius, Path.Direction.CCW);
        canvas.drawPath(mPath, paint);
    }

    public void setmBorderWidth(int mBorderWidth) {
        this.mBorderWidth = mBorderWidth;
    }

    public void setmBorderColor(int mBorderColor) {
        this.mBorderColor = mBorderColor;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
