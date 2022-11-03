package smith.lib.alerts.toast;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import smith.lib.alerts.toast.SToast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void show(View v) {
        new SToast.Adaptive(this, SToast.LONG)
            .setIconAndColor(R.drawable.heart_img, getColor(R.color.acc))
            .setTitle("Big Love!")
            .setText("This is Night Mode Adaptive SToast.")
            .show();
    }
    
    public void show2(View v) {
        new SToast.Mode(this, SToast.LONG)
            .setMode(SToast.MODE_DONE)
            .setTitle("Download Done!")
            .setText("This is Done Mode SToast.")
            .show();
    }
}
