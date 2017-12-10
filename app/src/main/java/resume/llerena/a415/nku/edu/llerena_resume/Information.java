package resume.llerena.a415.nku.edu.llerena_resume;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;


public class Information extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView ResumePic;
    private Button prevButton, nextButton, skillsButton, settingsButton;

    private int imageIndex = 0;
    int[] images = {R.drawable.me, R.drawable.aboutme};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_activity);

        settingsButton = (Button)findViewById(R.id.toSettings);
        ResumePic = (ImageView)findViewById(R.id.PictureView);
        prevButton = (Button)findViewById(R.id.PreviousButton);
        nextButton = (Button)findViewById(R.id.NextButton);
        skillsButton = (Button)findViewById(R.id.ToSkills);

        prevButton.setEnabled(false);


        toolbar = (Toolbar) findViewById(R.id.toolbar_create_contacts);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        prevButton.setOnClickListener(prevButtonImageChangeListener);
        nextButton.setOnClickListener(nextButtonImageChangeListener);
        skillsButton.setOnClickListener(skillsButtonListener);
        settingsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                toSettings();
            }
        });
    }

    public void toSettings(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivityForResult(intent, 0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                System.out.println("Settings symbol clicked. verified.");
                Intent myIntent = new Intent(this, SettingsActivity.class);
                startActivityForResult(myIntent, 0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    View.OnClickListener skillsButtonListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            toSkillsActivity();
        }
    };

    public void toSkillsActivity() {
        Intent intent = new Intent(this, SkillsActivity.class);
        startActivity(intent);

    }

    View.OnClickListener prevButtonImageChangeListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            imageIndex--;
            ResumePic.setImageResource(images[imageIndex]);
            if (imageIndex == 0){
                prevButton.setEnabled(false);
                nextButton.setEnabled(true);
            }

        }
    };

    View.OnClickListener nextButtonImageChangeListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            imageIndex++;
            ResumePic.setImageResource(images[imageIndex]);
            if (imageIndex != 0) {
                prevButton.setEnabled(true);
            }
            if (imageIndex == (images.length-1)){
                nextButton.setEnabled(false);
            }
        }
    };
}
