package com.example.projetdev;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> tasksList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasksList);

        ListView tasksListView = findViewById(R.id.tasksListView);
        tasksListView.setAdapter(adapter);

        findViewById(R.id.addTaskButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddTaskDialog();
            }
        });

        tasksListView.setOnItemClickListener((parent, view, position, id) -> showEditTaskDialog(position));
        tasksListView.setOnItemLongClickListener((parent, view, position, id) -> {
            tasksList.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }

    private void showAddTaskDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajouter une tâche");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String taskName = input.getText().toString();
                tasksList.add(taskName);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Annuler", null);

        builder.show();
    }

    private void showEditTaskDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Modifier la tâche");

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.edit_task_dialog, null);
        final EditText input = view.findViewById(R.id.taskNameEditText);
        input.setText(tasksList.get(position));
        builder.setView(view);

        builder.setPositiveButton("Enregistrer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newTaskName = input.getText().toString();
                tasksList.set(position, newTaskName);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Annuler", null);

        builder.show();
    }
}