package com.example.expandrecyclerview_qrcode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expandrecyclerview_qrcode.databinding.ItemRecyclerviewBinding;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHoder> {

    private Context context;
    private ArrayList<Lesson> lessons;
    private ItemRecyclerviewBinding binding;
    private Callback callback;

    public ItemAdapter(Context context, ArrayList<Lesson> lessons) {
        this.context = context;
        this.lessons = lessons;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_recyclerview, parent, false);
        return new ViewHoder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        ViewHoder viewhoder = holder;
        viewhoder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {

        private ItemRecyclerviewBinding binding;

        public ViewHoder(@NonNull ItemRecyclerviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (callback != null && position != RecyclerView.NO_POSITION){
                        callback.onItemClick(lessons.get(position));
                    }
                    boolean expanded = lessons.get(position).isExpanded();
                    // Change the state
                    lessons.get(position).setExpanded(!expanded);
                    // Notify the adapter that item has changed
                    notifyItemChanged(position);
                }
            });
        }

        public void bindData(int position) {
            Lesson lesson = lessons.get(position);
            boolean expanded = lesson.isExpanded();
            if (lesson != null) {
                binding.tvTitle.setText(lesson.getTtTitle());
                binding.tvTime.setText(lesson.getTtTimeStart());
                binding.subLayout.setVisibility(expanded ? View.VISIBLE : View.GONE);
                binding.tvInfo.setText(lesson.getTtInfo());
                String duration = lesson.getTtTimeStart() + " - "+lesson.getTtTimeEnd();
                binding.tvDurationTime.setText(duration);
            }
        }


    }
    public interface Callback {
        void onItemClick(Lesson  lesson);
    }
    public void setOnClickListener(Callback callback){
        this.callback = callback;
    }
}
