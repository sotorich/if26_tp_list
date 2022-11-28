package fr.utt.if26.soto_cursus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModuleRoomViewHolder extends RecyclerView.ViewHolder {

    private final TextView ModuleRoomSigle;
    private final TextView ModuleRoomParcours;
    private final TextView ModuleRoomCategorie;
    private final TextView ModuleRoomCredit;


    public ModuleRoomViewHolder(@NonNull View itemView) {
        super(itemView);
        ModuleRoomSigle = itemView.findViewById(R.id.module_sigle);
        ModuleRoomParcours = itemView.findViewById(R.id.module_parcours);
        ModuleRoomCategorie = itemView.findViewById(R.id.module_categorie);
        ModuleRoomCredit = itemView.findViewById(R.id.module_credits);
    }

    public void bind(String sigle, String parcours, String categorie,int credit) {
        ModuleRoomSigle.setText(sigle);
        ModuleRoomParcours.setText(parcours);
        ModuleRoomCategorie.setText(categorie);
        ModuleRoomCredit.setText(String.valueOf(credit));
    }

    static ModuleRoomViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.module_item, parent, false);
        return new ModuleRoomViewHolder(view);
    }

}
