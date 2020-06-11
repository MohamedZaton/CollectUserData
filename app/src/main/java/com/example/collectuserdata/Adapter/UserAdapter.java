package com.example.collectuserdata.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collectuserdata.R;
import com.example.collectuserdata.pojo.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> users = new ArrayList<>();


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        User currentUser = users.get(position);
        holder.tv_name.setText( currentUser.getName());
        holder.tv_job.setText("Job : "+currentUser.getJobTitle());
        holder.tv_age.setText("Age : "+currentUser.getAge());
        holder.tv_gender.setText(" - "+currentUser.getGender());
        int imageCode = getImageAgeProf(currentUser.getAge(),currentUser.getGender());
        holder.im_prof.setImageResource(imageCode);






    }


    public int  getImageAgeProf(int age ,String gender )
    {
        if(gender.equals("Female"))
        {
            if(age > 30)
            {
                return R.drawable.girl_1 ;
            }else
            {
                return R.drawable.girl ;
            }
        }else
        {
            if(age > 30)
            {
                return R.drawable.man ;
            }else
            {
                return R.drawable.boy_1 ;
            }

        }
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return users.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {

        private  TextView tv_name ,tv_age , tv_gender , tv_job ;
        private final CircleImageView im_prof;


        public ViewHolder(View view) {
            super(view);

            tv_name = view.findViewById(R.id.name_user_test_view);
            tv_age = view.findViewById(R.id.age_user_txtVw);
            tv_gender = view.findViewById(R.id.gendar_user_txtVw);
            tv_job = view.findViewById(R.id.job_user_text_view);
            im_prof = view.findViewById(R.id.prof_user_image);


        }


    }




}
