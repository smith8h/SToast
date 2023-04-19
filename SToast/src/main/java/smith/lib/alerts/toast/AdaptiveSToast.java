package smith.lib.alerts.toast;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.view.View;
import android.animation.ObjectAnimator;
import android.widget.*;

public class AdaptiveSToast {

    public static final int LENGTH_LONG = Toast.LENGTH_LONG;
    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;

    private final String DARK = "#212121";
    private final String LIGHT = "#FFFFFF";
    private Context context;
    private String titleTxt, textTxt;
    private int color = 0xFFFF5252;
    private int icon = R.drawable.heart_img;
    private int duration = LENGTH_SHORT;
    
    public static AdaptiveSToast with(Context ctx) {
        AdaptiveSToast ast = new AdaptiveSToast();
        ast.context = ctx;
        return ast;
    }

    public AdaptiveSToast duration(int dur) {
        this.duration = dur;
        return this;
    }

    public AdaptiveSToast title(String title) {
        this.titleTxt = title;
        return this;
    }

    public AdaptiveSToast text(String text) {
        text = text;
        return this;
    }

    public AdaptiveSToast icon(int icon, int iconColor) {
        icon = icon;
        color = iconColor;
        return this;
    }
    
    public AdaptiveSToast icon(int icon, String iconColor) {
        icon = icon;
        color = Color.parseColor(iconColor);
        return this;
    }

    public void show() {
        Toast toast = new Toast(context);

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
        title.setText(titleTxt);
        desc.setText(textTxt);
        img.setImageResource(icon);

        toast.setDuration(duration);
        toast.setView(inflate);
        toast.show();
    }
    
    private static void ui(View view, int str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(str);
        gradientDrawable.setCornerRadius((float) i);
        view.setBackground(gradientDrawable);
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

    private boolean nightModeON() {
        int flags = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        boolean isNightModeOn = flags == Configuration.UI_MODE_NIGHT_YES;
        if (isNightModeOn) return true;
        else return false;
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
