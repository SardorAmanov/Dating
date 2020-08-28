package com.agile.dating.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.agile.dating.R;
import com.agile.dating.pojo.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private Context context;
    private List<User> users;
    private OnItemClickListener mListener;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
        notifyItemInserted(getItemCount() - 1);
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public UserAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.textViewName.setText(String.format("Имя: %s", user.getName()));
        holder.textViewAge.setText(String.format("Возраст: %s", user.getAge()));

        Picasso.get()
                .load(user.getIurl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imageView;
        private TextView textViewName;
        private TextView textViewAge;

        public UserViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.user_image_item);
            textViewName = itemView.findViewById(R.id.tv_name_item);
            textViewAge = itemView.findViewById(R.id.tv_age_item);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}
