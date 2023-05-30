package sg.edu.rp.c346.id22036150.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView DBS;
    TextView OCBC;
    TextView UOB;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.tvDBS);
        OCBC = findViewById(R.id.tvOCBC);
        UOB = findViewById(R.id.tvUOB);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.main_menu, menu);

        if (v == DBS) {
            wordClicked = "dbs";
        } else if (v == OCBC) {
            wordClicked = "ocbc";
        } else if (v == UOB) {
            wordClicked = "uob";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {//check whether the selected menu item ID is 0
        //code for action
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == R.id.website) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(browserIntent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == R.id.contact) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbsNo)));
                startActivity(callIntent);
                return true;
            } else if (item.getItemId() == R.id.favourite) {
                int color = DBS.getCurrentTextColor();
                Log.d("mytag", "" + color);
                if (color == -65536) {
                    Log.d("mytag", "Toggle1");
                    DBS.setTextColor(Color.parseColor(getString(R.string.black)));
                    OCBC.setTextColor(Color.parseColor(getString(R.string.black)));
                    UOB.setTextColor(Color.parseColor(getString(R.string.black)));
                } else {
                    Log.d("mytag", "Toggle2");
                    DBS.setTextColor(Color.parseColor(getString(R.string.red)));
                    OCBC.setTextColor(Color.parseColor(getString(R.string.black)));
                    UOB.setTextColor(Color.parseColor(getString(R.string.black)));
                }
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == R.id.website) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(browserIntent);
                return true;
            } else if (item.getItemId() == R.id.contact) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.ocbcNo)));
                startActivity(callIntent);
                return true;
            } else if (item.getItemId() == R.id.favourite) {
                int color = OCBC.getCurrentTextColor();
                Log.d("mytag", "" + color);
                if (color == -65536) {
                    Log.d("mytag", "Toggle1");
                    DBS.setTextColor(Color.parseColor(getString(R.string.black)));
                    OCBC.setTextColor(Color.parseColor(getString(R.string.black)));
                    UOB.setTextColor(Color.parseColor(getString(R.string.black)));
                } else {
                    Log.d("mytag", "Toggle2");
                    DBS.setTextColor(Color.parseColor(getString(R.string.black)));
                    OCBC.setTextColor(Color.parseColor(getString(R.string.red)));
                    UOB.setTextColor(Color.parseColor(getString(R.string.black)));
                }
            }

        } else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == R.id.website) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com"));
                startActivity(browserIntent);
                return true;
            } else if (item.getItemId() == R.id.contact) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobNo)));
                startActivity(callIntent);
                return true;
            } else if (item.getItemId() == R.id.favourite) {
                int color = UOB.getCurrentTextColor();
                Log.d("mytag", "" + color);
                if (color == -65536) {
                    Log.d("mytag", "Toggle1");
                    DBS.setTextColor(Color.parseColor(getString(R.string.black)));
                    OCBC.setTextColor(Color.parseColor(getString(R.string.black)));
                    UOB.setTextColor(Color.parseColor(getString(R.string.black)));
                } else {
                    Log.d("mytag", "Toggle2");
                    DBS.setTextColor(Color.parseColor(getString(R.string.black)));
                    OCBC.setTextColor(Color.parseColor(getString(R.string.black)));
                    UOB.setTextColor(Color.parseColor(getString(R.string.red)));
                }

            }

        }

        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText(getString(R.string.dbs));
            OCBC.setText(getString(R.string.ocbc));
            UOB.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.chineseSelection) {
            DBS.setText(getString(R.string.dbsCN));
            OCBC.setText(getString(R.string.ocbcCN));
            UOB.setText(getString(R.string.uobCN));
            return true;
        } else {
            DBS.setText(getString(R.string.errorTran));
            OCBC.setText(getString(R.string.errorTran));
            UOB.setText(getString(R.string.errorTran));
        }

        return super.onOptionsItemSelected(item);
    }
}