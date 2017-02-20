package pl.sdacademy.materialdesign;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MaterialPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public MaterialPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AnimationFragment();
            case 1:
                return new ElevationFragment();
            case 2:
                return new PaletteFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    /**
     * Musimy przeciążyć tę metodę aby w naszym TabLayout wyświetlały się tytuły dla stron zwracanych
     * przez ten adapter.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.action_material_design);
            case 1:
                return context.getString(R.string.action_elevation);
            case 2:
                return context.getString(R.string.action_palette);
        }

        return null;
    }
}