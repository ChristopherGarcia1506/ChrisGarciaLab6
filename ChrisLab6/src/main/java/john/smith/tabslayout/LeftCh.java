/*
 * Chris Garcia
 * n01371506
 * Section:0CB
 * */
package john.smith.tabslayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeftCh#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeftCh extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btn1;
    private RadioGroup radioGroup;

    public LeftCh() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeftCh newInstance(String param1, String param2) {
        LeftCh fragment = new LeftCh();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //---Assigning RadioGroup and button Objects to Variables ---
        radioGroup = view.findViewById(R.id.CHRRadioGroup);
        btn1 = view.findViewById(R.id.CHRbutton);

        //---On Button Clicked Actions
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedRadioBtnId = radioGroup.getCheckedRadioButtonId(); //retrieving ID of selected Button
                RadioButton selectedRadioButton = radioGroup.findViewById(selectedRadioBtnId);//retrieving properties of Selected RadioButton
                String selectedBtnText = selectedRadioButton.getText().toString();
                Toast.makeText(getActivity(),selectedBtnText,Toast.LENGTH_LONG).show();

                Bundle bundle = new Bundle();
                bundle.putString(getString(R.string.bundleKey), selectedBtnText);
                RIghtGa secondFragment = new RIghtGa();
                getParentFragmentManager().setFragmentResult(getString(R.string.requestkey), bundle);


            }
        });

        return view;
    }
}