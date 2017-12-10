package resume.llerena.a415.nku.edu.llerena_resume;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import resume.llerena.a415.nku.edu.llerena_resume.Skills;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class SkillsActivity extends AppCompatActivity implements skillsListFragment.OnListFragmentInteractionListener{
    RecyclerView recyclerView;
    RecyclerView.Adapter recycleradapter;
    public static ArrayList<Skills> skillsList;

    android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    skillsListFragment newFragment = new skillsListFragment();

    //fragmentTransaction.replace(R.id.)
    //fragmentTransaction.commit();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recycleView);
        Gson gson = new Gson();

        skillsList = gson.fromJson(loadGSON(), new TypeToken<List<Skills>>(){}.getType());

        int i = 1;

        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);

        recycleradapter = new MySkillRecyclerViewAdapter(skillsList);
        rv.setAdapter(recycleradapter);

    }

    private String loadGSON(){
        String json = null;

        try
        {
            InputStream is = getAssets().open("skills.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public void onListFragmentInteraction(Skills skills) {
    }



    //public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
    //    return inflater.inflate(R.layout.skills_fragment_list, null);
    //};

}
