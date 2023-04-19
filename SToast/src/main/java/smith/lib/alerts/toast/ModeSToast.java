package smith.lib.alerts.toast;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.widget.Toast;
import android.view.View;
import android.app.Activity;
import android.widget.*;
import android.graphics.Color;

public class ModeSToast {

    public static int LENGTH_LONG = Toast.LENGTH_LONG;
    public static int LENGTH_SHORT = Toast.LENGTH_SHORT;
    
    public static final int MODE_OK = 0;
    public static final int MODE_WARN = 1;
    public static final int MODE_DONE = 2;
    public static final int MODE_ERROR = 3;
    public static final int MODE_INFO = 4;
    public static final int MODE_HEART = 5;
    public static final int MODE_CONFUSE = 6;
    
    private int duration = LENGTH_SHORT;
    private int mode = MODE_INFO;
    private String titleTxt, textTxt;
    private Context context;

    public static ModeSToast with(Context ctx) {
        ModeSToast mst = new ModeSToast();
        mst.context = ctx;
        return mst;
    }
    
    public ModeSToast duration(int dur) {
    	this.duration = dur;
        return this;
    }

    public ModeSToast title(String title) {
        this.titleTxt = title;
        return this;
    }

    public ModeSToast text(String text) {
        this.textTxt = text;
        return this;
    }

    public ModeSToast mode(int mode) {
        this.mode = mode;
        return this;
    }

    public void show() {
        Toast toast = new Toast(context);

        View inflate = ((Activity) context).getLayoutInflater().inflate(R.layout.stoast_modes, null);
        LinearLayout main = (LinearLayout) inflate.findViewById(R.id.main);
        ImageView img = (ImageView) inflate.findViewById(R.id.img);
        TextView title = (TextView) inflate.findViewById(R.id.title);
        TextView desc = (TextView) inflate.findViewById(R.id.desc);

        switch (mode) {
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
        title.setText(titleTxt);
        desc.setText(textTxt);

        animate(img, 230);

        toast.setView(inflate);
        toast.setDuration(duration);
        toast.show();
    }
    
    private static void change(View v, ImageView im, String col) {
        ui(v, Color.parseColor(col), 30);
        im.setColorFilter(Color.parseColor(col));
    }
    
    private static void ui(View view, int str, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(str);
        gradientDrawable.setCornerRadius((float) i);
        view.setBackground(gradientDrawable);
    }
    
    private static void animate(View v, int dur) {
        new CountDownTimer(dur, 1) {
            @Override public void onTick(long d) {}
            @Override public void onFinish() {
                ObjectAnimator animator = new ObjectAnimator();
                animator.setDuration(1000);
    	 	   animator.setFloatValues(0f, 1f);
    			animator.setPropertyName("alpha");
    			animator.setTarget(v);
    			animator.start();
            }
        }.start();
    }
}
