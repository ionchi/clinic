package it.uniroma3.form;

import it.uniroma3.model.Prerequisite;

import java.util.List;

public class PrerequisiteForm {

    private List<Prerequisite> prerequisites;

    public  List<Prerequisite> getPrerequisites() {
        return this.prerequisites;
    }

    public void setPrerequisites(List<Prerequisite> prerequisites) {
        this.prerequisites = prerequisites;
    }
}
