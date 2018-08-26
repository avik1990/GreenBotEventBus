package in.httpquickkpay.greenboteventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class ChildActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_text;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        et_text = findViewById(R.id.et_text);
        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(this);

        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(CustomMessageEvent event) {
    }

    @Override
    public void onClick(View v) {
        if (v == btn_send) {
            String text = et_text.getText().toString().trim();

            CustomMessageEvent event = new CustomMessageEvent();
            event.setCustomMessage(text);
            EventBus.getDefault().post(event);
            finish();
        }
    }
}
