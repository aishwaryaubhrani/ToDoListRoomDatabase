package com.aishwarya.todolistroomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> notes = new ArrayList<>();


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.priorityTextView.setText(String.valueOf(currentNote.getPriority()));
        holder.titleTextView.setText(currentNote.getTitle());
        holder.descriptionTextView.setText(currentNote.getDescription());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes){
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        private TextView priorityTextView;
        private TextView titleTextView;
        private TextView descriptionTextView;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            priorityTextView = itemView.findViewById(R.id.textViewPriority);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            descriptionTextView = itemView.findViewById(R.id.textViewDescription);

        }
    }
}
