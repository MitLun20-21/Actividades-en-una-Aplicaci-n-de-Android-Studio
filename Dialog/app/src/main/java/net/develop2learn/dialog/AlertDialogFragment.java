package net.develop2learn.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

public class AlertDialogFragment extends DialogFragment
{
static CharSequence[] items = {"Google", "Apple", "Microsoft"};
boolean[] itemsChecked = new boolean[items.length];
static AlertDialogFragment newInstance(String title)
{
    AlertDialogFragment fragment = new AlertDialogFragment();
    Bundle args = new Bundle();
    args.putString("title", title);
    fragment.setArguments(args);
    return fragment;
}

@Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
{
    String title = getArguments().getString("title");
    return new AlertDialog.Builder(getActivity())
            .setIcon(R.mipmap.ic_launcher)
            .setTitle(title)
            .setMultiChoiceItems(items, itemsChecked,
    new DialogInterface.OnMultiChoiceClickListener()
    {
        public void onClick(DialogInterface dialog, int wich, boolean isChecked)
        {
            ((MainActivity) getActivity()).doSelectedItem(wich, isChecked);
        }
    })
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            })
    {
        @Override
                public void onClick (DialogInterface dialog, int wich)
        {
            ((MainActivity) getActivity()).actionClick("OK");
        }
    })
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int wich)
                {
                    ((MainActivity) getActivity()).actionClick("Cancel");
                }
            }) .create();
}

}
