package fr.utt.if26.soto_cursus;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class ModuleRoomListAdapter extends ListAdapter<ModuleEntity, ModuleRoomViewHolder> {

    public ModuleRoomListAdapter(@NonNull DiffUtil.ItemCallback<ModuleEntity> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ModuleRoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ModuleRoomViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ModuleRoomViewHolder holder, int position) {
        ModuleEntity current = getItem(position);
        holder.bind(current.getSigle(),current.getParcours(),current.getCategorie(), current.getCredit());
    }


    static class ModuleEntityDiff extends DiffUtil.ItemCallback<ModuleEntity> {

        @Override
        public boolean areItemsTheSame(@NonNull ModuleEntity oldItem, @NonNull ModuleEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ModuleEntity oldItem, @NonNull ModuleEntity newItem) {
            return oldItem.getSigle().equals(newItem.getSigle());
        }
    }
}