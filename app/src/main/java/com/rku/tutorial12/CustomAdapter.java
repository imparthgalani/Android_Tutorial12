package com.rku.tutorial12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.UserViewHolder> {

    private JSONArray jsonArray;

    public CustomAdapter(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    @NonNull
    @Override
    public CustomAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new UserViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            holder.txtId.setText(jsonObject.getString("id"));
            holder.txtUsername.setText(jsonObject.getString("name"));
            holder.txtEmail.setText(jsonObject.getString("email"));

/*          holder.txtUsername.setText(jsonObject.getString("title"));
            holder.txtEmail.setText(jsonObject.getString("completed"));*/
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView txtId, txtUsername, txtEmail;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = (TextView) itemView.findViewById(R.id.txtId);
            txtUsername = (TextView) itemView.findViewById(R.id.txtUsername);
            txtEmail = (TextView) itemView.findViewById(R.id.txtEmail);
        }
    }
}
