package com.cyanogen.unofficial.dashboard.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cyanogen.unofficial.dashboard.R;
import com.cyanogen.unofficial.dashboard.constants.StringConstants;
import com.cyanogen.unofficial.dashboard.util.RestartUI;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.preview_card)
    CardView previewCard;
    @Bind(R.id.apply_card)
    CardView applyThemeCard;
    @Bind(R.id.about_dev_card)
    CardView aboutCard;
    @Bind(R.id.donate_card)
    CardView donationCard;
    @Bind(R.id.contact_dev_card)
    CardView contactDevCard;
    @Bind(R.id.restart_ui_card)
    CardView restartUICard;
    @Bind(R.id.reboot)
    FloatingActionButton rebootButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        initCards();

        rebootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Allow system to reboot?", Snackbar.LENGTH_LONG).setAction(
                        "Ok", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    Process root = Runtime.getRuntime().exec("su -c reboot");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ).show();

            }
        });


    }

    public void initCards() {
        previewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startThemePreviewActivity = new Intent(MainActivity.this, ThemePreviewsActivity.class);
                startActivity(startThemePreviewActivity);

            }
        });

        applyThemeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInstalled(StringConstants.CM_THEME_PACKAGE)) {
                    try {

                        Intent cmThemeOperation = new Intent("android.intent.action.MAIN");
                        cmThemeOperation.setComponent(new ComponentName(StringConstants.CM_THEME_PACKAGE, StringConstants.CM_THEME_PACKAGE_ACTIVITY));
                        startActivity(cmThemeOperation);

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "CM Theme chooser not installed", Toast.LENGTH_SHORT).show();

                    }

                } else {

                    try {
                        Intent cosThemeOperation = new Intent("android.intent.action.MAIN");
                        cosThemeOperation.setComponent(new ComponentName(StringConstants.COS_THEME_PACKAGE, StringConstants
                                .COS_THEME_PACKAGE_ACTIVITY));

                        startActivity(cosThemeOperation);


                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "FDFD", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();


                    }
                }
            }
        });

        aboutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutDev = new Intent(MainActivity.this, AboutDeveloperActivity.class);
                startActivity(aboutDev);
            }
        });
        donationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startDonationActivity = new Intent(MainActivity.this, DonationActivity.class);
                startActivity(startDonationActivity);
            }
        });

        contactDevCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailOperation = new Intent(Intent.ACTION_SEND);
                mailOperation.putExtra(Intent.EXTRA_EMAIL, new String(getResources().getString(R.string.dev_mail)));

                mailOperation.putExtra(Intent.EXTRA_SUBJECT, new String
                        (getResources().getString(R.string.email_subject)));
                mailOperation.setType("text/plain");
                startActivity(Intent.createChooser(mailOperation, "Send email"));

            }
        });


        restartUICard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestartUI.killPackage(StringConstants.PACKAGE_TO_BE_KILLED);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_share:
                Intent shareOperation = new Intent(Intent.ACTION_SEND);

                shareOperation.putExtra(Intent.EXTRA_TEXT, getString(R.string.applink));
                shareOperation.setType("plain/text");
                startActivity(Intent.createChooser(shareOperation, "Share via:"));
                break;
            case R.id.action_rate:

                Intent rateOperation = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(getString(R.string.applink)));
                startActivity(rateOperation);

                break;

            case R.id.action_exit:
                finish();

            default:
                return false;


        }
        return super.onOptionsItemSelected(item);
    }

    public boolean isInstalled(String uri) {
        boolean b = false;
        PackageManager packageManager = getPackageManager();
        try {
            packageManager.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            b = true;
        } catch (PackageManager.NameNotFoundException n) {
            Toast.makeText(getApplicationContext(), "COS Theme chooser not found", Toast.LENGTH_SHORT).show();
            b = false;
        }
        return b;
    }
}
