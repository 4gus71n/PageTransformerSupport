package com.example.skeleton;

import android.os.Build;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;

public class ZoomOutPageTransformer implements PageTransformer {
	private static float MIN_SCALE = 0.85f;
    private static float MIN_ALPHA = 0.5f;
	
	
    public void transformPage(View view, float position) {
    	int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
        	AnimatorProxy.wrap(view).setAlpha(0);
        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
            	AnimatorProxy.wrap(view).setTranslationX(horzMargin - vertMargin / 2);
            } else {
            	AnimatorProxy.wrap(view).setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between MIN_SCALE and 1)
            AnimatorProxy.wrap(view).setScaleX(scaleFactor);
            AnimatorProxy.wrap(view).setScaleY(scaleFactor);

            // Fade the page relative to its size.
            AnimatorProxy.wrap(view).setAlpha(MIN_ALPHA +
                    (scaleFactor - MIN_SCALE) /
                    (1 - MIN_SCALE) * (1 - MIN_ALPHA));
        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
        	AnimatorProxy.wrap(view).setAlpha(0);
        }
    }
}