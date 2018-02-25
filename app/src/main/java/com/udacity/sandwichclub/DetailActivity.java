package com.udacity.sandwichclub;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.databinding.ActivityDetailBinding;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

public class DetailActivity extends AppCompatActivity {

  public static final String EXTRA_POSITION = "extra_position";
  private static final int DEFAULT_POSITION = -1;

  private ActivityDetailBinding rootView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    rootView = DataBindingUtil.setContentView(this, R.layout.activity_detail);

    Intent intent = getIntent();
    if (intent == null) {
      closeOnError();
    }

    int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
    if (position == DEFAULT_POSITION) {
      // EXTRA_POSITION not found in intent
      closeOnError();
      return;
    }

    String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
    String json = sandwiches[position];
    Sandwich sandwich = JsonUtils.parseSandwichJson(json);
    if (sandwich == null) {
      // Sandwich data unavailable
      closeOnError();
      return;
    }

    rootView.setSandwich(sandwich);
    setTitle(sandwich.getMainName());
  }

  private void closeOnError() {
    finish();
    Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
  }


  /**
   * Loads an Image by a given String Source to an ImageView. It also can be used for
   * DataBinding.
   */
  @BindingAdapter({"image"})
  public static void loadImage(ImageView view, String image) {
    Picasso.with(view.getContext())
        .load(image)
        .into(view);
  }
}
