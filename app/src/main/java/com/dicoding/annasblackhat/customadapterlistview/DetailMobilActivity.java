package com.dicoding.annasblackhat.customadapterlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailMobilActivity extends AppCompatActivity {

    public static String KEY_ITEM = "item";
    private TextView txtDetail;
    private ImageView imgDetail;
    private MobilModel item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mobil);

        getSupportActionBar().setTitle("Detail Mobil");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtDetail = (TextView)findViewById(R.id.txt_detail);
        imgDetail = (ImageView)findViewById(R.id.img_detail);

        item = (MobilModel)getIntent().getSerializableExtra(KEY_ITEM);
        txtDetail.setText(Html.fromHtml(item.getTitle()+" Seharga "+item.getHarga()+"<br>"+
        "di <b>"+item.getLokasi()+"</b>"));

        Picasso.with(DetailMobilActivity.this).load(item.getImage()).into(imgDetail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_mobil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            share();
            return true;
        }
        if (id == R.id.action_home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void share(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, item.getTitle() + " " +
                item.getHarga() + " " + item.getLokasi());
        sendIntent.putExtra(Intent.EXTRA_TITLE, "Jual Mobile Murah");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }
}
