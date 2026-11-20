package com.vipprosignal.xaud;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {
    private LinearLayout root;
    private TextView status;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buildScreen();
    }

    private TextView label(String text, int size, int color) {
        TextView v = new TextView(this);
        v.setText(text);
        v.setTextSize(size);
        v.setTextColor(color);
        v.setPadding(0, 10, 0, 10);
        return v;
    }

    private void buildScreen() {
        ScrollView scroll = new ScrollView(this);
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 28, 24, 28);
        root.setBackgroundColor(Color.rgb(15, 20, 32));
        scroll.addView(root);

        TextView title = label("VIP PRO SIGNAL XAU-D", 25, Color.WHITE);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        TextView subtitle = label("GOLD • XAU/USD • 15 MIN", 15, Color.rgb(255, 204, 77));
        subtitle.setGravity(Gravity.CENTER);
        root.addView(subtitle);

        status = label("WAIT / DATA NOT CONNECTED", 20, Color.rgb(255, 204, 77));
        status.setGravity(Gravity.CENTER);
        status.setPadding(0, 26, 0, 26);
        root.addView(status);

        addCard("Market", "Gold (XAU/USD)");
        addCard("Timeframe", "15M — primary trend timeframe");
        addCard("Entry", "Unavailable — connect verified live price data");
        addCard("Stop Loss", "Unavailable");
        addCard("Take Profit", "TP1: —     TP2: —     TP3: —");
        addCard("Indicators", "RSI • EMA • Support / Resistance");
        addCard("Data status", "Starter app: live market feed is not connected yet.");

        Button refresh = new Button(this);
        refresh.setText("Refresh analysis");
        refresh.setOnClickListener(v -> {
            status.setText("WAIT / LIVE DATA REQUIRED");
            status.setTextColor(Color.rgb(255, 204, 77));
        });
        root.addView(refresh);

        TextView note = label(
            "Risk notice: This starter version does not generate real trading signals. " +
            "Connect a legitimate live XAU/USD data provider and test the strategy on demo before trading.",
            13, Color.LTGRAY);
        note.setPadding(0, 20, 0, 10);
        root.addView(note);

        setContentView(scroll);
    }

    private void addCard(String heading, String body) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(18, 12, 18, 12);
        card.setBackgroundColor(Color.rgb(28, 36, 52));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 8, 0, 8);
        card.setLayoutParams(params);

        TextView h = label(heading, 14, Color.rgb(255, 204, 77));
        TextView b = label(body, 16, Color.WHITE);
        card.addView(h);
        card.addView(b);
        root.addView(card);
    }
}
