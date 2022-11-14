package fr.utt.if26.soto_cursus;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptateurRecyclerModule extends RecyclerView.Adapter<AdaptateurRecyclerModule.ModuleHolder>{

    ArrayList<Module> mesModules;

    AdaptateurRecyclerModule(ArrayList<Module> mesModules)
    {
        this.mesModules = mesModules;
    }

    @Override
    public ModuleHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.module_item, parent, false);
        return new ModuleHolder(view);
    }

    @Override
    public void onBindViewHolder(ModuleHolder holder, int position){
        holder.display(mesModules.get(position));
    }

    @Override
    public int getItemCount() {
        return mesModules.size();
    }

    class ModuleHolder extends RecyclerView.ViewHolder{
        private TextView Modulesigle;
        private TextView Modulecategorie;
        private TextView Moduleparcours;
        private TextView Modulecredits;

        ModuleHolder(View itemView)
        {
            super(itemView);

            Modulesigle = (TextView) itemView.findViewById(R.id.module_sigle);
            Modulecategorie = (TextView) itemView.findViewById(R.id.module_categorie);
            Moduleparcours = (TextView) itemView.findViewById(R.id.module_parcours);
            Modulecredits = (TextView) itemView.findViewById(R.id.module_credits);


        }
        void display(Module module)
        {
            Modulesigle.setText(module.getSigle());
            Modulecategorie.setText(module.getCategorie());
            Moduleparcours.setText(module.getParcours());
            Modulecredits.setText(String.valueOf(module.getCredit()));
        }
    }
}
