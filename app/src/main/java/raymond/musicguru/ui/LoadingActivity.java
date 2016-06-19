package raymond.musicguru.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import raymond.musicguru.ui.view.QueryActivity;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, QueryActivity.class);
        startActivity(intent);
        finish();
    }
}
