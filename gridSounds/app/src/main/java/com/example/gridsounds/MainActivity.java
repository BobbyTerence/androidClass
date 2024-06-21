package com.example.gridsounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer[] Images = {R.drawable.eagle, R.drawable.elephant, R.drawable.gorilla, R.drawable.panda,
            R.drawable.yoda, R.drawable.polar, R.drawable.metalpipe, R.drawable.wtf};
    String[] Descrip = {"Eagle", "Elephant", "Gorilla", "Panda",
            "Yoda", "Polar", "Metal Pipe", "Will Flowers"};
    ImageView pic;

    MediaPlayer eagleMp, elepMp, gorilMp, panMp, yodaMp, polarMp, mpMp, wtfMp;
    int oldPos = 99; /*This variable will be used to store the position of the last image clicked in
                    order to pause the previous sound
                    99 is the default value that will be checked*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView grid = (GridView) findViewById(R.id.gridView);
        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);

        //Create MediaPlayer objects
        eagleMp = new MediaPlayer();
        eagleMp = MediaPlayer.create(this, R.raw.eagle);
        elepMp = new MediaPlayer();
        elepMp = MediaPlayer.create(this, R.raw.elephant);
        gorilMp = new MediaPlayer();
        gorilMp = MediaPlayer.create(this, R.raw.gorilla);
        panMp = new MediaPlayer();
        panMp = MediaPlayer.create(this, R.raw.panda);
        yodaMp = new MediaPlayer();
        yodaMp = MediaPlayer.create(this, R.raw.yodadeath);
        polarMp = new MediaPlayer();
        polarMp = MediaPlayer.create(this, R.raw.polarbear);
        mpMp = new MediaPlayer();
        mpMp = MediaPlayer.create(this, R.raw.metalpipe);
        wtfMp = new MediaPlayer();
        wtfMp = MediaPlayer.create(this, R.raw.wtf);

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(oldPos != 99) {
                    switch(oldPos) {
                        case 0:
                            eagleMp.pause();
                            eagleMp.seekTo(0);
                            break;
                        case 1:
                            elepMp.pause();
                            elepMp.seekTo(0);
                            break;
                        case 2:
                            gorilMp.pause();
                            gorilMp.seekTo(0);
                            break;
                        case 3:
                            panMp.pause();
                            panMp.seekTo(0);
                            break;
                        case 4:
                            yodaMp.pause();
                            yodaMp.seekTo(0);
                            break;
                        case 5:
                            polarMp.pause();
                            polarMp.seekTo(0);
                            break;
                        case 6:
                            mpMp.pause();
                            mpMp.seekTo(0);
                            break;
                        case 7:
                            wtfMp.pause();
                            wtfMp.seekTo(0);
                            break;
                        default:
                            break;
                    }
                }

                Toast.makeText(getBaseContext(), "Selected Image " + Descrip[position],
                        Toast.LENGTH_SHORT).show();
                pic.setImageResource(Images[position]);

                //Create a switch case to play the relevant sound file
                switch(position) {
                    case 0:
                        eagleMp.start();
                        oldPos = 0;
                        break;
                    case 1:
                        elepMp.start();
                        oldPos = 1;
                        break;
                    case 2:
                        gorilMp.start();
                        oldPos = 2;
                        break;
                    case 3:
                        panMp.start();
                        oldPos = 3;
                        break;
                    case 4:
                        yodaMp.start();
                        oldPos = 4;
                        break;
                    case 5:
                        polarMp.start();
                        oldPos = 5;
                        break;
                    case 6:
                        mpMp.start();
                        oldPos = 6;
                        break;
                    case 7:
                        wtfMp.start();
                        oldPos = 7;
                        break;
                        default:
                            break;
                }
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return Images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Images[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330, 300));
            return pic;
        }
    }
}