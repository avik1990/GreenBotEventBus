package in.httpquickkpay.greenboteventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_msg;
    Button launchchkld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_msg = findViewById(R.id.tv_msg);
        launchchkld = findViewById(R.id.launchchkld);
        launchchkld.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void onEvent(CustomMessageEvent event) {
        Log.d("EventFired", "EventFired");
        tv_msg.setText(event.getCustomMessage());
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ChildActivity.class);
        startActivity(i);
    }
}
