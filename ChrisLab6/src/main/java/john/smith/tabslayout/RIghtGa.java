/*
 * Chris Garcia
 * n01371506
 * Section:0CB
 * */
package john.smith.tabslayout;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Selection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RIghtGa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RIghtGa extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button button2;

    public RIghtGa() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RIghtGa newInstance(String param1, String param2) {
        RIghtGa fragment = new RIghtGa();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        CheckBox checkBox1 = view.findViewById(R.id.checkBox);
        CheckBox checkBox2 = view.findViewById(R.id.checkBox2);
        CheckBox checkBox3 = view.findViewById(R.id.checkBox3);

        TextView Tab2Text = view.findViewById(R.id.Tab2TexView);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String selection = bundle.getString("key");
            Tab2Text.setText(selection);
        }




        button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String CheckedBoxes = "";
                if(checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked()){

                    if(checkBox1.isChecked()) CheckedBoxes += checkBox1.getText().toString() + "\n\n";
                    if(checkBox2.isChecked()) CheckedBoxes += checkBox2.getText().toString()+ "\n\n";
                    if(checkBox3.isChecked()) CheckedBoxes += checkBox3.getText().toString() +"\n\n";
                } else {
                    CheckedBoxes = " NO SPORT";

                }

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Sports Selected");
                builder.setIcon(R.drawable.brazuca);
                builder.setMessage(CheckedBoxes);
                builder.setPositiveButton("Ok", (dialog, which) -> dialog.dismiss());
                builder.setCancelable(false);

                builder.show();


            }
        });

        return view;
    }
}