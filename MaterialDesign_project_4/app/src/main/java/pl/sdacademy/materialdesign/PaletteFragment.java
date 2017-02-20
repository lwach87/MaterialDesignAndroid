package pl.sdacademy.materialdesign;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PaletteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_palette, container, false);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) getContext().getDrawable(R.drawable.bg_image);
        ((ImageView) rootView.findViewById(R.id.image)).setImageDrawable(bitmapDrawable);

        Bitmap bitmap = bitmapDrawable.getBitmap();

        Palette palette = Palette.from(bitmap).generate();

        rootView.findViewById(R.id.color1).setBackgroundColor(palette.getLightVibrantColor(Color.TRANSPARENT));
        rootView.findViewById(R.id.color2).setBackgroundColor(palette.getVibrantColor(Color.TRANSPARENT));
        rootView.findViewById(R.id.color3).setBackgroundColor(palette.getDarkVibrantColor(Color.TRANSPARENT));
        rootView.findViewById(R.id.color4).setBackgroundColor(palette.getLightMutedColor(Color.TRANSPARENT));
        rootView.findViewById(R.id.color5).setBackgroundColor(palette.getMutedColor(Color.TRANSPARENT));
        rootView.findViewById(R.id.color6).setBackgroundColor(palette.getDarkMutedColor(Color.TRANSPARENT));

        return rootView;
    }
}
