// Generated by view binder compiler. Do not edit!
package com.project.emergencyapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.project.emergencyapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RadioButton aotFa;

  @NonNull
  public final RadioButton aotRa;

  @NonNull
  public final TextView contact;

  @NonNull
  public final TextView name;

  @NonNull
  public final RadioButton others;

  @NonNull
  public final Spinner spinner;

  @NonNull
  public final TextView toa;

  @NonNull
  public final Toolbar toolbar2;

  @NonNull
  public final EditText ucontact;

  @NonNull
  public final EditText uname;

  @NonNull
  public final RadioGroup utoa;

  private ActivityMainBinding(@NonNull RelativeLayout rootView, @NonNull RadioButton aotFa,
      @NonNull RadioButton aotRa, @NonNull TextView contact, @NonNull TextView name,
      @NonNull RadioButton others, @NonNull Spinner spinner, @NonNull TextView toa,
      @NonNull Toolbar toolbar2, @NonNull EditText ucontact, @NonNull EditText uname,
      @NonNull RadioGroup utoa) {
    this.rootView = rootView;
    this.aotFa = aotFa;
    this.aotRa = aotRa;
    this.contact = contact;
    this.name = name;
    this.others = others;
    this.spinner = spinner;
    this.toa = toa;
    this.toolbar2 = toolbar2;
    this.ucontact = ucontact;
    this.uname = uname;
    this.utoa = utoa;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.aot_fa;
      RadioButton aotFa = ViewBindings.findChildViewById(rootView, id);
      if (aotFa == null) {
        break missingId;
      }

      id = R.id.aot_ra;
      RadioButton aotRa = ViewBindings.findChildViewById(rootView, id);
      if (aotRa == null) {
        break missingId;
      }

      id = R.id.contact;
      TextView contact = ViewBindings.findChildViewById(rootView, id);
      if (contact == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.others;
      RadioButton others = ViewBindings.findChildViewById(rootView, id);
      if (others == null) {
        break missingId;
      }

      id = R.id.spinner;
      Spinner spinner = ViewBindings.findChildViewById(rootView, id);
      if (spinner == null) {
        break missingId;
      }

      id = R.id.toa;
      TextView toa = ViewBindings.findChildViewById(rootView, id);
      if (toa == null) {
        break missingId;
      }

      id = R.id.toolbar2;
      Toolbar toolbar2 = ViewBindings.findChildViewById(rootView, id);
      if (toolbar2 == null) {
        break missingId;
      }

      id = R.id.ucontact;
      EditText ucontact = ViewBindings.findChildViewById(rootView, id);
      if (ucontact == null) {
        break missingId;
      }

      id = R.id.uname;
      EditText uname = ViewBindings.findChildViewById(rootView, id);
      if (uname == null) {
        break missingId;
      }

      id = R.id.utoa;
      RadioGroup utoa = ViewBindings.findChildViewById(rootView, id);
      if (utoa == null) {
        break missingId;
      }

      return new ActivityMainBinding((RelativeLayout) rootView, aotFa, aotRa, contact, name, others,
          spinner, toa, toolbar2, ucontact, uname, utoa);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
