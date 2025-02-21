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

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Sports Selected");
                builder.setPositiveButton("Ok", (dialog, which) -> dialog.dismiss());
                builder.setCancelable(false);

                builder.show();


            }
        });

        return view;
    }
//    private void alertPopUp () {  // alert popup settings
//        new AlertDialog.Builder(this)
//                .setTitle(R.string.Title)
//                .setIcon(R.drawable.exit)
//                .setMessage(R.string.message)
//                .setPositiveButton(R.string.positive, (dialog, which) -> finish())
//                .setNegativeButton(R.string.negative, (dialog, which) -> dialog.dismiss())
//                .setCancelable(false)
//                .show();
//    }
}