package gamedevelopers.funcandi.taskworkflow.Intro.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import gamedevelopers.funcandi.taskworkflow.Intro.PlayerSelect;
import gamedevelopers.funcandi.taskworkflow.R;

public class MainActivity extends AppCompatActivity {

    private EditText nameField;
    private Button startButton;
    Typeface t;

    Intent i;

    public static char gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_activity_main);

        t = Typeface.createFromAsset(getAssets(), "raleway.ttf");

        i = getIntent();
        gender = i.getCharExtra(PlayerSelect.GENDER, 'G');


        nameField = (EditText)findViewById(R.id.nameEditText);
        startButton = (Button)findViewById(R.id.startButton);

        nameField.setTypeface(t);
        startButton.setTypeface(t);

        startButton.setTextColor(Color.WHITE);

        nameField.setAlpha(0.6f);
        startButton.setAlpha(0.6f);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                startStory(name);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameField.setText("");
    }

    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);
        intent.putExtra(key, name);
        startActivity(intent);
    }
}
