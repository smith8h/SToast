package smith.test;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import smith.lib.alerts.toast.AdaptiveSToast;
import smith.lib.alerts.toast.ModeSToast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void show(View v) {
        AdaptiveSToast.with(this)
                      .duration(AdaptiveSToast.LENGTH_SHORT)
                      .icon(R.drawable.heart_img, getColor(R.color.acc))
                      .title("Big Love!")
                      .text("This is Night Mode Adaptive SToast.")
                      .show();
    }
    
    public void show2(View v) {
        ModeSToast.with(this)
                  .duration(ModeSToast.LENGTH_SHORT)
                  .mode(ModeSToast.MODE_CONFUSE)
                  .title("Title")
                  .text("Text")
                  .show();
    }
}
