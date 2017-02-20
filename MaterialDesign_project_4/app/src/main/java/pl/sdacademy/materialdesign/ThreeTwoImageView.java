package pl.sdacademy.materialdesign;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Widok ustawiajacy wysokość obrazka zawsze na 2/3 jego szerokości
 */
public class ThreeTwoImageView extends ImageView {

    public ThreeTwoImageView(Context context) {
        super(context);
    }

    public ThreeTwoImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThreeTwoImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = MeasureSpec.getSize(widthMeasureSpec) / 3 * 2;
        int heightSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
