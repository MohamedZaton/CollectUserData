package com.example.collectuserdata.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.collectuserdata.R;
import com.example.collectuserdata.ViewModel.UserViewModel;
import com.example.collectuserdata.pojo.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {
   public RadioGroup radioGroup;
    public RadioButton genderReadioBtn ;
    public  Button addBtn;

    public  EditText nameEdtxt , ageEdtxt , jobEdtxt;
    private UserViewModel userViewModel;




    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_add_user, container, false);

        radioGroup = view.findViewById(R.id.toggle_gender);
        addBtn = view.findViewById(R.id.add_btn);
        nameEdtxt = view.findViewById(R.id.name_edit_txt);
        ageEdtxt = view.findViewById(R.id.age_edit_txt);
        jobEdtxt = view.findViewById(R.id.job_edit_txt);
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText[] editTextALL = {nameEdtxt,ageEdtxt,jobEdtxt};
                int selectedId = radioGroup.getCheckedRadioButtonId();
                genderReadioBtn =  view.findViewById(selectedId);


                if(isFullEditText(editTextALL) && valdatAge(ageEdtxt))
                {

                    String uName = nameEdtxt.getText().toString();
                    int uAge = Integer.parseInt(ageEdtxt.getText().toString());
                    String uJob = jobEdtxt.getText().toString() ;
                    String uGender =  genderReadioBtn.getText().toString();

                    User user = new User(uName,uJob,uGender,uAge);
                    userViewModel.insert(user);
                    cleanFields();
                    Navigation.findNavController(v).navigate(R.id.action_back_add_Frg_to_list_Frg);


                }


            }
        });

        return  view ;
    }


    private void  cleanFields()
        {
            nameEdtxt.getText().clear();
            ageEdtxt.getText().clear();
            jobEdtxt.getText().clear();
        }

    private   boolean valdatAge (EditText ageEt)
    {
        String ageStr = ageEt.getText().toString() ;
        if(ageStr.length()>=3)
        {
            ageEdtxt.setError("Must by the maximum  3 digit ");
            return  false;
        }
        else if (ageStr.charAt(0) == '0')
        {
            ageEdtxt.setError("age not start 0");
            return  false;
        }
        return true ;


    }
    private   boolean isFullEditText(EditText[] editTextList )
    {
        int i = 0 ;
        boolean isAllWrote = true;

        for (EditText itemEdt : editTextList)
        {
            if (itemEdt.getText().toString().matches(""))
            {
                itemEdt.setError("You must full this item ");
                isAllWrote = false;
            }
            i++;
        }
        return  isAllWrote;

    }

}
