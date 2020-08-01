package com.polydome.analogclock;

import android.content.res.Resources;

class ResourcesDimensionConverter implements DimensionConverter {
    Resources resources;

    public ResourcesDimensionConverter(Resources resources) {
        this.resources = resources;
    }

    @Override
    public int px(int dp) {
        return (int) (dp * resources.getDisplayMetrics().density + 0.5);
    }
}
