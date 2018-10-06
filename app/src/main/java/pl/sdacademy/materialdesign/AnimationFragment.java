package pl.sdacademy.materialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class AnimationFragment extends Fragment {

    private NestedScrollView scrollView;
    private CardView cardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_animation, container, false);

        scrollView = (NestedScrollView) rootView.findViewById(R.id.scroll_view);
        scrollView.setSmoothScrollingEnabled(true);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) getContext().getDrawable(R.drawable.city_motion);
        Bitmap bitmap = bitmapDrawable.getBitmap();
        Palette palette = Palette.from(bitmap).generate();

        int bg_color = palette.getDominantColor(Color.GRAY);

        cardView = (CardView) rootView.findViewById(R.id.card_view);
        cardView.setCardBackgroundColor(bg_color);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                hideCard();
            }
        });

        Button showCardButton = (Button) rootView.findViewById(R.id.show_card);
        showCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (View.GONE == cardView.getVisibility()) {
                    showCard();
                } else {
                    hideCard();
                }
            }
        });

        return rootView;
    }

    private void showCard() {
        int revealRadius = (int) Math.hypot(cardView.getWidth(), cardView.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(cardView, 0, 0, 0, revealRadius);
        anim.setInterpolator(AnimationUtils.loadInterpolator(getContext(), android.R.interpolator.fast_out_slow_in));
        cardView.setVisibility(View.VISIBLE);
        anim.start();
    }

    private void hideCard() {
        int revealRadius = (int) Math.hypot(cardView.getWidth(), cardView.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(cardView, 0, 0, revealRadius, 0);
        anim.setInterpolator(AnimationUtils.loadInterpolator(getContext(), android.R.interpolator.fast_out_slow_in));
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animator) {
                cardView.setVisibility(View.GONE);
            }
        });

        anim.start();
        scrollView.fullScroll(View.FOCUS_UP);
    }
}
