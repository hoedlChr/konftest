package org.campus02.hoedl;

import java.util.ArrayList;

public class Skiausflug {

    private ArrayList<Person> teilnehmer;
    private int maxTeilnehmerZahl;

    public Skiausflug(int maxTeilnehmerZahl) {
        this.maxTeilnehmerZahl = maxTeilnehmerZahl;
        teilnehmer = new ArrayList<Person>();
    }

    public ArrayList<Person> getTeilnehmer() {
        return teilnehmer;
    }

    public int getMaxTeilnehmerZahl() {
        return maxTeilnehmerZahl;
    }

    public String anmelden(Person p) {
        if (p.getAlter() <= 15) {
            return "Das Mindesalter entspricht 16 Jahren";
        }

        if (teilnehmer.size() == maxTeilnehmerZahl) {
            return "Die maximale Teilnehmerzahl von " + maxTeilnehmerZahl + " kann nicht überschritten werden";
        }

        teilnehmer.add(p);
        return p.getName() + " wurde angemeldet";
    }

    public String abmelden(Person p) {
        if (teilnehmer.remove(p)) {
            return p.getName() + " wurde abgemeldet";
        }
        return "";
    }

    public boolean bezahlen(Person p) {
        p.setBezahlt(true);
        return false;
    }

    public boolean alleBezahlt() {
        for (Person person : teilnehmer) {
            if (!person.isBezahlt()) {
                return false;
            }
        }
        return true;
    }
}
