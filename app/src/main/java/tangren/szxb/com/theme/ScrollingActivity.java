package tangren.szxb.com.theme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private MenuItem menuItem = null;

    private static final String TAG = "ScrollingActivity";

    private RecyclerView recyclerView;

    private MyAdapter mAdapter;

    private List<Bean> list = new ArrayList<Bean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        list = getData();
        mAdapter = new MyAdapter(this, list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            if (menuItem != null) {
                String title = (String) menuItem.getTitle();
                if (title.equals("夜间模式"))
                    MyApplication.getIntence().setThemeModel(this, true);
                else
                    MyApplication.getIntence().setThemeModel(this, false);
            }

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        menuItem = menu.findItem(R.id.action_settings);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.getIntence().refershResource(this);
    }


    public List<Bean> getData() {
        for (int i = 0; i < 30; i++) {
            Bean bean = new Bean();
            bean.setString("TITLE" + i);
            list.add(bean);
        }
        return list;
    }
}
