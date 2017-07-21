package me.lvguowei.espressoexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.UUID;

public class NewTaskFragment extends Fragment {

    private static final String TASK_ID = "task_id";

    private Task taskToEdit;

    private Button actionButton;
    private EditText taskName;
    private EditText taskDescription;
    private TextInputLayout nameInputLayout;

    public NewTaskFragment() {/* required empty constructor */}

    public static NewTaskFragment newInstance() {
        return new NewTaskFragment();
    }

    public static NewTaskFragment newInstance(String taskId) {
        NewTaskFragment f = new NewTaskFragment();
        Bundle args = new Bundle();
        args.putString(TASK_ID, taskId);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_task, container, false);
        actionButton = (Button) v.findViewById(R.id.action_button);
        taskName = (EditText) v.findViewById(R.id.new_task_task_name);
        taskDescription = (EditText) v.findViewById(R.id.new_task_task_desc);
        nameInputLayout = (TextInputLayout) v.findViewById(R.id.new_task_task_name_input_layout);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (taskToEdit == null) {
                    addTask();
                } else {
                    editTask();
                }
            }
        });

        return v;
    }

    private void addTask() {
        if (TextUtils.isEmpty(taskName.getText().toString())) {
            Toast.makeText(getContext(), "Empty name", Toast.LENGTH_LONG).show();
        } else {
            EspressoExampleApplication.taskRepository
                    .put(new Task(UUID.randomUUID().toString(), taskName.getText().toString(), taskDescription.getText().toString(), new Date(System.currentTimeMillis())));
            getFragmentManager().popBackStack();
        }
    }

    private void editTask() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null && getArguments().getStringArrayList(TASK_ID) != null) {
            // go into edit mode
            final String id = getArguments().getString(TASK_ID);
            taskToEdit = EspressoExampleApplication.taskRepository.get(id);

            taskName.setText(taskToEdit.name);
            taskDescription.setText(taskToEdit.description);

            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Edit");
            actionButton.setText("Save");

        }
    }
}
