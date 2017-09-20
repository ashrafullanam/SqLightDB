package com.example.ashraf.sqlightdb;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterClass extends ArrayAdapter<Student> {

    private String string;
    private Context context;
    private ArrayList<Student> students;

    public AdapterClass(@NonNull Context context, ArrayList<Student> students) {
        super(context, R.layout.list_row, students);
        this.context = context;
        this.students = students;
    }


    private class ViewHolder {
        TextView nameText;
        TextView idText;
        Button sms;

    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            //Toast.makeText(context, ""+position, Toast.LENGTH_LONG).show();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.nameText = (TextView) convertView.findViewById(R.id.nameID);
            viewHolder.idText = (TextView) convertView.findViewById(R.id.phoneID);
            viewHolder.sms = (Button) convertView.findViewById(R.id.ImaPhone);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nameText.setText(students.get(position).getName());
        viewHolder.idText.setText(students.get(position).getPhoneNumber());

        //Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
        viewHolder.sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //string = viewHolder.idText.getText().toString();
                string=students.get(position).getPhoneNumber();
                Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", string, null));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                context.startActivity(intent);

            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,DetailsActivity.class);
                Toast.makeText(context, ""+students.get(position).getId(), Toast.LENGTH_SHORT).show();
                i.putExtra("id",(students.get(position).getId()));
                context.startActivity(i);
            }
        });
        return convertView;
    }

}
