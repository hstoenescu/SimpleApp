package simple.eim.systems.cs.pub.ro.simpleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SimpleAppMainActivity extends AppCompatActivity {

    private EditText leftEditText = null;
    private EditText rightEditText = null;
    private Button leftButton = null;
    private Button rightButton = null;

    // create a listener for the buttons
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick (View view) {
            switch (view.getId()) {
                case R.id.press1_button:
                    int leftNumberOfClicks = Integer.parseInt(leftEditText.getText().toString());
                    leftNumberOfClicks++;
                    leftEditText.setText(String.valueOf(leftNumberOfClicks));
                    break;
                case R.id.press2_button:
                    int rightNumberOfClicks = Integer.parseInt(rightEditText.getText().toString());
                    rightNumberOfClicks++;
                    rightEditText.setText(String.valueOf(rightNumberOfClicks));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_app_main);

        /* get the reference to the graphic controller */
        leftEditText = (EditText) findViewById(R.id.left_edit_text);
        rightEditText = (EditText) findViewById(R.id.right_edit_text);
        leftEditText.setText(String.valueOf(0));
        rightEditText.setText(String.valueOf(0));

        /* get the reference of the buttons and a listener to them */
        leftButton = (Button) findViewById(R.id.press1_button);
        rightButton = (Button) findViewById(R.id.press2_button);
        leftButton.setOnClickListener(buttonClickListener);
        rightButton.setOnClickListener(buttonClickListener);
    }
}
