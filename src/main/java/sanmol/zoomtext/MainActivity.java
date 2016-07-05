package sanmol.zoomtext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView scaleGesture;
    ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scaleGesture = (TextView) findViewById(R.id.article);
        scaleGesture.setText("I am zooming Text...");
        scaleGestureDetector = new ScaleGestureDetector(this, new simpleOnScaleGestureListener());


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }

    public class simpleOnScaleGestureListener extends
            ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            float size = scaleGesture.getTextSize();
            float factor = detector.getScaleFactor();
            float product = size * factor;

            scaleGesture.setTextSize(TypedValue.COMPLEX_UNIT_PX, product);

            return true;
        }
    }
}