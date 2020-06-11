package com.example.collectuserdata.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collectuserdata.Adapter.UserAdapter;
import com.example.collectuserdata.R;
import com.example.collectuserdata.ViewModel.UserViewModel;
import com.example.collectuserdata.pojo.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListUserFragment extends Fragment {
    FloatingActionButton addFloatingBtn ;
    private UserViewModel userViewModel ;
    private RecyclerView recyclerView ;
    private TextView emtyListTxt ;


    public ListUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_user, container, false);
        addFloatingBtn = view.findViewById(R.id.add_flt_Btn)    ;
        recyclerView = view.findViewById(R.id.recyclerView);
        emtyListTxt = view.findViewById(R.id.emty_list_txt);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        emtyListTxt.setVisibility(View.GONE);


        final UserAdapter adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);


        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getAllUsers().observe(getActivity(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                         adapter.setUsers(users);

                        if(users==null || users.size()<=0)
                        {

                                emtyListTxt.setVisibility(View.VISIBLE);


                        }


            }
        });

        addFloatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_list_Frg_to_add_Frg);

            }
        });
    return view ;
    }
}
