package smith.lib.alerts.toast;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.animation.AlphaAnimation;
import android.view.View;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;

public class SToast {

    private static final String DARK = "#212121";
    private static final String LIGHT = "#FFFFFF";

    public static final int MODE_OK = 0;
    public static final int MODE_WARN = 1;
    public static final int MODE_DONE = 2;
    public static final int MODE_ERROR = 3;
    public static final int MODE_INFO = 4;
    public static final int MODE_HEART = 5;
    public static final int MODE_CONFUSE = 6;
    private static int type = MODE_INFO;

    private static Toast toast;
    private static Context context;
    private static String titl, text;

    private static int color = 0xFFFF5252;
    private static int icon = R.drawable.heart_img;

    public static final int LONG = Toast.LENGTH_LONG;
    public static final int SHORT = Toast.LENGTH_SHORT;
    private static int length = Toast.LENGTH_SHORT;

    public static class Adaptive {
        public Adaptive(Context ctx, int dur) {
            context = ctx;
            length = dur;
        }

        public Adaptive setTitle(String ttl) {
            titl = ttl;
            return this;
        }

        public Adaptive setText(String txt) {
            text = txt;
            return this;
        }

        public Adaptive setIconAndColor(int ic, int clr) {
            icon = ic;
            color = clr;
            return this;
        }

        public SToast show() {
            toast = new Toast(context);
            
            View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.stoast_adaptive, null);
            LinearLayout main = (LinearLayout) inflate.findViewById(R.id.main);
            LinearLayout view = (LinearLayout) inflate.findViewById(R.id.main2);
            ImageView img = (ImageView) inflate.findViewById(R.id.img);
            TextView title = (TextView) inflate.findViewById(R.id.title);
            TextView desc = (TextView) inflate.findViewById(R.id.desc);

            ui(main, color, 30);
            if (nightModeON()) {
                ui(view, Color.parseColor(DARK), 30);
                title.setTextColor(Color.parseColor(LIGHT));
                desc.setTextColor(Color.parseColor(LIGHT));
            } else {
                ui(view, Color.parseColor(LIGHT), 30);
                title.setTextColor(color);
                desc.setTextColor(Color.parseColor(DARK));
            }

            animate(img, 230);
            
            main.setClipToOutline(true);
            title.setText(titl);
            desc.setText(text);
            img.setImageResource(icon);
            
            toast.setDuration(length);
            toast.setView(inflate);
            toast.show();
            
            return new SToast();
        }
    }
    
    public static class Mode {
        
        public Mode(Context ctx, int dur) {
            context = ctx;
            length = dur;
        }
        
        public Mode setTitle(String ttl) {
            titl = ttl;
            return this;
        }

        public Mode setText(String txt) {
            text = txt;
            return this;
        }
        
        public Mode setMode(int mode) {
            type = mode;
            return this;
        }
        
        public SToast show() {
            toast = new Toast(context);
            
            View inflate = ((Activity)context).getLayoutInflater().inflate(R.layout.stoast_modes, null);
            LinearLayout main = (LinearLayout) inflate.findViewById(R.id.main);
            ImageView img = (ImageView) inflate.findViewById(R.id.img);
            TextView title = (TextView) inflate.findViewById(R.id.title);
            TextView desc = (TextView) inflate.findViewById(R.id.desc);

    	    switch (type) {
            	case MODE_OK:
                    change(main, img, "#1877F2");
    		        img.setImageResource(R.drawable.ok_img);
    		        break;
            	case MODE_WARN:
                    change(main, img, "#FF6801");
                    img.setImageResource(R.drawable.warn_img);
    	        	break;
            	case MODE_DONE:
                    change(main, img, "#43A047");
                    img.setImageResource(R.drawable.true_img);
                    break;
            	case MODE_ERROR:
                    change(main, img, "#FF5252");
                    img.setImageResource(R.drawable.false_img);
    	        	break;
            	case MODE_INFO:
                    change(main, img, "#0D47A1");
                    img.setImageResource(R.drawable.default_img);
            		break;
            	case MODE_HEART:
                    change(main, img, "#FF5252");
    	 	       img.setImageResource(R.drawable.heart_img);
    	        	break;
    	        case MODE_CONFUSE:
                    change(main, img, "#FF6801");
                    img.setImageResource(R.drawable.confuse_img);
    	        	break;
        	}

            main.setClipToOutline(true);
            ui(img, Color.parseColor("#ffffff"), 100);
            title.setText(titl);
            desc.setText(text);

            animate(img, 230);
    	
        	toast.setView(inflate);
        	toast.setDuration(length);
        	toast.show();
            
            return new SToast();
        }
    }
    
    private static void change(View v, ImageView im, String col) {
        ui(v, Color.parseColor(col), 30);
        im.setColorFilter(Color.parseColor(col));
    }

    private static void animate(View v, int dur) {
        new CountDownTimer(dur, 1) {
            @Override public void onTick(long arg0) {}
            @Override public void onFinish() {
                ObjectAnimator animator = new ObjectAnimator();
                animator.setDuration(1000);
    	 	   animator.setFloatValues(0.0f, 1.0f);
    			animator.setPropertyName("alpha");
    			animator.setTarget(v);
    			animator.start();
            }
        }.start();
    }

    private static boolean nightModeON() {
        int flags =
                context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        boolean isNightModeOn = flags == Configuration.UI_MODE_NIGHT_YES;
        if (isNightModeOn) return true;
        else return false;
    }

    private static void ui(View view, int str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(str);
        gradientDrawable.setCornerRadius((float) i);
        view.setBackground(gradientDrawable);
    }

    /*
     *
     *
     *    THIS LIBRARY CREATED BY HUSSEIN SHAKIR (SMITH)
     *
     *	TELEGRAM : @SMITHDEV
     *	YOUTUBE : HUSSEIN SMITH
     *
     *	YOU GUYS ARE NOT ALLOWED TO MODIFY THIS LIBRARY,
     *	WITHOT ANY PERMISSION FROM ME PERSONALLY..
     *	ALL RIGHTS RESERVED © HUSSEIN SHAKIR, 2022.
     *
     *
     */
}
