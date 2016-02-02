package saulo.com.earthquake.utils;

import android.graphics.Color;
import android.util.Log;

/**
 * Created by saulo on 1/02/16.
 */
public class ColorCalculator {

    public static int getColor(double magnitude){
        if(magnitude >= 0.0 && magnitude <= 0.9)
        {
            return Color.argb(Constants.CARD_ALPHA, 0, 255, 0);
        }
        if(magnitude >= 9.0 && magnitude >= 9.9 )
        {
            return Color.argb(Constants.CARD_ALPHA, 255, 0, 0);
        }

        double magnitudeScale = 8.0 / 100;
        double colorStep = 255/100;
        magnitude -= 1;
        double red = 0;
        double green = 255;

        while(magnitude > 0)
        {
            red += colorStep;
            green -= colorStep;
            magnitude -= magnitudeScale;
        }

        return Color.argb(Constants.CARD_ALPHA, (int) red, (int) green, 0);
    }
}
