package fr.utt.if26.soto_cursus;

import java.util.ArrayList;
import java.util.Iterator;

public class ProgrammeISI {
    private ArrayList<Module> profil;

    public ProgrammeISI() {
        profil = new ArrayList<Module>();
        init();
    }

    public void ajoute(Module m) {
        profil.add(m);
    }

    public void init() {
        ajoute(new Module("GL02", "TCBR", "CS", 6));
        ajoute(new Module("IF02A","TCBR", "CS", 6));
        ajoute(new Module("IF37", "TCBR", "CS", 6));
        ajoute(new Module("NF16", "TCBR", "CS", 6));
        ajoute(new Module("IF14", "TCBR", "TM", 6));
        ajoute(new Module("LO02", "TCBR", "TM", 6));
        ajoute(new Module("NF19", "TCBR", "TM", 6));
        ajoute(new Module("NF21", "TCBR", "TM", 6));

        ajoute(new Module("IF02", "TCBR", "CS", 6));
        ajoute(new Module("IF08", "TCBR", "CS", 6));
        ajoute(new Module("IF15", "TCBR", "CS", 6));
        ajoute(new Module("LO12", "TCBR", "CS", 6));
        ajoute(new Module("EG23", "TCBR", "TM", 6));
        ajoute(new Module("IF03", "TCBR", "TM", 6));
        ajoute(new Module("LO07", "TCBR", "TM", 6));
        ajoute(new Module("LO17", "TCBR", "TM", 6));

        ajoute(new Module("IF06A","ATN_IPL", "CS", 6));
        ajoute(new Module("IF09", "ATN_IPL", "CS", 3));
        ajoute(new Module("IF10", "IPL_VDC", "CS", 6));
        ajoute(new Module("IF17", "VDC",     "CS", 6));
        ajoute(new Module("IF19", "ATN",     "CS", 6));
        ajoute(new Module("IF20", "ATN", "TM", 6));
        ajoute(new Module("IF26", "IPL", "TM", 6));
        ajoute(new Module("IF28", "VDC", "TM", 6));

        ajoute(new Module("IF05", "IPL", "CS", 6));
        ajoute(new Module("IF22", "ATN", "CS", 6));
        ajoute(new Module("IF29", "VDC", "CM", 6));
        ajoute(new Module("IF36", "ATN_VDC", "CS", 6));
        ajoute(new Module("IF31", "IPL", "TM", 6));
        ajoute(new Module("IF34", "ATN_VDC", "TM", 3));
        ajoute(new Module("LO10", "IPL", "TM", 3));

    }

    public ArrayList<String> getSigles() {
        ArrayList res = new ArrayList();
        Iterator iterateur = profil.iterator();
        while (iterateur.hasNext()) {
            Module m = (Module) (iterateur.next());
            res.add(m.getSigle());
        }
        return res;
    }


    public ArrayList<Module> getModules() {
        System.out.println(profil.toString());
        return profil;
    }
}
